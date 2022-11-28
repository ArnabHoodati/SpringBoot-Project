package com.ems.seviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Login;
import com.ems.repositary.LoginRepository;
import com.ems.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginrepository;

	@Override
	public Login loginE(String userName, String password) {
		Login user = loginrepository.findByUserNameAndPassword(userName, password);
		return user;
	}

}
