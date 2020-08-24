package com.gaurav.model;


import java.util.Date;

import lombok.Data;

@Data
public class AdminModel {
	private Integer regId;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String role;
	private String accStatus;
	private Date createdDate;
	private Date updatedDate;
	private String password;

}
