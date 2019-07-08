package bd.com.maestro.businessdump.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="product_type")
public class ProductType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=100)
	@NotBlank
	private String name;
	
	@OneToMany(mappedBy="productType",fetch = FetchType.LAZY)
	@JsonIgnoreProperties("productType")
	private Set<Product> products = new HashSet<Product>();
	
	
	
	/**  Generate Getter And Setter **/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public ProductType(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ProductType() {
		
	}
	
}
