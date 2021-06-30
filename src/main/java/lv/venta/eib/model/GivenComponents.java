package lv.venta.eib.model;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lv.venta.eib.enums.compStatus;

@Table
@Entity(name = "GivenComponents")
@Getter @Setter @NoArgsConstructor
public class GivenComponents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	@Column(name = "GCid")
	private int gcid;
	
	@NonNull
	@NotEmpty
	@Column(name = "DateGiven")
	private Date dateGiven;
	
	@NonNull
	@NotEmpty
	@Column(name = "ReturnDate")
	private Date returnDate;
	
	@Column(name = "Status")
	private compStatus status;
	
	@ManyToMany
	@JoinTable(name = "component_GivenComponents", joinColumns = @JoinColumn(name="GCid"), inverseJoinColumns = @JoinColumn(name = "Cid"))
	private Collection<Component> component;
	
	

}
