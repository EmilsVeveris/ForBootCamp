package lv.venta.eib.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.eib.model.ShoppingCart;

public interface IShoppingCartRepo extends CrudRepository<ShoppingCart, Integer> {

	ArrayList<ShoppingCart> findAllByComponentId(String componentId);
	

}
