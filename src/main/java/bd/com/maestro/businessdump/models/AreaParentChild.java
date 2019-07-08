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
@Table(name="area_parent_child")
public class AreaParentChild {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Area parent;
	
	
	@ManyToOne
	@JoinColumn(name="child_id")
	private Area child;
	
	
	@Column(length=3)
	private short depth;

}


