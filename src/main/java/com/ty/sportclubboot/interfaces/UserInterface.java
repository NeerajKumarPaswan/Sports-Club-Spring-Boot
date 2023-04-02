package com.ty.sportclubboot.interfaces;

import java.util.List;

import com.ty.sportclubboot.dto.Club;
import com.ty.sportclubboot.dto.User;

public interface UserInterface {

	public User saveUser(User user);
	
	public User getUserById( int id);
	
	public List<Club> getAllEvents();
}
