package com.ty.carrentalapp.exception;

public class NoIdFoundException extends RuntimeException {

	String message = "given id is not found";

	public NoIdFoundException() {
	}

	public NoIdFoundException(String message) {
		this.message = message;
	}

	public String getmessage() {
		return message;

	}

}
