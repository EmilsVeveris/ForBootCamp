package lv.venta.eib.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.venta.eib.enums.caseType;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table
@Entity(name="ComponentTable")
@Getter @Setter @NoArgsConstructor 
public class Component {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Cid")
	private int cid;
	
	@NonNull
	@Size(min = 0, max = 30)
	@Column(name = "ComponentId")
	private String componentId;		//komponentes modeļa nr
	
	@NonNull
	@Size(min = 0, max = 80)
	@Column(name = "Description")
	private String description;		//apraksts, ja nepieciešams (piem., komponente lietota)
	
	@NonNull
	@Size(min = 2, max = 150)
	@Column(name = "Datasheet")
	private String datasheet;		//links uz datasheet
	
	@Min(0)
	@Max(50)
	@Column(name="Tolerance")
	private int tolerance;			
	
	@Column(name="CaseType")
	private caseType casetype;		//THT vai SMD
	
	@NonNull
	@Size(min = 0, max = 30)
	@Column(name="CaseStyle")
	private String casestyle;		//konkrēts korpusa nosaukums (piem., SOT-23)
	
	@NonNull
	@Size(min = 0, max = 4)
	@Column(name="Room")
	private String room;			//kabinets
	
	@Min(0)
	@Column(name="Count")
	private int count;				//pieejamo komponenšu skaits
	
	@OneToMany(mappedBy = "component")
	@ToString.Exclude
	private Collection<ShoppingCart> shoppingCart;

	public Component(@Size(min = 0, max = 15) String componentId, @Size(min = 0, max = 80) String description,
			@Size(min = 2, max = 60) String datasheet, @Min(0) @Max(50) int tolerance, caseType casetype,
			@Size(min = 0, max = 15) String casestyle, @Size(min = 0, max = 4) String room, @Min(0) int count) {
		super();
		this.componentId = componentId;
		this.description = description;
		this.datasheet = datasheet;
		this.tolerance = tolerance;
		this.casetype = casetype;
		this.casestyle = casestyle;
		this.room = room;
		this.count = count;
	}
	
	
	
}
