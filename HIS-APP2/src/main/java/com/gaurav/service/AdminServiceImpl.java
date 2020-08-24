package com.gaurav.service;

import static com.gaurav.constants.ApplicationConstants.lockedStatusStart;
import static com.gaurav.constants.ApplicationConstants.lockedStatusEnd;
import static com.gaurav.constants.ApplicationConstants.size;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.entity.AdminEntity;
import com.gaurav.model.AdminModel;
import com.gaurav.repository.AdminRepository;
import com.gaurav.utils.PwdUtility;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminRepository repo;

	@Override
	public Boolean saveAdmin(AdminModel form) {
		Boolean isSave = false;
		form.setPassword(PwdUtility.randomPwdGen(size));
		form.setAccStatus(lockedStatusStart);
		AdminEntity entity = new AdminEntity();
		BeanUtils.copyProperties(form, entity);
		repo.save(entity);
		isSave = true;
		return isSave;
	}

	@Override
	public List<AdminModel> getAllAccount() {
		List<AdminModel> accountList = null;

		List<AdminEntity> findAllAccount = repo.findAll();

		accountList = findAllAccount.stream().map(entity -> {
			AdminModel bind = new AdminModel();
			BeanUtils.copyProperties(entity, bind);
			return bind;
		}).collect(Collectors.toList());

		return accountList;
	}

	@Override
	public AdminModel getAccountById(Integer id) {
		AdminModel bind = null;

		Optional<AdminEntity> findById = repo.findById(id);
		if (findById.isPresent()) {
			AdminEntity entity = findById.get();
			bind = new AdminModel();
			BeanUtils.copyProperties(entity, bind);
			return bind;
		}

		return null;
	}

	@Override
	public Boolean deleteAccountById(Integer id) {
		Boolean isdelete = false;
		repo.deleteById(id);
		isdelete = true;
		return isdelete;
	}

	@Override
	public AdminModel getAccountDetailsBytempPwd(String pazzword, String email) {
		AdminEntity findByPassword = repo.findByPasswordAndEmail(pazzword,email);
		AdminModel form = null;
		
		if(findByPassword != null) {
			form = new AdminModel();
			BeanUtils.copyProperties(findByPassword,form);
		}
		
		return form;
	}

	@Override
	public Boolean updateAccountData(AdminModel form) {
		Boolean isUpdate = false;
		form.setAccStatus(lockedStatusEnd);
		AdminEntity entity = new AdminEntity();
		BeanUtils.copyProperties(form,entity);
		repo.save(entity);
		isUpdate = true;
		return isUpdate;
	}

}
