package com.example.test.unit;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.test.bean.*;
import com.example.test.jpa.Language;

@RunWith(MockitoJUnitRunner.class)
public class JTestCase {

	// prepare mock
	@Mock	 
	LanguageMgr mgr;
	
	// inject SimpleBean and mock bean inside it
	@InjectMocks 
	private SimpleBean bean;
	
	
	@Test
	public void testSimpleBean() {
		// set mock behavior
		Language it = new Language("it","ciao");
		when(mgr.getLanguageByCode("it")).thenReturn( it );
		
		// execute unit test on SimpleBean.getEchoGreeting()
		//   case1: with non-null language
		String echo = bean.getEchoGreeting("it");
		assertTrue( echo.equals("ciao...ciao...ciao") );
		//   case2: null language parameter
		echo = bean.getEchoGreeting(null);
		assertTrue( echo.equals("hi...hi...hi") );
		
		// verify LanguageMgr.getGreeting() invokation
		verify(mgr).getLanguageByCode(Matchers.eq("it"));
		verify(mgr).getLanguageByCode((String) Matchers.eq(null));
	}

}
