package com.gremlin.test1;

import org.junit.Test;

import com.gremlin.quotes.Language;
import com.gremlin.quotes.client.ForsmaticQueryBuilder;

import static org.junit.Assert.*;

public class ForsmaticQueryBuilderTest {
	
    @Test
    public void testUrlCreationEnglish() {
        String fromCode = new ForsmaticQueryBuilder().constructUrl(Language.ENGLISH);        
        String fromRequirements = String.format("https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
        assertEquals(fromRequirements, fromCode);
    }
    
    @Test
    public void testUrlCreationRussian() {
        String fromCode = new ForsmaticQueryBuilder().constructUrl(Language.RUSSIAN);        
        String fromRequirements = String.format("https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=ru");
        assertEquals(fromRequirements, fromCode);
    }
}