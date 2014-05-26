package com.anuacana.web.beans;

import java.io.Serializable;

public class UserRole implements Serializable {

	private static final long serialVersionUID = -9166336406174751705L;
	
	private Long userRolesId;
	
	private String roleCode;
	
	private String comments;
	
	public UserRole(Long userRolesId, String roleCode, String comments) {
		super();
		this.userRolesId = userRolesId;
		this.roleCode = roleCode;
		this.comments = comments;
	}

	public Long getUserRolesId() {
		return userRolesId;
	}


	public String getRoleCode() {
		return roleCode;
	}

	public String getComments() {
		return comments;
	}

}
