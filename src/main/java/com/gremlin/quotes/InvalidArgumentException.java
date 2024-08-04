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
//				+ "Forsmatic Quote Language - Currently Supports English and Russian, "
//				+ "Язык цитат Forsmatic — в настоящее время поддерживает английский и русский языки. " + ;
//	}
}
