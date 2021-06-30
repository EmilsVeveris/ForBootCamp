package lv.venta.eib.service;


import java.util.ArrayList;

import lv.venta.eib.model.BJT;
import lv.venta.eib.model.Capacitor;
import lv.venta.eib.model.Inductor;
import lv.venta.eib.model.IntegralCircuit;
import lv.venta.eib.model.MOSFET;
import lv.venta.eib.model.MicroController;
import lv.venta.eib.model.Resistor;
import lv.venta.eib.model.Sensor;
import lv.venta.eib.model.ShoppingCart;


public interface ICRUDShoppingCartService {

	public ArrayList<ShoppingCart> showAllShoppingCart();
	
	boolean addSensorToShoppingCart(Sensor sensor, int count);

	boolean addBJTToShoppingCart(BJT bjt, int count);

	boolean addResistorToShoppingCart(Resistor resistor, int count);

	boolean addMOSFETToShoppingCart(MOSFET mosfet, int count);

	boolean addMicroControllerToShoppingCart(MicroController microController, int count);

	boolean addIntegralCircuitToShoppingCart(IntegralCircuit integralCircuit, int count);

	boolean addInductorToShoppingCart(Inductor inductor, int count);

	boolean addCapacitorToShoppingCart(Capacitor capacitor, int count);

	boolean removeComponentFromShoppingCart(ShoppingCart shoppingCart, int count);

	public ShoppingCart selectById(int id);

}
