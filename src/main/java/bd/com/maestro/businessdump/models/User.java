package bd.com.maestro.businessdump.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import bd.com.maestro.businessdump.validators.GroupingConstrains;
import bd.com.maestro.businessdump.validators.annotations.ManyToOneRequired;




@Entity
@Table(name="oms_users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=50)
	@NotBlank(groups = GroupingConstrains.User.class)
	@Pattern(regexp="[a-zA-Z0-9]{3,50}")
	private String userName;
	
	@Column(length=30)
	@NotBlank(groups = GroupingConstrains.UserPassword.class)
	private String password;
	
	@Column(length=2)
	private short rLevel;
	
	@Column(length=15)
	@Pattern(regexp="^[0-9]{11,15}", groups = GroupingConstrains.User.class)
	private String mobile;
	
	@Column(length=65)
	@Email(groups = GroupingConstrains.User.class)	
	private String email;
	
	@Column(length=150)
	@NotBlank(groups = GroupingConstrains.User.class)
	private String fullName;
	
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	@JsonIgnoreProperties("users")
	@ManyToOneRequired
	private Role role;
	
	
	@ManyToOne
	@JoinColumn(name="area_id")
	@JsonIgnoreProperties("areaUsers")	
	private Area areaUser;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public short getrLevel() {
		return rLevel;
	}


	public void setrLevel(short rLevel) {
		this.rLevel = rLevel;
	}

	
	


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Area getAreaUser() {
		return areaUser;
	}


	public void setAreaUser(Area areaUser) {
		this.areaUser = areaUser;
	}
	
	/** Parent-Child Relation in User **/
	/*
	@ManyToOne
	@JoinColumn(name="parent_id")
	private User parentUser;
	
	@OneToMany(mappedBy="parentUser",fetch = FetchType.LAZY)
	private Set<User> childUsers = new HashSet<User>();
	*/
	/** End Parent-Child Relation in User **/
	
	
	
	
}
