package com.gaurav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gaurav.model.AdminModel;
import com.gaurav.model.UnlockModel;
import com.gaurav.service.IAdminService;

@Controller
public class UnlockController {

	@Autowired
	private IAdminService service;

	@GetMapping("/lastlogin")
	public String Login(@RequestParam("email") String mail, @RequestParam("OTP") String otp, Model model) {

		UnlockModel bind = new UnlockModel();
		model.addAttribute("mail", mail);
		model.addAttribute("otp", otp);
		model.addAttribute("unlockModel", bind);

		return "unlock";

	};

	@PostMapping("/read")
	public String readForm(@ModelAttribute("confirmPwd") UnlockModel bin, Model model) {
		UnlockModel bind = new UnlockModel();
		model.addAttribute("unlockModel", bind);
		try {

			AdminModel accountDetailsBytempPwd = service.getAccountDetailsBytempPwd(bin.getTempPwd(),
					bin.getEmail());

			if (accountDetailsBytempPwd != null) {

				accountDetailsBytempPwd.setPassword(bin.getConfirmPwd());

				Boolean updateFormData = service.updateAccountData(accountDetailsBytempPwd);
				if (updateFormData != null) {
					return "confirm";
				}

			}
		} catch (Exception e) {

		}

		model.addAttribute("errorMsg", "Please Check Your Temp Password");
		bind.setEmail(bin.getEmail());

		return "unlock";

	};

}
