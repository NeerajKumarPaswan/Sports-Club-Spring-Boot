package com.ty.sportclubboot.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.sportclubboot.dao.AdminDao;
import com.ty.sportclubboot.dao.ClubDao;
import com.ty.sportclubboot.dao.UserDao;
import com.ty.sportclubboot.dto.Admin;
import com.ty.sportclubboot.dto.Club;
import com.ty.sportclubboot.dto.ResponseStructure;
import com.ty.sportclubboot.dto.User;

@Service
public class AdminService {
     @Autowired
	AdminDao adminDao;
     @Autowired
     UserDao userDao;
     @Autowired
     ClubDao clubDao;
     
     public ResponseStructure<Admin> saveAdmin(Admin admin) {
 		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
 		responseStructure.setStatusCode(HttpStatus.CREATED.value());
 		responseStructure.setMessage("Success");
 		responseStructure.setData(adminDao.saveAdmin(admin));
 		return responseStructure;
 	}
     
     public ResponseStructure<List<Admin>> getAllAdmin() {
 		List<Admin> admins = adminDao.getAllAdmin();
 		ResponseStructure<List<Admin>> responseStructure = new ResponseStructure<List<Admin>>();
 		if (admins != null) {
 			responseStructure.setStatusCode(HttpStatus.OK.value());
 			responseStructure.setMessage("success");
 			responseStructure.setData(admins);

 		} else {
 			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
 			responseStructure.setMessage("Admin Id Does not exist");
 			responseStructure.setData(null);
 		}
 		return responseStructure;
 	}

 	public ResponseStructure<Admin> updateAdmin(int id, Admin admin) {
 		Admin admin2 = adminDao.getAdminById(id);
 		ResponseStructure<Admin> responseStructure = new ResponseStructure();
 		if (admin2 != null) {
 			responseStructure.setStatusCode(HttpStatus.CREATED.value());
 			responseStructure.setMessage("Success");
 			responseStructure.setData(adminDao.updateAdmin(id, admin2));
 		} else {
 			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
 			responseStructure.setMessage("Not found Admin id");
 			responseStructure.setData(null);

 		}
 		return responseStructure;
 	}

 	public ResponseStructure<Admin> getAdminById(int id) {
 		Admin admin = adminDao.getAdminById(id);
 		ResponseStructure<Admin> responseStructure = new ResponseStructure();
 		if (admin != null) {
 			responseStructure.setStatusCode(HttpStatus.OK.value());
 			responseStructure.setMessage("success");
 			responseStructure.setData(admin);

 		} else {
 			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
 			responseStructure.setMessage("Admin Id Does not exist");
 			responseStructure.setData(null);

 		}
 		return responseStructure;
 	}
 	
 	public ResponseStructure<Club> resetClubSlot(Club club,User user){
 		ResponseStructure<Club> responseStructure = new ResponseStructure();
 		ResponseStructure<User> responseStructure2 = new ResponseStructure();
     if(user!=null && club.getEntrySlot()!=null && club.getExitSlot()!=null) {
 			responseStructure.setStatusCode(HttpStatus.OK.value());
        	responseStructure2.setStatusCode(HttpStatus.OK.value());
        	responseStructure.setMessage("Hope you enjoyed the Game");
        	responseStructure2.setMessage("User sucess");
        	club.setEntrySlot(null);
        	club.setExitSlot(null);
        	club.setStatus("Available");
        	club.setUser(null);
        	user.setClub(null);
            responseStructure.setData(clubDao.saveClub(club));
            responseStructure2.setData(userDao.saveUser(user));
        
     }else {
    	 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
    	 responseStructure2.setStatusCode(HttpStatus.NOT_FOUND.value());

    	 responseStructure.setMessage("Reset Already Done or the Booking is in progress");
    	 responseStructure2.setMessage("User Id Does not exist");

    	 responseStructure.setData(null);
    	 responseStructure2.setData(null);

     }
         return responseStructure;
 	}
  
}
