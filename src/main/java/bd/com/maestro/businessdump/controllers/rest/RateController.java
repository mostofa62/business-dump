package bd.com.maestro.businessdump.controllers.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bd.com.maestro.businessdump.models.RateChart;
import bd.com.maestro.businessdump.services.PricingService;

@RestController("rest RateController")
@RequestMapping("/api")
public class RateController {

	@Autowired
	private PricingService pricingService;
	
	@RequestMapping(value="/rate",method=RequestMethod.GET)
	public DataTablesOutput<RateChart> getRole(@Valid DataTablesInput input){
		return pricingService.getRateChart(input);
	}
	
}
