package lv.venta.eib.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.eib.model.Resistor;
import lv.venta.eib.model.Sensor;
import lv.venta.eib.repo.ISensorRepo;
import lv.venta.eib.service.ICRUDSensorService;

@Service
public class CRUDSensorServiceImpl implements ICRUDSensorService {

	
	@Autowired
	ISensorRepo sensorRepo;
	@Override
	public boolean addSensor(Sensor sensor) {
		ArrayList<Sensor> comp = sensorRepo.findByComponentId(sensor.getComponentId());
		if (comp.isEmpty() == true)
		{
			sensorRepo.save(sensor);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Sensor> showAllSensor() {
		return (ArrayList<Sensor>) sensorRepo.findAll();
	}

	@Override
	public Sensor selectById(int id) {
		Sensor comp = sensorRepo.findById(id).get();
		if (comp != null)
			return comp;
		else
			return new Sensor();
	}

	@Override
	public boolean editById(int id, Sensor sensor) {
		
		Sensor st = sensorRepo.findById(id).get();
		if(st != null)
		{
			//component values
			System.out.println("Editing the component");
			st.setComponentId(sensor.getComponentId());
			st.setCount(sensor.getCount());
			st.setCasestyle(sensor.getCasestyle());
			st.setCasetype(sensor.getCasetype());

			st.setDatasheet(sensor.getDatasheet());
			st.setDescription(sensor.getDescription());
			st.setRoom(sensor.getRoom());
			st.setTolerance(sensor.getTolerance());
			
			//Specific values
			st.setSupplyVoltage(sensor.getSupplyVoltage());
			st.setType(sensor.getType());
			sensorRepo.save(st);
			return true;
		}

		return false;
	}
	
	public ArrayList<Sensor> findSensorBySearchTerm(String searchterm) {
		Set<Sensor> foundComponents = new LinkedHashSet<>(sensorRepo.findByDescriptionContainingIgnoreCase(searchterm));
		foundComponents.addAll(sensorRepo.findByCasestyleContainingIgnoreCase(searchterm));
		foundComponents.addAll(sensorRepo.findByComponentIdContainingIgnoreCase(searchterm));
		ArrayList<Sensor> results = new ArrayList<>(foundComponents);
		return results;
	}

}
