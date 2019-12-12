package entities;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import exception.ApiRequestException;

public class ResponseResult {

	// 0 -- > failed rquest with null data
	// 1 -- > Successful rquest with Array of data

	public ResponseResult() {
		super();
	}

	@JsonProperty("Result")
	private boolean Result;

	@JsonProperty("message")
	private String Message;

	@JsonProperty("CodeStatus")
	private HttpStatus CodeStatus;

	ApiRequestException apiRequestException;

	public ResponseResult(boolean result, String message, HttpStatus codeStatus) {
		super();
		Result = result;
		Message = message;
		CodeStatus = codeStatus;
	}

	public ResponseResult(ApiRequestException apiRequestException) {
		super();
		this.apiRequestException = apiRequestException;

		Result = false;
		Message = apiRequestException.getMessage();
		CodeStatus = HttpStatus.BAD_REQUEST;
	}

}
