package lv.venta.eib.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lv.venta.eib.model.MOSFET;
import lv.venta.eib.model.MicroController;
import lv.venta.eib.repo.IMOSFETRepo;
import lv.venta.eib.service.ICRUDMOSFETService;

@Service
public class CRUDMOSFETServiceImpl implements ICRUDMOSFETService {

	@Autowired
	IMOSFETRepo mOSFETRepo;
	@Override
	public boolean addMOSFET(MOSFET mosfet) {
		ArrayList<MOSFET> comp = mOSFETRepo.findByComponentId(mosfet.getComponentId());
		if (comp.isEmpty() == true)
		{
			mOSFETRepo.save(mosfet);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<MOSFET> showAllMOSFET() {
		return (ArrayList<MOSFET>) mOSFETRepo.findAll();
	}

	@Override
	public MOSFET selectById(int id) {
		MOSFET comp = mOSFETRepo.findById(id).get();
		if (comp != null)
			return comp;
		else
			return new MOSFET();
	}

	@Override
	public boolean editById(int id, MOSFET mosfet) {
		
		MOSFET st = mOSFETRepo.findById(id).get();
		if(st != null)
		{
			//component values
			st.setComponentId(mosfet.getComponentId());
			st.setCount(mosfet.getCount());
			st.setCasestyle(mosfet.getCasestyle());
			st.setCasetype(mosfet.getCasetype());

			st.setDatasheet(mosfet.getDatasheet());
			st.setDescription(mosfet.getDescription());
			st.setRoom(mosfet.getRoom());
			st.setTolerance(mosfet.getTolerance());
			
			//Specific values
			st.setGateVoltage(mosfet.getGateVoltage());
			st.setMaxCurrent(mosfet.getMaxCurrent());
			st.setMaxVoltage(mosfet.getMaxVoltage());
			st.setMosfetType(mosfet.getMosfetType());
			mOSFETRepo.save(st);
			return true;
		}

		return false;
	}
	
	public ArrayList<MOSFET> findMOSFETBySearchTerm(String searchterm) {
		Set<MOSFET> foundComponents = new LinkedHashSet<>(mOSFETRepo.findByDescriptionContainingIgnoreCase(searchterm));
		foundComponents.addAll(mOSFETRepo.findByCasestyleContainingIgnoreCase(searchterm));
		foundComponents.addAll(mOSFETRepo.findByComponentIdContainingIgnoreCase(searchterm));
		ArrayList<MOSFET> results = new ArrayList<>(foundComponents);
		
		return results;
	}

}
