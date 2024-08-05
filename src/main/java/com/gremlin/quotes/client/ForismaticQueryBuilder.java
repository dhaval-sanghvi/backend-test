package com.gremlin.quotes.client;

import com.gremlin.quotes.Language;

public class ForismaticQueryBuilder {

	private final static String BASE_URL = "https://api.forismatic.com/api/1.0/?";
	private final static String REQ_PARAM_METHOD_NAME = "method";
	private final static String REQ_PARAM_METHOD_VALUE = "getQuote";
	private final static String REQ_PARAM_FORMAT_NAME = "format";
	private final static String REQ_PARAM_FORMAT_VALUE = "json";
	private final static String REQ_PARAM_LANGUAGE_NAME = "lang";

	public String constructUrl(Language language) {
		return BASE_URL + queryParams(language);
	}

	private String queryParams(Language language) {
		return REQ_PARAM_METHOD_NAME + "=" + REQ_PARAM_METHOD_VALUE + "&" + REQ_PARAM_FORMAT_NAME + "="
				+ REQ_PARAM_FORMAT_VALUE + "&" + REQ_PARAM_LANGUAGE_NAME + "=" + language.getLanguageValue();
	}

}
