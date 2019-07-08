package bd.com.maestro.businessdump.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import bd.com.maestro.businessdump.models.Product;
import bd.com.maestro.businessdump.models.ProductType;
import bd.com.maestro.businessdump.repositories.ProductRepository;
import bd.com.maestro.businessdump.repositories.ProductTypeRepository;


@Service
public class ProductService {

	
	private ProductRepository productRepository;
	private ProductTypeRepository productTypeRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository, ProductTypeRepository productTypeRepository) {
		this.productRepository = productRepository;
		this.productTypeRepository = productTypeRepository;
	}
	
	
	public void SaveOrUpdate(Product product) {
		productRepository.save(product);
	}
	
	public void TypeSaveOrUpdate(ProductType productType) {
		productTypeRepository.save(productType);
	}
	
	public Collection<ProductType> getIdAndNameOnly(){
		return productTypeRepository.getIdAndNameOnly();
	}
	
	public Collection<Product> getProductIdAndNameOnly(){
		return productRepository.getIdAndNameOnly();
	}
	
	public Product findById(Long id) {

           Product product = productRepository.findById(id).orElseThrow(
   				()-> new IllegalArgumentException("Not Found with this ID: "+id));
           return product;
	}
	
	public ProductType findByIdType(Long id) {
		ProductType productType = productTypeRepository.findById(id).orElseThrow(
   				()-> new IllegalArgumentException("Not Found with this ID: "+id));
		return productType;
	}
	
	
	public DataTablesOutput<Product> getProducts(DataTablesInput input){
		return productRepository.findAll(input);
	}
	
	public DataTablesOutput<ProductType> getProductType(DataTablesInput input){
		return productTypeRepository.findAll(input);
	}
	
}
