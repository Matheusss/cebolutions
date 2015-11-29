package com.cebolutions.top.car.repository;

import org.springframework.data.repository.CrudRepository;

import com.cebolutions.top.car.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);

	User findByUsername(String user);
}
