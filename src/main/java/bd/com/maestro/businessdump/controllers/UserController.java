package bd.com.maestro.businessdump.controllers;

import java.util.Collection;

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
import org.springframework.web.bind.annotation.SessionAttribute;

import bd.com.maestro.businessdump.models.Area;
import bd.com.maestro.businessdump.models.Role;
import bd.com.maestro.businessdump.models.User;
import bd.com.maestro.businessdump.services.UserService;
import bd.com.maestro.businessdump.validators.GroupingConstrains;

@Controller
@RequestMapping("/user")
//@SessionAttributes("userRoleGlobal")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String index() {
		return "user/index";
	}
	
	@GetMapping("/create")
	public String create(ModelMap model,
			@SessionAttribute("userGlobal") User userGlobal
			) {
		
		User user = new User();		
		model.addAttribute("user", user);
		
		Collection<Role> roles = userService.getRolesIdAndNameOnly(userGlobal);
		model.addAttribute("roles", roles);
		return "user/create";
	}
	
	
	@PostMapping("/create")
	public String store(
			@ModelAttribute @Validated({GroupingConstrains.User.class, GroupingConstrains.UserPassword.class}) User user,
			BindingResult bindingResult,
			ModelMap model,
			@SessionAttribute("userGlobal") User userGlobal
			) {
		
		if(bindingResult.hasErrors()) {
			Collection<Role> roles = userService.getRolesIdAndNameOnly(userGlobal);
			model.addAttribute("roles", roles);
			return "user/create";
		}
		
		
		
		//if( user.getRole().getId() > 1 && user.getRole().getId() < 9) {
		if( user.getRole().getId() < 11) {
			Area area = new Area(user.getUserName());
			userService.AreaSaveOrUpdate(area);
			user.setAreaUser(area);
		}
		
		userService.UserSaveOrUpdate(user);
		return "redirect:/user";
	}
	
	@GetMapping("/update/{id}")
	public String edit(
			@PathVariable Long id,
			ModelMap model,
			@SessionAttribute("userGlobal") User userGlobal
			) {
		
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		Collection<Role> roles = userService.getRolesIdAndNameOnly(userGlobal);
		model.addAttribute("roles", roles);
		return "user/update";
	}
	
	@PostMapping("/update/{id}")
	public String update(@ModelAttribute @Validated({GroupingConstrains.User.class}) User user,
			BindingResult bindingResult,
			ModelMap model,
			@SessionAttribute("userGlobal") User userGlobal
			) {
		if(bindingResult.hasErrors()) {
			Collection<Role> roles = userService.getRolesIdAndNameOnly(userGlobal);
			model.addAttribute("roles", roles);
			return "user/update";
		}
		userService.UserSaveOrUpdate(user);
		return "redirect:/user";
	}
	
}
