package com.coforge.ars.repo;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.ars.model.User;


@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);

	Optional<User> findByRole(String role);

}