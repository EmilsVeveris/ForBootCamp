package lv.venta.eib.repo;

import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;

import lv.venta.eib.model.Component;

public interface IComponentRepo  extends CrudRepository<Component, Integer> {

	ArrayList<Component> findByComponentId(String componentId);
	

}
