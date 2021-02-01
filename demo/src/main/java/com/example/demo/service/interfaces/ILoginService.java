package com.example.demo.service.interfaces;

import org.springframework.stereotype.Component;

//@Component
public interface ILoginService {

	boolean validateUser(String name, String pass);
}
