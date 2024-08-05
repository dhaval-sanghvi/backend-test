package com.gremlin.quotes;


@SuppressWarnings("serial")
public class InvalidArgumentException extends Exception {	
	
	public InvalidArgumentException(String errorMessage) {
		super(errorMessage);
	}
//
//	@Override
//	public String toString() {
//		return "Please check your arguments - "
//				+ "Forismatic Quote Language - Currently Supports English and Russian, "
//				+ "Язык цитат Forismatic — в настоящее время поддерживает английский и русский языки. " + ;
//	}
}
