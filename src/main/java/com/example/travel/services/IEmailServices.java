package com.example.travel.services;

public interface IEmailServices {

	void sendRegistrationUserConfim(String email);
	
	void sendResetPassWord(String email) throws Exception;
}
