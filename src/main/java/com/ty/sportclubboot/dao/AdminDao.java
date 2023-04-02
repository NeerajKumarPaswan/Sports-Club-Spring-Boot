package com.ty.sportclubboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.sportclubboot.dto.Admin;
import com.ty.sportclubboot.interfaces.AdminInterface;
import com.ty.sportclubboot.repository.AdminRepository;


@Repository
public class AdminDao implements AdminInterface {
	@Autowired
	AdminRepository adminRepository;

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	public Admin updateAdmin(int id, Admin admin) {
		Optional<Admin> opt = adminRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return adminRepository.save(admin);

		}
	}

	public Admin getAdminById(int id) {
		Optional<Admin> opt = adminRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return opt.get();
		}
	}
}
