package com.ty.sportclubboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.sportclubboot.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
