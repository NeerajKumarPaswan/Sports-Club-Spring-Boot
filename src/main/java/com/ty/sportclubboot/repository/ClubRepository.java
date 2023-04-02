package com.ty.sportclubboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.sportclubboot.dto.Club;


public interface ClubRepository extends JpaRepository<Club, Integer> {

}
