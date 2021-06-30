package lv.venta.eib.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.eib.model.MOSFET;
import lv.venta.eib.model.Resistor;
import lv.venta.eib.repo.IResistorRepo;
import lv.venta.eib.service.ICRUDResistorService;

@Service
public class CRUDResistorServiceImpl implements ICRUDResistorService{

	@Autowired
	IResistorRepo resistorRepo;
	@Override
	public boolean addResistor(Resistor resistor) {
		ArrayList<Resistor> comp = resistorRepo.findByComponentId(resistor.getComponentId());
		if (comp.isEmpty() == true)
		{
			resistorRepo.save(resistor);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Resistor> showAllResistor() {
		return (ArrayList<Resistor>) resistorRepo.findAll();
	}

	@Override
	public Resistor selectById(int id) {
		Resistor comp = resistorRepo.findById(id).get();
		if (comp != null)
			return comp;
		else
			return new Resistor();
	}

	@Override
	public boolean editById(int id, Resistor resistor) {
		
		Resistor st = resistorRepo.findById(id).get();
		if(st != null)
		{
			//component values
			System.out.println("Editing the component");
			st.setComponentId(resistor.getComponentId());
			st.setCount(resistor.getCount());
			st.setCasestyle(resistor.getCasestyle());
			st.setCasetype(resistor.getCasetype());

			st.setDatasheet(resistor.getDatasheet());
			st.setDescription(resistor.getDescription());
			st.setRoom(resistor.getRoom());
			st.setTolerance(resistor.getTolerance());
			
			//Specific values
			st.setUnit(resistor.getUnit());
			st.setResistance(resistor.getResistance());
			resistorRepo.save(st);
			return true;
		}

		return false;
	}
	
	public ArrayList<Resistor> findResistorBySearchTerm(String searchterm) {
		Set<Resistor> foundComponents = new LinkedHashSet<>(resistorRepo.findByDescriptionContainingIgnoreCase(searchterm));
		foundComponents.addAll(resistorRepo.findByCasestyleContainingIgnoreCase(searchterm));
		try {
			foundComponents.addAll(resistorRepo.findByResistance(Float.parseFloat(searchterm)));
		} catch (NumberFormatException nfs) {
			System.out.println("not a number!");
		}
		foundComponents.addAll(resistorRepo.findByComponentIdContainingIgnoreCase(searchterm));
		ArrayList<Resistor> results = new ArrayList<>(foundComponents);
		return results;
	}

}
