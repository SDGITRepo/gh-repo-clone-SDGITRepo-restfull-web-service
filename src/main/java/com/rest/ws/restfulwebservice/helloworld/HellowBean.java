package com.rest.ws.restfulwebservice.helloworld;

public class HellowBean {
 private String mesg;

 	public HellowBean(String s){
	 this.mesg = s;
	 
 }

	
	public void setMesg(String mesg) {
		this.mesg = mesg;
	}


	public String getMesg() {
		return mesg;
	}


	@Override
	public String toString() {
		return "HellowBean [mesg=" + mesg + "]";
	}
}
