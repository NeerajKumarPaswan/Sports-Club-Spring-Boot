package com.ty.sportclubboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.sportclubboot.dto.Club;
import com.ty.sportclubboot.dto.ResponseStructure;
import com.ty.sportclubboot.service.ClubService;

@RestController
public class ClubController {
	@Autowired
	ClubService clubService;

	@PostMapping("/clubs")
	public ResponseStructure<Club> saveClub(@RequestBody Club club) {
		return clubService.saveClub(club);
	}
	
	//get club by id
	@GetMapping("/clubs/{id}")
	public ResponseStructure<Club> getClubById(@PathVariable int id) {
		return clubService.getClubById(id);
		
	}
	
}
