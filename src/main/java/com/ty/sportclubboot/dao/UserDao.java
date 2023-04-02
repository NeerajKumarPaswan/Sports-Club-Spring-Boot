package com.ty.sportclubboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.sportclubboot.dto.Club;
import com.ty.sportclubboot.dto.User;
import com.ty.sportclubboot.interfaces.UserInterface;
import com.ty.sportclubboot.repository.ClubRepository;
import com.ty.sportclubboot.repository.UserRepository;
@Repository
public class UserDao implements UserInterface{
	@Autowired
	UserRepository userRepository;
	@Autowired
	ClubRepository clubRepository;
	@Override
	 public User saveUser(User user) {
			return userRepository.save(user);
		}
	 
	@Override
		public User getUserById( int id) {
			Optional<User> opt=userRepository.findById(id);
			if(opt.isEmpty()) {
				return null;
			}else {
				return opt.get();
			}
		}
	@Override
		public List<Club> getAllEvents(){
			return clubRepository.findAll();
		}
		

	 
	 
	 
}
