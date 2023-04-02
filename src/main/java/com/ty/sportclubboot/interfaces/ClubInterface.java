package com.ty.sportclubboot.interfaces;

import com.ty.sportclubboot.dto.Club;

public interface ClubInterface {
	 public Club saveClub(Club club);
	 
	 public Club getClubById( int id);

}
