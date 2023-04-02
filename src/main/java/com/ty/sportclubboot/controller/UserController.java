package com.ty.sportclubboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.sportclubboot.dao.ClubDao;
import com.ty.sportclubboot.dao.UserDao;
import com.ty.sportclubboot.dto.Club;
import com.ty.sportclubboot.dto.ResponseStructure;
import com.ty.sportclubboot.dto.User;
import com.ty.sportclubboot.service.UserService;
@RestController
public class UserController {
@Autowired
	UserService userService;

@Autowired
  ClubDao clubDao;
@Autowired
UserDao userDao;

@PostMapping("/users")
public ResponseStructure<User> saveUser(@RequestBody User user) {
	return userService.saveUser(user);
}

@GetMapping("/users/{id}")
public ResponseStructure<User> getUserById(@PathVariable int id) {
	return userService.getUserById(id);	
}
//Book an event by event id and user id
@PostMapping("/usersclubs/{id}/{id2}")
public ResponseStructure<Club> saveEventById(@PathVariable int id,@PathVariable int id2){
	Club club= clubDao.getClubById(id);
	
	User user=userDao.getUserById(id2);
		return userService.saveClubSlot(club, user);
   
	}


//Cancel Booking

@PostMapping("/usersclub/{id}/{id2}")
public ResponseStructure<Club> leaveEventById(@PathVariable int id,@PathVariable int id2){
	Club club= clubDao.getClubById(id);
	User user=userDao.getUserById(id2);
	
	return userService.leaveClubSlot(club, user);
	}

@GetMapping("/users")
public ResponseStructure<List<Club>> getAllEvents(){
	return userService.getAllEvents();
}

}
