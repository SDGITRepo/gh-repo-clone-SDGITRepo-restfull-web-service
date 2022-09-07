package com.rest.ws.restfulwebservice.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomebeanFilter")
public class Somebean {
	private String field1;
	private String field2;
	private String field3;
	public Somebean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	public String getValue1() {
		return field1;
	}
	public void setValue1(String field1) {
		this.field1 = field1;
	}
	public String getValue2() {
		return field2;
	}
	public void setValue2(String field2) {
		this.field2 = field2;
	}
	public String getValue3() {
		return field3;
	}
	public void setValue3(String field3) {
		this.field3 = field3;
	}
}
