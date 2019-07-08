package bd.com.maestro.businessdump.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import bd.com.maestro.businessdump.validators.annotations.ManyToOneRequired;

@Entity
@Table(name="rate_chart")
public class RateChart {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private BigDecimal rate;
	
	@Column(length=1, nullable=true)
	private byte rateType;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	@JsonIgnoreProperties("productRates")
	@ManyToOneRequired
	private Product productRate;
	
	@ManyToOne
	@JoinColumn(name="area_from_id")
	@JsonManagedReference
	//@JsonIgnoreProperties("areaFromRates")
	//@ManyToOneRequired
	private Area areaFromRate;
	
	@ManyToOne
	@JoinColumn(name="area_to_id")
	@JsonManagedReference
	//@JsonIgnoreProperties("areaToRates")
	//@ManyToOneRequired
	private Area areaToRate;
	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public BigDecimal getRate() {
		return rate;
	}


	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}


	public byte getRateType() {
		return rateType;
	}


	public void setRateType(byte rateType) {
		this.rateType = rateType;
	}


	public Product getProductRate() {
		return productRate;
	}


	public void setProductRate(Product productRate) {
		this.productRate = productRate;
	}


	public Area getAreaFromRate() {
		return areaFromRate;
	}


	public void setAreaFromRate(Area areaFromRate) {
		this.areaFromRate = areaFromRate;
	}


	public Area getAreaToRate() {
		return areaToRate;
	}


	public void setAreaToRate(Area areaToRate) {
		this.areaToRate = areaToRate;
	}


	


	
	
}
