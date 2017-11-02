package com.example.test.integration;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.test.bean.LanguageMgr;
import com.example.test.jpa.Language;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

@RunWith(Arquillian.class)
public class ITJTestCase {

	
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
        	.addClass(LanguageMgr.class)
            .addPackage(Language.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");	// enable CDI
    }
	
    @Inject
    private LanguageMgr mgr;
    
    @Before
    public void preparePersistenceTest() throws Exception {
    	mgr.populateLanguageTbl();
    }
    

	@Test
	public void testLanguageMgr() {	    
		// case1: valid language
	    Language lang = mgr.getLanguageByCode("it");
	    assertTrue("ciao".equals(lang.getGreeting()));
	    
	    // case2: not valid language
	    lang = mgr.getLanguageByCode("xx");
	    assertNull(lang);
	    
	    // case3: null language code
	    lang = mgr.getLanguageByCode(null);
	    assertNull(lang);
	}
}
