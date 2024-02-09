package com.pita_b2.employee.rest.service.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pita_b2.employee.rest.model.AccountModel;
import com.pita_b2.employee.rest.repository.LoginRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountModel accountModel = loginRepository.loginProcess(username);
		return new User(accountModel.getUsername(), accountModel.getPassword(), new ArrayList<>());
	}
}
