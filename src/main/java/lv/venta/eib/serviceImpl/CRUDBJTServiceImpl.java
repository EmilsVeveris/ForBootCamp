package lv.venta.eib.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.eib.model.BJT;
import lv.venta.eib.repo.IBJTRepo;
import lv.venta.eib.service.ICRUDBJTService;

@Service
public class CRUDBJTServiceImpl implements ICRUDBJTService {
	@Autowired
	IBJTRepo bJTRepo;

	@Override
	public boolean addBJT(BJT bjt) {
		ArrayList<BJT> comp = bJTRepo.findByComponentId(bjt.getComponentId());
		if (comp.isEmpty() == true)
		{
			bJTRepo.save(bjt);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<BJT> showAllBJT() {
		return (ArrayList<BJT>) bJTRepo.findAll();
	}

	@Override
	public BJT selectById(int id) {
		BJT comp = bJTRepo.findById(id).get();
		if (comp != null)
			return comp;
		else
			return new BJT();
	}

	@Override
	public boolean editById(int id, BJT bjt) {
		
		BJT st = bJTRepo.findById(id).get();
		if(st != null)
		{
			//component values
			st.setComponentId(bjt.getComponentId());
			st.setCount(bjt.getCount());
			st.setCasestyle(bjt.getCasestyle());
			st.setCasetype(bjt.getCasetype());

			st.setDatasheet(bjt.getDatasheet());
			st.setDescription(bjt.getDescription());
			st.setRoom(bjt.getRoom());
			st.setTolerance(bjt.getTolerance());
			
			//Specific values
			st.setBjtType(bjt.getBjtType());
			st.setHfeGain(bjt.getHfeGain());
			st.setMaxCurrent(bjt.getMaxCurrent());
			st.setMaxVoltage(bjt.getMaxVoltage());
			bJTRepo.save(st);
			return true;
		}

		return false;
	}
	
	
	public ArrayList<BJT> findBJTBySearchTerm(String searchterm) {
		Set<BJT> foundComponents = new LinkedHashSet<>(bJTRepo.findByBjtTypeContainingIgnoreCase(searchterm));
		foundComponents.addAll(bJTRepo.findByCasestyleContainingIgnoreCase(searchterm));
		foundComponents.addAll(bJTRepo.findByComponentIdContainingIgnoreCase(searchterm));
		foundComponents.addAll(bJTRepo.findByDescriptionContainingIgnoreCase(searchterm));
		ArrayList<BJT> results = new ArrayList<>(foundComponents);
		return results;
	}

}

