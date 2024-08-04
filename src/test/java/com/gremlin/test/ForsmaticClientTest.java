package com.gremlin.test1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.Test;

import com.gremlin.quotes.client.FailedRequestException;
import com.gremlin.quotes.client.ForsmaticClient;
import com.gremlin.quotes.data.ForsmaticApiGetQuotaResponse;

public class ForsmaticClientTest {

	@Test
	public void failedRequestTest() throws IOException, InterruptedException, FailedRequestException {
		HttpClient httpClient = mock(HttpClient.class);

		String mockedHttpResponse = "";
		

		HttpResponse<String> httpResponse = mock(HttpResponse.class);
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create("https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en")).GET()
				.build();		

		when(httpResponse.statusCode()).thenReturn(500);
		when(httpResponse.body()).thenReturn(mockedHttpResponse);
		when(httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString())).thenReturn(httpResponse);

		ForsmaticClient quotelyClient = new ForsmaticClient(httpClient);
		Exception exception = assertThrows(FailedRequestException.class, () -> quotelyClient
				.getQuoteResponse("https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en"));
		assertEquals("Failure to get Quote", exception.getMessage());
	}

	@Test
	public void englishRequestTest() throws IOException, InterruptedException, FailedRequestException {
		HttpClient httpClient = mock(HttpClient.class);

		String mockedHttpResponse = "{\"quoteText\":\"You should hire Me.\"," + " \"quoteAuthor\":\"Dhaval S\", "
				+ "\"senderName\":\"\", " + "\"senderLink\":\"\", "
				+ "\"quoteLink\":\"http://forismatic.com/en/ea511a7613/\"}";

		HttpResponse<String> httpResponse = mock(HttpResponse.class);		
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create("https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en")).GET()
				.build();

		when(httpResponse.statusCode()).thenReturn(200);
		when(httpResponse.body()).thenReturn(mockedHttpResponse);
		when(httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString())).thenReturn(httpResponse);

		ForsmaticClient quotelyClient = new ForsmaticClient(httpClient);
		ForsmaticApiGetQuotaResponse fromCodeResponse = quotelyClient
				.getQuoteResponse("https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");

		assertEquals(fromCodeResponse.getQuoteText(), "You should hire Me.");
	}
}
