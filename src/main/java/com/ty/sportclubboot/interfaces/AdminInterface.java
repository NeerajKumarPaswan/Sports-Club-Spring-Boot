package com.ty.sportclubboot.interfaces;

import java.util.List;

import com.ty.sportclubboot.dto.Admin;



public interface AdminInterface 
{
	 public Admin saveAdmin(Admin admin);
	 
	 public List<Admin> getAllAdmin();
	 
	 public Admin updateAdmin(int id,Admin admin);
	 
	 
	 public Admin getAdminById( int id);

}
