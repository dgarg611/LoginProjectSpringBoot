package com.dpk.repository;

import org.springframework.data.repository.CrudRepository;

import com.dpk.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
