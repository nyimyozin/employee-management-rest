package com.pita_b2.employee.rest.repository;

import org.springframework.stereotype.Repository;

import com.pita_b2.employee.rest.model.AccountModel;

@Repository
public interface LoginRepository {
	public AccountModel loginProcess(String username);
}
