package com.gremlin.quotes.client;


@SuppressWarnings("serial")
public class FailedRequestException extends Exception {	
	
	public FailedRequestException(String errorMessage) {
		super(errorMessage);
	}
}
