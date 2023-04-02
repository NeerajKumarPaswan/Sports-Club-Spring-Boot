package com.ty.sportclubboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.sportclubboot.dao.ClubDao;
import com.ty.sportclubboot.dto.Club;
import com.ty.sportclubboot.dto.ResponseStructure;

@Service
public class ClubService {
	@Autowired
	ClubDao clubDao;
	  
    public ResponseStructure<Club> saveClub(Club club) {
		ResponseStructure<Club> responseStructure = new ResponseStructure<Club>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(clubDao.saveClub(club));
		return responseStructure;
	}

	public ResponseStructure<Club> getClubById(int id) {
 		Club club = clubDao.getClubById(id);
 		ResponseStructure<Club> responseStructure = new ResponseStructure();
 		if (club != null) {
 			responseStructure.setStatusCode(HttpStatus.OK.value());
 			responseStructure.setMessage("success");
 			responseStructure.setData(club);

 		} else {
 			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
 			responseStructure.setMessage("club Id Does not exist");
 			responseStructure.setData(null);

 		}
 		return responseStructure;
 	}

}
