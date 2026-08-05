package com.coforge.ars.service;

import java.util.List;

import java.util.Optional;

import com.coforge.ars.model.User;


public interface UserService {

	boolean saveUser(User user);

	boolean updateUser(Integer userId, User user);

	boolean deleteUserById(Integer userId);

	Optional<User> findByUserId(Integer userId);

	List<User> findAllUsers();

	Optional<User> login(String email, String password);

}