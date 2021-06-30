package lv.venta.eib.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.eib.model.Capacitor;
import lv.venta.eib.model.Inductor;
import lv.venta.eib.repo.IInductorRepo;
import lv.venta.eib.service.ICRUDInductorService;
@Service
public class CRUDInductorServiceImpl implements ICRUDInductorService {

	@Autowired
	IInductorRepo inductorRepo;
	@Override
	public boolean addInductor(Inductor inductor) {
		ArrayList<Inductor> comp = inductorRepo.findByComponentId(inductor.getComponentId());
		System.out.println(comp);
		if (comp.isEmpty())
		{
			inductorRepo.save(inductor);
			System.out.println("true");
			return true;
		}
		System.out.println("false");
		return false;
	}

	@Override
	public ArrayList<Inductor> showAllInductor() {
		return (ArrayList<Inductor>) inductorRepo.findAll();
	}

	@Override
	public Inductor selectById(int id) {
		Inductor comp = inductorRepo.findById(id).get();
		if (comp != null)
			return comp;
		else
			return new Inductor();
	}

	@Override
	public boolean editById(int id, Inductor inductor) {
		
		Inductor st = inductorRepo.findById(id).get();
		if(st != null)
		{
			//component values
			System.out.println("Editing the component");
			st.setComponentId(inductor.getComponentId());
			st.setCount(inductor.getCount());
			st.setCasestyle(inductor.getCasestyle());
			st.setCasetype(inductor.getCasetype());

			st.setDatasheet(inductor.getDatasheet());
			st.setDescription(inductor.getDescription());
			st.setRoom(inductor.getRoom());
			st.setTolerance(inductor.getTolerance());
			
			//Specific values
			st.setUnit(inductor.getUnit());
			st.setDcResistance(inductor.getDcResistance());
			st.setInductance(inductor.getInductance());
			st.setMaxCurrent(inductor.getMaxCurrent());
			inductorRepo.save(st);
			return true;
		}

		return false;
	}

	public ArrayList<Inductor> findInductorBySearchTerm(String searchterm) {
		Set<Inductor> foundComponents = new LinkedHashSet<>(inductorRepo.findByDescriptionContainingIgnoreCase(searchterm));
		foundComponents.addAll(inductorRepo.findByCasestyleContainingIgnoreCase(searchterm));
		try {
			foundComponents.addAll(inductorRepo.findByInductance(Float.parseFloat(searchterm)));
		} catch (NumberFormatException nfs) {
			System.out.println("not a number!");
		}
		foundComponents.addAll(inductorRepo.findByComponentIdContainingIgnoreCase(searchterm));
		ArrayList<Inductor> results = new ArrayList<>(foundComponents);
		return results;
	}
	
}
