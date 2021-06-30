package lv.venta.eib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lv.venta.eib.enums.caseType;


@Table
@Entity(name = "MosfetTable")
@Getter @Setter @NoArgsConstructor
public class MOSFET extends Transistor {
	@NonNull
	@Size(min = 0, max = 10)
	@Column(name = "MosfetType")
	private String mosfetType;
	
	@Column(name="GateVoltage")
	private float gateVoltage;

	public MOSFET(@Size(min = 0, max = 15) String componentId, @Size(min = 0, max = 80) String description,
			@Size(min = 2, max = 60) String datasheet, @Min(0) @Max(50) int tolerance, caseType casetype,
			@Size(min = 0, max = 15) String casestyle, @Size(min = 0, max = 4) String room, @Min(0) int count,
			@Min(0) int maxVoltage, @Min(0) float maxCurrent, @NonNull @Size(min = 0, max = 10) String mosfetType,
			float gateVoltage) {
		super(componentId, description, datasheet, tolerance, casetype, casestyle, room, count, maxVoltage, maxCurrent);
		this.mosfetType = mosfetType;
		this.gateVoltage = gateVoltage;
	}
	
	
	
}
