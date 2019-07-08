package bd.com.maestro.businessdump.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="products")
public class Product {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=150)
	@NotBlank
	private String name;
	
	@Column(length=10, nullable=true)
	private String unit;
	
	@Column(columnDefinition="TINYINT(5) default 0")
	private short validity;
	
	@Column(columnDefinition="CHAR(2) NULL")
	private String validityType;
		
	
	@ManyToOne
	@JoinColumn(name="product_type_id")
	@JsonIgnoreProperties("products")
	private ProductType productType;
	
	@OneToMany(mappedBy="productRate",fetch = FetchType.LAZY)
	@JsonIgnoreProperties("productRate")
	private Set<RateChart> productRates = new HashSet<RateChart>();

	
	/** Getter And Setter **/
	
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public short getValidity() {
		return validity;
	}

	public void setValidity(short validity) {
		this.validity = validity;
	}

	public String getValidityType() {
		return validityType;
	}

	public void setValidityType(String validityType) {
		this.validityType = validityType;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Set<RateChart> getProductRates() {
		return productRates;
	}

	public void setProductRates(Set<RateChart> productRates) {
		this.productRates = productRates;
	}
	
	public Product(Long id, String name){
		super();
		this.id = id;
		this.name = name;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
