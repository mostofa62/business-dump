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

import bd.com.maestro.businessdump.models.Area;
import bd.com.maestro.businessdump.services.UserService;

@Controller
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String index() {
		return "area/index";
	}
	
	@GetMapping("/create")
	public String create(ModelMap model) {
		
		Area area = new Area();		
		model.addAttribute("area", area);
		return "area/create";
	}
	
	
	@PostMapping("/create")
	public String store(
			@ModelAttribute @Validated Area area,
			BindingResult bindingResult,
			ModelMap model
			) {
		
		if(bindingResult.hasErrors()) {
			return "area/create";
		}
		userService.AreaSaveOrUpdate(area);
		return "redirect:/area";
	}
	
	@GetMapping("/update/{id}")
	public String edit(@PathVariable Long id, ModelMap model) {
		
		Area area = userService.getAreaById(id);
		model.addAttribute("area", area);
		return "area/update";
	}
	
	@PostMapping("/update/{id}")
	public String update(@ModelAttribute @Validated Area area,
			BindingResult bindingResult,
			ModelMap model
			) {
		if(bindingResult.hasErrors()) {
			return "area/update";
		}
		userService.AreaSaveOrUpdate(area);
		return "redirect:/area";
	}
	
}
