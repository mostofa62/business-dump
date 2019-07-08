package bd.com.maestro.businessdump.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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

import bd.com.maestro.businessdump.data.ValidityType;
import bd.com.maestro.businessdump.models.Product;
import bd.com.maestro.businessdump.models.ProductType;
import bd.com.maestro.businessdump.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired	
	private ProductService productService;
	
	@GetMapping("")
	public String index() {
		return "product/index";
	}
	
	@GetMapping("/create")
	public String create(ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		List<ValidityType> validityTypes = new ArrayList<ValidityType>( Arrays.asList(ValidityType.values() ));
		model.addAttribute("validityTypes", validityTypes);
		Collection<ProductType> productTypes = productService.getIdAndNameOnly();
		model.addAttribute("productTypes", productTypes);
		return "product/create";
	}
	
	@PostMapping("/create")
	public String store(
			@ModelAttribute @Validated 	Product product,
			BindingResult bindingResult,
			ModelMap model
	) {
		
		if(bindingResult.hasErrors()) {
			List<ValidityType> validityTypes = new ArrayList<ValidityType>( Arrays.asList(ValidityType.values() ));
			model.addAttribute("validityTypes", validityTypes);
			Collection<ProductType> productTypes = productService.getIdAndNameOnly();
			model.addAttribute("productTypes", productTypes);
			return "product/create";
		}
		productService.SaveOrUpdate(product);
		return "redirect:/product";
	}
	
	@GetMapping("/update/{id}")
	public String edit(@PathVariable Long id, ModelMap model) {
		
		
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		List<ValidityType> validityTypes = new ArrayList<ValidityType>( Arrays.asList(ValidityType.values() ));
		model.addAttribute("validityTypes", validityTypes);
		Collection<ProductType> productTypes = productService.getIdAndNameOnly();
		model.addAttribute("productTypes", productTypes);
		
		return "product/update";
		
	
	}
	
	@PostMapping("/update/{id}")
	public String update(@ModelAttribute @Validated Product product,
			BindingResult bindingResult,
			@PathVariable Long id,
			ModelMap model
			) {
		
		if(bindingResult.hasErrors()) {
			List<ValidityType> validityTypes = new ArrayList<ValidityType>( Arrays.asList(ValidityType.values() ));
			model.addAttribute("validityTypes", validityTypes);
			Collection<ProductType> productTypes = productService.getIdAndNameOnly();
			model.addAttribute("productTypes", productTypes);
			return "product/update";
		}
		productService.SaveOrUpdate(product);
		return "redirect:/product";
	}
	
}
