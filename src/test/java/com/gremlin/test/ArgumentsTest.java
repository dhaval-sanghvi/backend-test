package com.gremlin.test1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.gremlin.quotes.GetQuotesApplication;
import com.gremlin.quotes.InvalidArgumentException; 

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArgumentsTest {
	
	@Test
	public void testOtherLanguage() {
		String[] args = {"Spanish"};		
		Exception exception = assertThrows(InvalidArgumentException.class, () -> GetQuotesApplication.validateArguments(args));		
		assertEquals("Invalid Language Name", exception.getMessage());
		assertEquals(null, GetQuotesApplication.getLanguage());
	}
	
	@Test
	public void testMultipleArguments() {
		String[] args = {"English", "Russian", "Chinese"};		
		Exception exception = assertThrows(InvalidArgumentException.class, () -> GetQuotesApplication.validateArguments(args));		
		assertEquals("Invalid Language Name - More than 1 argument", exception.getMessage());
		assertEquals(null, GetQuotesApplication.getLanguage());
	}
	
	@Test
	public void testValidDefault() {
		String[] args = {};		
		assertDoesNotThrow(() -> GetQuotesApplication.validateArguments(args));
		assertEquals("ENGLISH", GetQuotesApplication.getLanguage());
	}
	
	@Test
	public void testValidEnglish() {
		String[] args = {"English"};
		assertDoesNotThrow(() -> GetQuotesApplication.validateArguments(args));
		assertEquals("ENGLISH", GetQuotesApplication.getLanguage());
	}
	
	@Test
	public void testValidRussian() {
		String[] args = {"Russian"};
		assertDoesNotThrow(() -> GetQuotesApplication.validateArguments(args));
		assertEquals("RUSSIAN", GetQuotesApplication.getLanguage());
	}

}
