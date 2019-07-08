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

import bd.com.maestro.businessdump.models.ProductType;
import bd.com.maestro.businessdump.services.ProductService;

@Controller
@RequestMapping("/producttype")
public class ProductTypeController {

	@Autowired	
	private ProductService productService;
	
	@GetMapping("")
	public String index() {
		return "producttype/index";
	}
	
	@GetMapping("/create")
	public String create(ModelMap model) {
		ProductType producttype = new ProductType();
		model.addAttribute("producttype", producttype);		
		return "producttype/create";
	}
	
	@PostMapping("/create")
	public String store(
			@ModelAttribute @Validated 	ProductType producttype,
			BindingResult bindingResult,
			ModelMap model
	) {
		
		if(bindingResult.hasErrors()) {
		
			return "producttype/create";
		}
		productService.TypeSaveOrUpdate(producttype);
		return "redirect:/producttype";
	}
	
	@GetMapping("/update/{id}")
	public String edit(@PathVariable Long id, ModelMap model) {
		
		
		ProductType producttype = productService.findByIdType(id);
		model.addAttribute("producttype", producttype);		
		
		return "producttype/update";
		
	
	}
	
	@PostMapping("/update/{id}")
	public String update(@ModelAttribute @Validated ProductType producttype,
			BindingResult bindingResult,
			@PathVariable Long id,
			ModelMap model
			) {
		
		if(bindingResult.hasErrors()) {
			return "producttype/update";
		}
		productService.TypeSaveOrUpdate(producttype);
		return "redirect:/producttype";
	}
	
}
