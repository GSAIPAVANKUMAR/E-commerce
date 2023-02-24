package com.pavan.ecommerce.web.dto;

import com.pavan.ecommerce.entity.StatusEnum;

public class Responsedto {
	private StatusEnum status;
	private String errorDescription;

	public Responsedto(StatusEnum status, String errorDescription) {
		super();
		this.status = status;
		this.errorDescription = errorDescription;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

}
