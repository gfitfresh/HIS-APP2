package com.gaurav.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurav.entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Serializable> {	
	
	public AdminEntity findByPasswordAndEmail(String pazzword,String email);
	
}
