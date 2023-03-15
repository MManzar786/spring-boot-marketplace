package app.service;

import org.springframework.beans.factory.annotation.Autowired;

import app.repository.UserRepository;

public class UserService{

	@Autowired
    private UserRepository repository;


}
