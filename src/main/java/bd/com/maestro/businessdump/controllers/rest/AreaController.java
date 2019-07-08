package bd.com.maestro.businessdump.controllers.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bd.com.maestro.businessdump.models.Area;
import bd.com.maestro.businessdump.services.UserService;

@RestController("rest AreaController")
@RequestMapping("/api")
public class AreaController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/area",method=RequestMethod.GET)
	public DataTablesOutput<Area> getArea(@Valid DataTablesInput input){
		return userService.getArea(input);
	}
}
