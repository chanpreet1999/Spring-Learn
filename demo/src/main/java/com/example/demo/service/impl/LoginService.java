package com.example.demo.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.service.interfaces.ILoginService;

@Service
public class LoginService implements ILoginService {

	@Override
	public boolean validateUser(String name, String password)
	{
		return ( "chan".equals(name) && "pass".equals(password) ) || ( "manan".equals(name) && "pass".equals(password) ) ;
	}
}
