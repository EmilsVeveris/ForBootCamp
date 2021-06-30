package lv.venta.eib.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.eib.model.Component;
import lv.venta.eib.repo.IComponentRepo;
import lv.venta.eib.service.IComponentService;

@Service
public class ComponentServiceImpl implements IComponentService {

	@Autowired
	IComponentRepo componentRepo;
	@Override
	public boolean addComponent(Component component) {
		ArrayList<Component> comp = componentRepo.findByComponentId(component.getComponentId());
		if (comp.isEmpty() == true)
		{
			componentRepo.save(component);
			return true;
		}
		return false;
	}

	public ArrayList<Component> showAllComponent()
	{
		return (ArrayList<Component>) componentRepo.findAll();
	}
	
	public ArrayList<Component> showComponentByCompID(String compID)
	{
		ArrayList<Component> comp = componentRepo.findByComponentId(compID);
		if (comp != null)
		{
			return comp;
		} else {
			return null;
		}
	}
	
	@Override
	public boolean editComponentById(Component component, int id) {
		Component comp = componentRepo.findById(id).get();
		if(comp != null)
		{

			comp.setCasestyle(component.getCasestyle());
			comp.setCasetype(component.getCasetype());
			comp.setComponentId(component.getComponentId());
			comp.setCount(component.getCount());
			comp.setDatasheet(component.getDatasheet());
			comp.setDescription(component.getDescription());
			comp.setRoom(component.getRoom());
			comp.setTolerance(component.getTolerance());
			componentRepo.save(comp);
			return true;
		}
		return false;
	}
	
	public boolean deleteComponentById(int id)
	{
		Component comp = componentRepo.findById(id).get();
		if(comp != null)
		{
			componentRepo.delete(comp);
			return true;
		}
		return false;
	}
	
	

}
