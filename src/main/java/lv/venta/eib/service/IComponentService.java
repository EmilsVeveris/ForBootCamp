package lv.venta.eib.service;

import java.util.ArrayList;

import lv.venta.eib.model.Component;

public interface IComponentService {

	public boolean addComponent(Component component);
	
	public ArrayList<Component> showComponentByCompID(String compID);
	
	public ArrayList<Component> showAllComponent();
	
	public boolean editComponentById(Component component, int id);
	
}
