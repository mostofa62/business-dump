package bd.com.maestro.businessdump.controllers.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bd.com.maestro.businessdump.models.User;
import bd.com.maestro.businessdump.services.UserService;

@RestController("rest UserController")
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public DataTablesOutput<User> getUser(@Valid DataTablesInput input){
		return userService.getUser(input);
	}
}
