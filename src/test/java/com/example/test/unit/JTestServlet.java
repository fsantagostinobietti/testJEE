package com.example.test.unit;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.test.bean.*;
import com.example.test.jpa.Language;
import com.example.test.servlet.IndexServlet;
import com.sun.grizzly.http.servlet.HttpServletRequestImpl;

@RunWith(MockitoJUnitRunner.class)
public class JTestServlet {

	
	// prepare mock
	//@Mock(answer=Answers.CALLS_REAL_METHODS)
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	RequestDispatcher rd;
	
	@Mock
	SimpleBean bean;
	
	// inject SimpleBean and mock bean inside it
	@InjectMocks 
	private IndexServlet servlet;
	
	
	@Test
	public void testIndexServlet() throws ServletException, IOException {
		// set HttpServletRequest mocks behavior
		when(request.getParameter("lang")).thenReturn("it");
		when(request.getMethod()).thenReturn("GET");
		when(request.getRequestDispatcher(anyString())).thenReturn( rd );
		
		// set SimpleBean mocks behavior
        when(bean.getEchoGreeting("it")).thenReturn("ciao...ciao...ciao");
		
		// execute unit test on IndexServlet.doGet()
		servlet.service(request, response);
		
		
		// verify SimpleBean.getEchoGreeting() invocation
		verify(bean).getEchoGreeting(Matchers.eq("it"));
		
		// verify HttpServletRequest.setAttribute() invocation
		verify(request).setAttribute("Msg", "ciao...ciao...ciao");
	}

}
