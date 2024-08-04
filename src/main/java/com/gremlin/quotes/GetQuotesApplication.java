package com.gremlin.quotes;

import java.io.IOException;

import com.gremlin.quotes.client.FailedRequestException;
import com.gremlin.quotes.client.ForsmaticClient;
import com.gremlin.quotes.client.ForsmaticQueryBuilder;
import com.gremlin.quotes.data.ForsmaticApiGetQuotaResponse;

public class GetQuotesApplication {

	public static final Language DEFAULT_LANGUAGE = Language.ENGLISH;
	private static Language language;

	/**
	 * 
	 * Entry Point for getting quotes from Fosmatic API. English and Russian are the
	 * 2 supported quotes Expected Output - Quote in the selected Language *
	 * 
	 */

	public static void main(String[] args) {
		try {
			validateArguments(args);
		} catch (InvalidArgumentException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

		final ForsmaticClient formsmaticClient = new ForsmaticClient();
		final ForsmaticQueryBuilder forsmaticQueryBuilder = new ForsmaticQueryBuilder();

		try {
			final ForsmaticApiGetQuotaResponse quote = formsmaticClient
					.getQuoteResponse(forsmaticQueryBuilder.constructUrl(language));
			System.out.println("Quote: " + quote.getQuoteText());
			System.out.println("By Author: " + quote.getQuoteAuthor());

		} catch (IOException | InterruptedException | FailedRequestException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * Possible use cases Args - Blank -> English "English" "Russian"
	 * NotEnglishOrRussianKeyword -> Fail with Message Multiple Arguments -> Fail
	 * with Message
	 * 
	 * @param args
	 * @throws InvalidArgumentException
	 */

	public static void validateArguments(String[] args) throws InvalidArgumentException {
		if ((args.length > 1)) {
			throw new InvalidArgumentException("Invalid Language Name - More than 1 argument");
		}

		if (args.length == 0) {
			System.out.println("No Language specified - Using Default Language - " + DEFAULT_LANGUAGE);
			language = DEFAULT_LANGUAGE;
		} else {
			String userSelectedLanguage = args[0].trim();

			for (Language applicationSupportedLanguage : Language.values()) {
				if (applicationSupportedLanguage.name().equalsIgnoreCase(userSelectedLanguage)) {
					language = applicationSupportedLanguage;
				}
			}

			if (language == null) {
				throw new InvalidArgumentException("Invalid Language Name");
			}
		}
	}

	/**
 	This method is for Testing purposes
	*/
	public static String getLanguage() {
		if (language != null)
			return language.name();
		else
			return null;
	}

}
