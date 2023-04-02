package com.ty.sportclubboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.sportclubboot.dao.ClubDao;
import com.ty.sportclubboot.dao.UserDao;
import com.ty.sportclubboot.dto.Admin;
import com.ty.sportclubboot.dto.Club;
import com.ty.sportclubboot.dto.ResponseStructure;
import com.ty.sportclubboot.dto.User;
import com.ty.sportclubboot.service.AdminService;
import com.ty.sportclubboot.service.ClubService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	ClubService clubService;
	@Autowired
	ClubDao clubDao;
	@Autowired
	UserDao userDao;

	@PostMapping("/admins")
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	// Saving Events name by the Admin
	@PostMapping("/adminsclub")
	public ResponseStructure<Club> saveClubByAdmin(@RequestBody Club club) {
		System.out.println("All good");
		return clubService.saveClub(club);
	}

	// Reset Booking status to normal and make it available to other users
	// Cancel Booking
	@PostMapping("/adminreset/{id}")
	public ResponseStructure<Club> resetEventById(@PathVariable int id) {
		Club club = clubDao.getClubById(id);
		User user = club.getUser();
		return adminService.resetClubSlot(club, user);
	}

	@GetMapping("/admins")
	public ResponseStructure<List<Admin>> getAllAdmin() {
		return adminService.getAllAdmin();
	}

	@GetMapping("/admins/{id}")
	public ResponseStructure<Admin> getAdminById(@PathVariable int id) {
		return adminService.getAdminById(id);

	}

	@PutMapping("/admins/{id}")
	public ResponseStructure<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
		return adminService.updateAdmin(id, admin);
	}

}
