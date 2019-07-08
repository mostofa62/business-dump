package bd.com.maestro.businessdump.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_parent_child")
public class UserParentChild {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private User parent;
	
	
	@ManyToOne
	@JoinColumn(name="child_id")
	private User child;
	
	
	@Column(length=3)
	private short depth;

}
