package lv.venta.eib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.venta.eib.enums.caseType;


@Table
@Entity(name = "IntegralCircuit")
@Getter @Setter @NoArgsConstructor
public class IntegralCircuit extends Component {
	@Min(0)
	@Column(name = "SupplyVoltage")
	private float supplyVoltage;

	public IntegralCircuit(@Size(min = 0, max = 15) String componentId, @Size(min = 0, max = 80) String description,
			@Size(min = 2, max = 60) String datasheet, @Min(0) @Max(50) int tolerance, caseType casetype,
			@Size(min = 0, max = 15) String casestyle, @Size(min = 0, max = 4) String room, @Min(0) int count,
			@Min(0) float supplyVoltage) {
		super(componentId, description, datasheet, tolerance, casetype, casestyle, room, count);
		this.supplyVoltage = supplyVoltage;
	}
	
	
}
