package com.nirmitee.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class APIResponse {

	private String responseMessage;
	private String responseCode;
	private String result;
	private Object responseData;

	public APIResponse(String responseMessage, String result) {
		super();
		this.responseMessage = responseMessage;
		this.result = result;
	}

}
