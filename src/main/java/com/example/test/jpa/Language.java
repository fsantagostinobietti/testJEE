package com.example.test.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(
	    name="languageByCode", 
	    query = "select l from Language l where l.code = :code"
	)
public class Language implements Serializable {
    private Long id;
    private String code;	// ex. 'it', 'en'
	private String greeting;

	public Language() {
	}
	public Language(String code, String greeting) {
		this.code = code;
		this.greeting = greeting;
	}
	
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(unique=true)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
    public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	@Override
    public String toString() {
        return "Language@" + hashCode() + "[id = " + id + "; code = " + code + "; greeting = "+ greeting +"]";
    }
}
