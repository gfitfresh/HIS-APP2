package com.gaurav.model;

import lombok.Data;

@Data
public class UnlockModel {
	private String email;
	private String tempPwd;
	private String newPwd;
	private String confirmPwd;

}
