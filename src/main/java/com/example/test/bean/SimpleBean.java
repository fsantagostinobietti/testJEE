package com.example.test.bean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.test.jpa.Language;

/**
 * 
 *
 */
@Stateless
public class SimpleBean {

	private String getEcho(String msg) {
		if ( msg==null )
			msg = "hi";
		return msg+"..."+msg+"..."+msg;
	}
	
	@EJB
    LanguageMgr mgr;
	


	public String getEchoGreeting(String lang) {
		String greeting = getGreeting(lang);
		return getEcho(greeting);
	}

	private String getGreeting(String langCode) {
		Language language = mgr.getLanguageByCode(langCode);
	    System.out.println("Found " + language + " (using JPQL)");
	    if ( language==null )
	    	return null;
	    return language.getGreeting();
	}
}
