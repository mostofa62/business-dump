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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="area_group")
public class Area { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=50)
	@NotBlank
	private String name;
	
	/** Area Has Many Users **/
	
	@OneToMany(mappedBy="areaUser",fetch = FetchType.LAZY)
	@JsonIgnoreProperties("areaUser")
	private Set<User> areaUsers = new HashSet<User>();
	
	/** Area Has Many Rate Charts **/
	
	@OneToMany(mappedBy="areaFromRate",fetch = FetchType.LAZY)
	//@JsonIgnoreProperties("areaFromRate")
	@JsonBackReference
	private Set<RateChart> areaFromRates = new HashSet<RateChart>();
	
	
	@OneToMany(mappedBy="areaToRate",fetch = FetchType.LAZY)
	//@JsonIgnoreProperties("areaToRate")
	@JsonBackReference
	private Set<RateChart> areaToRates = new HashSet<RateChart>();

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

	public Set<User> getAreaUsers() {
		return areaUsers;
	}

	public void setAreaUsers(Set<User> areaUsers) {
		this.areaUsers = areaUsers;
	}

	
	
	public Set<RateChart> getAreaFromRates() {
		return areaFromRates;
	}

	public void setAreaFromRates(Set<RateChart> areaFromRates) {
		this.areaFromRates = areaFromRates;
	}

	public Set<RateChart> getAreaToRates() {
		return areaToRates;
	}

	public void setAreaToRates(Set<RateChart> areaToRates) {
		this.areaToRates = areaToRates;
	}

	/** Parent-Child Relation in Area **/
	/*
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Area parentArea;
	
	@OneToMany(mappedBy="parentArea",fetch = FetchType.LAZY)
	private Set<Area> childAreas = new HashSet<Area>();
	*/
	/** End Parent-Child Relation in Area **/
	
	public Area(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Area(String name) {
		super();
		this.name = name;
	}
	public Area(Long id) {
		super();
		this.id = id;
	}
	
	public Area() {
		
	}
	
}
