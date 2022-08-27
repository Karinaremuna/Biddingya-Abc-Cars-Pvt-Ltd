package com.biddingya.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
	private String message;
	private LocalDateTime dateTime;
	private String description;
	private String statusCode;
	public ExceptionResponse(String message, LocalDateTime dateTime, String description, String statusCode) {
		super();
		this.message = message;
		this.dateTime = dateTime;
		this.description = description;
		this.statusCode = statusCode;
	}
	public ExceptionResponse() {
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "ExceptionResponse [message=" + message + ", dateTime=" + dateTime + ", description=" + description
				+ ", statusCode=" + statusCode + "]";
	}
	
	

}
