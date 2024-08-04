package com.gremlin.quotes.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.gremlin.quotes.data.ForsmaticApiGetQuotaResponse;

public class ForsmaticClient {

	private final HttpClient client;
	private final Gson gson;

	public ForsmaticClient() {
		this.client = HttpClient.newBuilder().build();
		this.gson = new Gson();
	}
	
	public ForsmaticClient(HttpClient client) {
		this.client = client;
		this.gson = new Gson();
	}

	public ForsmaticApiGetQuotaResponse getQuoteResponse(final String url)
			throws IOException, InterruptedException, FailedRequestException {
		final Builder buildURI = HttpRequest.newBuilder().uri(URI.create(url));
		final HttpRequest httpRequest = buildURI.GET().build();
		final HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		
//		System.out.println("Response " + response.body().toString());

		if (response.statusCode() != 200) {
			throw new FailedRequestException("Failure to get Quote");
		}
		
		return gson.fromJson(response.body(), ForsmaticApiGetQuotaResponse.class);
	}
}