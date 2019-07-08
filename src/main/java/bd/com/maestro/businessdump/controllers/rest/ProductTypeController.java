package bd.com.maestro.businessdump.controllers.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bd.com.maestro.businessdump.models.ProductType;
import bd.com.maestro.businessdump.services.ProductService;

@RestController("rest ProductTypeController")
@RequestMapping("/api")
public class ProductTypeController {

	@Autowired	
	private ProductService productService;
	
	@RequestMapping(value="/producttype",method=RequestMethod.GET)
	public DataTablesOutput<ProductType> getProductType(@Valid DataTablesInput input){
		return productService.getProductType(input);
	}
}
