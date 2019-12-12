package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseResult {
	
	// 0 -- >  failed rquest with null data 
	// 1 -- >  Successful rquest with Array of data 
	
	@JsonProperty("Result")
	private boolean Result;
	
	@JsonProperty("ErrorMsg")
	private String ErrorMsg;
	
	@JsonProperty("CodeStatus")
	private int CodeStatus;
	
	

}
