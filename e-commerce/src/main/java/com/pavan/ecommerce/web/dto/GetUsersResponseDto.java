package com.pavan.ecommerce.web.dto;

import java.util.ArrayList;

import com.pavan.ecommerce.entity.User;

public class GetUsersResponseDto {
	private Responsedto responseDto;
	private ArrayList<User> data;

	public GetUsersResponseDto(Responsedto responseDto, ArrayList<User> data) {
		super();
		this.responseDto = responseDto;
		this.data = data;
	}

	public GetUsersResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Responsedto getResponseDto() {
		return responseDto;
	}

	public void setResponseDto(Responsedto responseDto) {
		this.responseDto = responseDto;
	}

	public ArrayList<User> getData() {
		return data;
	}

	public void setData(ArrayList<User> data) {
		this.data = data;
	}

}
