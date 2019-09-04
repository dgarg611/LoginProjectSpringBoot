package com.dpk.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dpk.model.User;
import com.dpk.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public void saveMyUser(User user) {
		userRepository.save(user);
	}
	
	public java.util.List<User> showAllUsers()
	{
		java.util.List<User> arrayListOfUsers=new ArrayList<User>();
		for(User user : userRepository.findAll())
		{
			arrayListOfUsers.add(user);
		}
		return arrayListOfUsers;
	}
	public void deleteMyUser(int id)
	{
		userRepository.deleteById(id);
	}
	public User editUser(int id)
	{
		return userRepository.findById(id).get();
	}
}
