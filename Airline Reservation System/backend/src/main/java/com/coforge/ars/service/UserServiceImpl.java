package com.coforge.ars.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.ars.exception.UserAlreadyExistsException;
import com.coforge.ars.exception.UserNotFoundException;
import com.coforge.ars.model.User;
import com.coforge.ars.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService {

	private UserRepo repo;
	private Environment environment;

	@Autowired
	public UserServiceImpl(UserRepo repo, Environment environment) {
		this.repo = repo;
		this.environment = environment;
	}

	@Override
	public boolean saveUser(User user) {

		if (repo.existsByEmail(user.getEmail())) {
			throw new UserAlreadyExistsException(
					environment.getProperty("user.invalid.email"));
		}

		if (user.getRole().equalsIgnoreCase("ADMIN")) {

			if (repo.findByRole("ADMIN").isPresent()) {
				throw new UserAlreadyExistsException(
						environment.getProperty("user.invalid.admin"));
			}
		}

		repo.save(user);
		return true;
	}

	@Override
	public boolean updateUser(Integer userId, User user) {

		if (!repo.existsById(userId)) {
			throw new UserNotFoundException(
					environment.getProperty("user.invalid.notfound"));
		}

		user.setUserId(userId);
		repo.save(user);
		return true;
	}

	@Override
	public boolean deleteUserById(Integer userId) {

		if (!repo.existsById(userId)) {
			throw new UserNotFoundException(
					environment.getProperty("user.invalid.notfound"));
		}

		repo.deleteById(userId);
		return true;
	}

	@Override
	public Optional<User> findByUserId(Integer userId) {

		if (!repo.existsById(userId)) {
			throw new UserNotFoundException(
					environment.getProperty("user.invalid.notfound"));
		}

		return repo.findById(userId);
	}

	@Override
	public List<User> findAllUsers() {
		return (List<User>) repo.findAll();
	}

	@Override
	public Optional<User> login(String email, String password) {

		Optional<User> user = repo.findByEmail(email);

		if (user.isEmpty()) {
			throw new UserNotFoundException(
					environment.getProperty("user.invalid.login"));
		}

		if (!user.get().getPassword().equals(password)) {
			throw new UserNotFoundException(
					environment.getProperty("user.invalid.login"));
		}

		return user;
	}
}