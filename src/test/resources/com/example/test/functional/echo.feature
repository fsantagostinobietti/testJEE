Feature: Echo Service

  Scenario: main service endpoint with 'it' language
    Given Echo service endpoint is 'http://localhost:8080/testJEE/'
    When I access endpoint with language parameter 'it'
    Then Response text should contain 'ciao...ciao...ciao'
    
  Scenario: main service endpoint with unknown language
    Given Echo service endpoint is 'http://localhost:8080/testJEE/'
    When I access endpoint with language parameter 'xx'
    Then Response text should contain 'hi...hi...hi'
    