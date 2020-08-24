package com.gaurav.service;

import java.util.List;

import com.gaurav.model.AdminModel;

public interface IAdminService {
	
	public Boolean saveAdmin(AdminModel form);
	public List<AdminModel>  getAllAccount();
	public AdminModel   getAccountById(Integer id);
	public Boolean   deleteAccountById(Integer id);
	
	public AdminModel getAccountDetailsBytempPwd(String pazzword,String email);
	public Boolean updateAccountData(AdminModel form);

}
