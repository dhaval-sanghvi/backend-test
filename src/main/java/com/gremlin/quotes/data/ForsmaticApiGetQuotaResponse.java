package com.gremlin.quotes.data;

public class ForsmaticApiGetQuotaResponse {

    private String quoteText;
    private String quoteAuthor;
    private String senderName;
    private String senderLink;
    private String quoteLink;

    public ForsmaticApiGetQuotaResponse(String quoteText, String quoteAuthor, String senderName, String senderLink, String quoteLink) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
        this.senderName = senderName;
        this.senderLink = senderLink;
        this.quoteLink = quoteLink;
    }
    
    public String getQuoteText() {
		return quoteText;
	}

	public String getQuoteAuthor() {
		return quoteAuthor;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getSenderLink() {
		return senderLink;
	}

	public String getQuoteLink() {
		return quoteLink;
	}	
	
}
