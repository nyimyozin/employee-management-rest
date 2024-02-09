package com.pita_b2.employee.rest.config;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pita_b2.employee.rest.service.serviceImpl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/login").anonymous()
				.antMatchers("/swagger-ui/**", "/swagger-resources/**", "/webjars/**","/v3/api-docs", "/v3/api-docs.yaml", "/v2/api-docs", "/v2/api-docs.yaml").permitAll()
				.antMatchers(HttpMethod.GET,"/index").permitAll()
				.anyRequest().authenticated()
			.and()
				.httpBasic()
			.and()
				.formLogin()
				.usernameParameter("username")
				.passwordParameter("password")
				.successHandler(new AuthenticationSuccessHandler() {
					
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
				        
						Map<String, Object> responseData = new HashMap<>();
				        responseData.put("username", request.getParameter("username"));
				        responseData.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
				        responseData.put("status", HttpServletResponse.SC_OK);
				        responseData.put("message", "Authentication Success");
				        responseData.put("JSESSIONID & remember-me", response.getHeaders("Set-Cookie").toArray());
				        
				        OutputStream out = response.getOutputStream();
				        ObjectMapper mapper = new ObjectMapper();
				        mapper.writeValue(out, responseData);
					}
				})
				.failureHandler(new AuthenticationFailureHandler() {
					
					@Override
					public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
							AuthenticationException exception) throws IOException, ServletException {
						response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				        
				        Map<String, Object> responseData = new HashMap<>();
				        responseData.put("username", request.getParameter("username"));
				        responseData.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
				        responseData.put("status", HttpServletResponse.SC_UNAUTHORIZED);
				        responseData.put("message", "Authentication failed");

				        OutputStream out = response.getOutputStream();
				        ObjectMapper mapper = new ObjectMapper();
				        mapper.writeValue(out, responseData);
					}
				})
			.and()
				.rememberMe()
				.key("uniqueKey")
				.tokenValiditySeconds(3600)
				.userDetailsService(userDetailsServiceImpl)
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessHandler(new LogoutSuccessHandler() {
					
					@Override
					public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
							throws IOException, ServletException {
						response.setStatus(HttpServletResponse.SC_OK);
				        
				        Map<String, Object> responseData = new HashMap<>();
				        responseData.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
				        responseData.put("status", HttpServletResponse.SC_OK);
				        responseData.put("message", "Log Out Succeed");

				        OutputStream out = response.getOutputStream();
				        ObjectMapper mapper = new ObjectMapper();
				        mapper.writeValue(out, responseData);
					}
				})
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID", "remember-me")
			.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		
		return http.build();
	}
}
