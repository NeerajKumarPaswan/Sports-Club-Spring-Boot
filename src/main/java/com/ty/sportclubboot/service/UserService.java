package com.ty.sportclubboot.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.sportclubboot.dao.ClubDao;
import com.ty.sportclubboot.dao.UserDao;
import com.ty.sportclubboot.dto.Club;
import com.ty.sportclubboot.dto.ResponseStructure;
import com.ty.sportclubboot.dto.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	@Autowired
	ClubDao clubDao;

	public ResponseStructure<User> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(userDao.saveUser(user));
		return responseStructure;
	}

	public ResponseStructure<User> getUserById(int id) {
		User user = userDao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure();
		if (user != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(user);

		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("User Id Does not exist");
			responseStructure.setData(null);

		}
		return responseStructure;
	}

	int count = 0;
	int entryid = 0;

	public ResponseStructure<Club> saveClubSlot(Club club, User user) {
		ResponseStructure<Club> responseStructure = new ResponseStructure();
		ResponseStructure<User> responseStructure2 = new ResponseStructure();
		if (user != null && club.getEntrySlot() == null && count == 0) {
			entryid = user.getId();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure2.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Club Booked successfully");
			responseStructure2.setMessage("User sucess");
			club.setStatus("Booked");
			club.setEntrySlot(LocalDateTime.now());
			club.setUser(user);
			user.setClub(club);
			responseStructure.setData(clubDao.saveClub(club));
			responseStructure2.setData(userDao.saveUser(user));
			count++;

		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure2.setStatusCode(HttpStatus.NOT_FOUND.value());

			responseStructure.setMessage("Club is Booked Already wait for the event to end");
			responseStructure2.setMessage("User Id Does not exist");

			responseStructure.setData(null);
			responseStructure2.setData(null);

		}

		return responseStructure;
	}

	public ResponseStructure<Club> leaveClubSlot(Club club, User user) {
		ResponseStructure<Club> responseStructure = new ResponseStructure();
		ResponseStructure<User> responseStructure2 = new ResponseStructure();
		if (user != null && club.getEntrySlot() != null && user.getId() == entryid) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure2.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Club " + club.getName() + " ended successfully");
			responseStructure2.setMessage("User sucess");
			club.setStatus("Request Reset");
			club.setExitSlot(LocalDateTime.now());
			club.setUser(user);
			user.setClub(club);
			responseStructure.setData(clubDao.saveClub(club));
			responseStructure2.setData(userDao.saveUser(user));

		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure2.setStatusCode(HttpStatus.NOT_FOUND.value());

			responseStructure.setMessage("Club is not Booked by you");
			responseStructure2.setMessage("User Id Does not exist");

			responseStructure.setData(null);
			responseStructure2.setData(null);

		}
		return responseStructure;
	}

	public ResponseStructure<List<Club>> getAllEvents() {
		List<Club> clubs = userDao.getAllEvents();
		ResponseStructure<List<Club>> responseStructure = new ResponseStructure<List<Club>>();
		if (clubs != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(clubs);

		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("No events to show");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
}
