package com.example.test.functional;


import org.apache.http.client.fluent.Request;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	private String echoSrvURL;
	private String language;

	@Given("^Echo service endpoint is '(.+)'$")
	public void echo_service_endpoint(String url) throws Throwable {
		echoSrvURL = url;
		System.out.println("Echo service endpoint ["+url+"]");
    }
	
	@When("^I access endpoint with language parameter '(.+)'$")
    public void access_with_language(String lang) throws Throwable {
        language = lang;
        System.out.println("Language parameter ["+lang+"]");
    }

    @Then("^Response text should contain '(.*)'$")
    public void response_contains_text(String expected) throws Throwable {
        System.out.println("Expected response ["+expected+"]");
        
        String text = Request.Get( echoSrvURL+"?lang="+language ).execute()
        				.returnContent().asString();
        Assert.assertThat(text, CoreMatchers.containsString(expected));
    }
}
