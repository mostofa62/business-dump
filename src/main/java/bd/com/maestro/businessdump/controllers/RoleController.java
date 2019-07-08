package bd.com.maestro.businessdump.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bd.com.maestro.businessdump.models.Role;
import bd.com.maestro.businessdump.services.UserService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String index() {
		return "role/index";
	}
	
	@GetMapping("/create")
	public String create(ModelMap model) {
		
		Role role = new Role();		
		model.addAttribute("role", role);
		return "role/create";
	}
	
	
	@PostMapping("/create")
	public String store(
			@ModelAttribute @Validated Role role,
			BindingResult bindingResult,
			ModelMap model
			) {
		
		if(bindingResult.hasErrors()) {
			return "role/create";
		}
		userService.RoleSaveOrUpdate(role);
		return "redirect:/role";
	}
	
	@GetMapping("/update/{id}")
	public String edit(@PathVariable Long id, ModelMap model) {
		
		Role role = userService.getRoleById(id);
		model.addAttribute("role", role);
		return "role/update";
	}
	
	@PostMapping("/update/{id}")
	public String update(@ModelAttribute @Validated Role role,
			BindingResult bindingResult,
			ModelMap model
			) {
		if(bindingResult.hasErrors()) {
			return "role/update";
		}
		userService.RoleSaveOrUpdate(role);
		return "redirect:/role";
	}
	
}
