package lv.venta.eib.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.eib.model.BJT;
import lv.venta.eib.model.Capacitor;
import lv.venta.eib.repo.ICapacitorRepo;
import lv.venta.eib.service.ICRUDCapacitorService;

@Service
public class CRUDCapacitorServiceImpl implements ICRUDCapacitorService {

	@Autowired
	ICapacitorRepo capacitorRepo;
	@Override
	public boolean addCapacitor(Capacitor capacitor) {
		ArrayList<Capacitor> comp = capacitorRepo.findByComponentId(capacitor.getComponentId());
		if (comp.isEmpty() == true)
		{
			capacitorRepo.save(capacitor);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Capacitor> showAllCapacitor() {
		return (ArrayList<Capacitor>) capacitorRepo.findAll();
	}

	@Override
	public Capacitor selectById(int id) {
		Capacitor comp = capacitorRepo.findById(id).get();
		if (comp != null)
			return comp;
		else
			return new Capacitor();
	}

	@Override
	public boolean editById(int id, Capacitor capacitor) {
		
		Capacitor st = capacitorRepo.findById(id).get();
		if(st != null)
		{
			//component values
			System.out.println("Editing the component");
			st.setComponentId(capacitor.getComponentId());
			st.setCount(capacitor.getCount());
			st.setCasestyle(capacitor.getCasestyle());
			st.setCasetype(capacitor.getCasetype());

			st.setDatasheet(capacitor.getDatasheet());
			st.setDescription(capacitor.getDescription());
			st.setRoom(capacitor.getRoom());
			st.setTolerance(capacitor.getTolerance());
			
			//Specific values
			st.setCapacitance(capacitor.getCapacitance());
			st.setMaxTemp(capacitor.getMaxTemp());
			st.setMaxVoltage(capacitor.getMaxVoltage());
			st.setUnit(capacitor.getUnit());
			capacitorRepo.save(st);
			return true;
		}

		return false;
	}

	public ArrayList<Capacitor> findCapacitorBySearchTerm(String searchterm) {
		Set<Capacitor> foundComponents = new LinkedHashSet<>(capacitorRepo.findByDescriptionContainingIgnoreCase(searchterm));
		foundComponents.addAll(capacitorRepo.findByCasestyleContainingIgnoreCase(searchterm));
		try {
			foundComponents.addAll(capacitorRepo.findByCapacitance(Float.parseFloat(searchterm)));
		} catch (NumberFormatException nfs) {
			System.out.println("not a number!");
		}
		foundComponents.addAll(capacitorRepo.findByComponentIdContainingIgnoreCase(searchterm));
		ArrayList<Capacitor> results = new ArrayList<>(foundComponents);
		return results;
	}
	
}
