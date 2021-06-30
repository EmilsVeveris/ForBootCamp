package lv.venta.eib.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

@Table
@Entity(name = "ShoppingCart")
@Getter @Setter @NoArgsConstructor
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	@Column(name = "CartID")
	private int cartID;
	
	@NonNull
	@Size(min = 0, max = 30)
	@Column(name = "ComponentId")
	private String componentId;	
	
	@Min(0)
	@Column(name="Count")
	private int count;	
	
	@ManyToOne()
	@JoinColumn(name = "Cid")
	private Component component;
	
	@ManyToOne()
	@JoinColumn(name = "Userid")
	private User user;

	public ShoppingCart(@Size(min = 0, max = 30) String componentId, @Min(0) int count) {
		super();
		this.componentId = componentId;
		this.count = count;
	}
	
	
	
}
