package com.rest.ws.restfulwebservice.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	//for dynamic filters like if you want to display only value 2 and value 3 in this method 
	@GetMapping("/filter")
	public MappingJacksonValue getbean() {
		Somebean somebean = new Somebean("value1", "value2", "value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomebeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(somebean);
		mapping.setFilters(filters);
		
		return mapping;
		
	}
	@GetMapping("/filterlist")
	public MappingJacksonValue getbeanList() {
		List<Somebean> list =  Arrays.asList(new Somebean("value1", "value2", "value3"),
				new Somebean("value12", "value22", "value32"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomebeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
	}

}
