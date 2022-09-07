package com.rest.ws.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
/*import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;*/
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	UserDaoService service = new UserDaoService();
	@GetMapping("/users")
	public List<User> reriveAllUsers(){
		return service.findAll();
		
	}
	@GetMapping("/user/{userid}")
	public User findUser(@PathVariable int userid) {
		User user = service.findUser(userid);
		if(user == null)
			throw new UserNotFoundException("id :"+userid);
		/*
		 * EntityModel<User> model = EntityModel.of(user); WebMvcLinkBuilder builder =
		 * linkTo(methodOn(this.getClass()).reriveAllUsers());
		 * model.add(builder.withRel("all-users")); return model;
		 */
		return user;
	}
	@PostMapping(path = "/user/")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User saveduser = service.saveUser(user);
		//here new user is saved and we need to pass the newly created user link in the response 
		// /user/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
}
