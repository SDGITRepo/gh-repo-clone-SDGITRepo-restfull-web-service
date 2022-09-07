package com.rest.ws.restfulwebservice.helloworld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	@GetMapping(path = "/hello")
	public String hellow() {
		return "hellooo its rest service";
	}
	@GetMapping(path = "/hello-bean")
	public HellowBean hellowbean() {
		return new HellowBean("hello beans");
	}
	@GetMapping(path = "/hello-bean/pathvar/{name}")
	public HellowBean hellowbeanpath(@PathVariable String name) {
		return new HellowBean(String.format("hello beans %s",name));
	}
	

}
