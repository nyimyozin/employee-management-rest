package com.pita_b2.employee.rest.model;

import lombok.Getter;
import lombok.Setter;

public class AccountModel {
	
	@Getter
	@Setter
	private String username;
	
	@Getter
	@Setter
	private String password;
	
	@Getter
	@Setter
	private boolean isEnabled;
	
	@Getter
	@Setter
	private String authority;
}
