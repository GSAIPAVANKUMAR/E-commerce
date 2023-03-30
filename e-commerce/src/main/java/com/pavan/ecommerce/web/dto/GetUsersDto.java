package com.pavan.ecommerce.web.dto;

import com.pavan.ecommerce.entity.RoleEnum;

public class GetUsersDto {
	private RoleEnum role;

	public GetUsersDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetUsersDto(RoleEnum role) {
		super();
		this.role = role;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}
}
