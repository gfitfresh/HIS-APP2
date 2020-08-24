package com.gaurav.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gaurav.entity.AdminEntity;
import com.gaurav.model.AdminModel;
import com.gaurav.service.IAdminService;

@Controller
@RequestMapping(value = "/account")
public class AdminController {

	@Autowired
	private IAdminService service;

	@GetMapping(value = { "/home", "/first", "/" })
	public String registrationForm(Model model) {
		
		AdminEntity entity = new AdminEntity();
		model.addAttribute("adminEntity", entity);
		return "adminForm";

	}

	@PostMapping(value = "/create")
	public String saveCaseWorkerManagementData(@ModelAttribute AdminModel bind,
			RedirectAttributes attributes, Model model) {
		Boolean isSave = false;
		attributes.addFlashAttribute("adminEntity", new AdminEntity());
		isSave = service.saveAdmin(bind);
		if (isSave) {
			//mailUtils.sendUserAccUnlockMail2(bind);
			attributes.addFlashAttribute("msg", "Account almost created. Check your email to unlock your account");
		} else {
			attributes.addFlashAttribute("msg", "AccountCreationFaild");
		}

		return "redirect:/account/first";

	}

	@GetMapping(value = "/send")
	public void sendRedirect(@RequestParam("url") String url, HttpServletResponse res) throws IOException {

		res.sendRedirect(url);

	}
	
	@GetMapping("/all")
	public String retriveAllContacts(Model model) {
		List<AdminModel> allAccounts = service.getAllAccount();
		model.addAttribute("allAccounts", allAccounts);
		
		AdminModel account = new AdminModel();
		model.addAttribute("account", account);
		 return "allAccounts";
		
	}
	
	@GetMapping("/delete")
	public String deleteAccount(@RequestParam("cid")Integer contactId) {
		Boolean isDeleted = service.deleteAccountById(contactId);
		if(isDeleted) {
			return "redirect:/account/all";
		}
		return null;
		
	}
	
	@GetMapping("/edit")
	public String editAccount(@RequestParam("cid") Integer conId,Model model) {
		
		AdminModel accountById = service.getAccountById(conId);
		model.addAttribute("adminEntity", accountById);
		return "adminForm";
		
	}

}
