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
import org.springframework.web.bind.annotation.SessionAttribute;

import bd.com.maestro.businessdump.data.RateType;
import bd.com.maestro.businessdump.data.ValidityType;
import bd.com.maestro.businessdump.models.Area;
import bd.com.maestro.businessdump.models.Product;
import bd.com.maestro.businessdump.models.RateChart;
import bd.com.maestro.businessdump.models.User;
import bd.com.maestro.businessdump.services.PricingService;
import bd.com.maestro.businessdump.services.ProductService;

@Controller
@RequestMapping("/rate")
public class RateController {

		
	private PricingService pricingService;
	private ProductService productService;
	
	@Autowired
	public RateController(PricingService pricingService,
			ProductService productService
			) {
		this.pricingService = pricingService;
		this.productService = productService;
	}
	
	
	@GetMapping("")
	public String index() {
		return "rate/index";
	}
	
	@GetMapping("/create/{id}")
	public String create(
			@SessionAttribute("userGlobal") User userGlobal,
			@PathVariable Long id,
			ModelMap model) {
		
		//Area to rate
		Area areaToRate  = new Area(id);
				
		//Area from rate
		Area areaFromRate = userGlobal.getAreaUser();
		
		RateChart rate = new RateChart();
		rate.setAreaFromRate(areaFromRate);
		rate.setAreaToRate(areaToRate);
		
		Collection<Product> products = productService.getProductIdAndNameOnly();
		model.addAttribute("products", products);
		
		List<RateType> rateTypes = new ArrayList<RateType>( Arrays.asList(RateType.values() ));
		model.addAttribute("rateTypes", rateTypes);
		
		
		model.addAttribute("rate", rate);
		
		
		return "rate/create";
	}
	
	@PostMapping("/create/{id}")
	public String store(
			@ModelAttribute @Validated 	RateChart rate,
			BindingResult bindingResult,
			@PathVariable Long id,
			ModelMap model
	) {
		
		if(bindingResult.hasErrors()) {
			
			Collection<Product> products = productService.getProductIdAndNameOnly();
			model.addAttribute("products", products);
			
			List<RateType> rateTypes = new ArrayList<RateType>( Arrays.asList(RateType.values() ));
			model.addAttribute("rateTypes", rateTypes);
			
			return "rate/create";
		}
		pricingService.RateSaveOrUpdate(rate);
		return "redirect:/rate";
	}
	
	@GetMapping("/update/{id}")
	public String edit(@PathVariable Long id, ModelMap model) {
		
		
		RateChart rate = pricingService.RateFindById(id);
		model.addAttribute("rate", rate);
		
		
		return "rate/update";
		
	
	}
	
	@PostMapping("/update/{id}")
	public String update(@ModelAttribute @Validated RateChart rate,
			BindingResult bindingResult,
			@PathVariable Long id,
			ModelMap model
			) {
		
		if(bindingResult.hasErrors()) {
			
			return "rate/update";
		}
		pricingService.RateSaveOrUpdate(rate);
		return "redirect:/rate";
	}
	
	
	
}
