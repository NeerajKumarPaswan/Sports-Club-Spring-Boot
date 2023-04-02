package com.ty.sportclubboot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.sportclubboot.dto.Club;
import com.ty.sportclubboot.interfaces.ClubInterface;
import com.ty.sportclubboot.repository.ClubRepository;

@Repository
public class ClubDao implements ClubInterface {
	@Autowired
	ClubRepository clubRepository;

	public Club saveClub(Club club) {
		return clubRepository.save(club);
	}

	public Club getClubById(int id) {
		Optional<Club> opt = clubRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return opt.get();
		}
	}

}
