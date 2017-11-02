package com.example.test.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.test.jpa.Language;

@Stateless
public class LanguageMgr {

	@PersistenceContext
	EntityManager em;
	
	
    public void populateLanguageTbl() throws Exception {
        System.out.println("Inserting records...");
        Language it = new Language("it", "ciao");
        em.persist(it);
                
        Language en = new Language("en", "hello");
        em.persist(en);
    }
	
    
    public Language getLanguageByCode(String langCode) {
    	if ( langCode==null )
			return null;

	    // execute query
	    System.out.println("Selecting (using JPQL)...");
	    TypedQuery<Language> results = em.createNamedQuery("languageByCode", Language.class)
	    								.setParameter("code", langCode);
	    
	    try {
	    	Language lang = results.getSingleResult();
	    	return lang;
	    } catch(NoResultException ex) {
	    	return null;
	    }
    }
    
}
