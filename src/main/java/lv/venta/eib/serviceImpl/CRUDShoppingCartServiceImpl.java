package lv.venta.eib.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.eib.model.BJT;
import lv.venta.eib.model.Capacitor;
import lv.venta.eib.model.Component;
import lv.venta.eib.model.Inductor;
import lv.venta.eib.model.IntegralCircuit;
import lv.venta.eib.model.MOSFET;
import lv.venta.eib.model.MicroController;
import lv.venta.eib.model.Resistor;
import lv.venta.eib.model.Sensor;
import lv.venta.eib.model.ShoppingCart;
import lv.venta.eib.repo.IBJTRepo;
import lv.venta.eib.repo.ICapacitorRepo;
import lv.venta.eib.repo.IComponentRepo;
import lv.venta.eib.repo.IInductorRepo;
import lv.venta.eib.repo.IIntegralCircuitRepo;
import lv.venta.eib.repo.IMOSFETRepo;
import lv.venta.eib.repo.IMicroControllerRepo;
import lv.venta.eib.repo.IResistorRepo;
import lv.venta.eib.repo.ISensorRepo;
import lv.venta.eib.repo.IShoppingCartRepo;
import lv.venta.eib.service.ICRUDShoppingCartService;

@Service
public class CRUDShoppingCartServiceImpl implements ICRUDShoppingCartService {

	@Autowired
	IComponentRepo componentRepo;
	@Autowired
	IShoppingCartRepo shoppingCartRepo;
	@Autowired
	ISensorRepo sensorRepo;
	@Autowired
	IBJTRepo bjtRepo;
	@Autowired
	ICapacitorRepo capacitorRepo;
	@Autowired
	IInductorRepo inductorRepo;
	@Autowired
	IIntegralCircuitRepo integralCircuitRepo;
	@Autowired
	IMicroControllerRepo microControllerRepo;
	@Autowired
	IMOSFETRepo mosfetRepo;
	@Autowired
	IResistorRepo resistorRepo;
	
	
	
	@Override
	public boolean addSensorToShoppingCart(Sensor sensor, int count) {
		ArrayList<Sensor> st1 = sensorRepo.findByComponentId(sensor.getComponentId());
		if(st1 != null)
		{
			Sensor st = st1.get(0);
			//component values
			if(st.getCount() >= count) {
				if((shoppingCartRepo.findAllByComponentId(st.getComponentId())).isEmpty() == true) {
					ShoppingCart shop = new ShoppingCart(st.getComponentId(), count);
					st.setCount((sensor.getCount()-count));
					shoppingCartRepo.save(shop);
					sensorRepo.save(st);
				} else {
					ArrayList<ShoppingCart> shopList =  shoppingCartRepo.findAllByComponentId(st.getComponentId());
					ShoppingCart shop = shopList.get(0);
					shop.setCount(shop.getCount()+count);
					st.setCount((sensor.getCount()-count));
					shoppingCartRepo.save(shop);
					sensorRepo.save(st);
				}
				return true;
			}
			return false;
		}
		return false;
	}
	
	@Override
	public boolean addBJTToShoppingCart(BJT bjt, int count) {
		ArrayList<BJT> st1 = bjtRepo.findByComponentId(bjt.getComponentId());
		if(st1 != null)
		{
			BJT st = st1.get(0);
			//component values
			if(st.getCount() >= count) {
				if((shoppingCartRepo.findAllByComponentId(st.getComponentId())).isEmpty() == true) {
					ShoppingCart shop = new ShoppingCart(st.getComponentId(), count);
					st.setCount((bjt.getCount()-count));
					shoppingCartRepo.save(shop);
					bjtRepo.save(st);
				} else {
					ArrayList<ShoppingCart> shopList =  shoppingCartRepo.findAllByComponentId(st.getComponentId());
					ShoppingCart shop = shopList.get(0);
					shop.setCount(shop.getCount()+count);
					st.setCount((bjt.getCount()-count));
					shoppingCartRepo.save(shop);
					bjtRepo.save(st);
				}
				return true;
			}
			return false;
		}
		return false;
	}
	
	@Override
	public boolean addCapacitorToShoppingCart(Capacitor capacitor, int count) {
		ArrayList<Capacitor> st1 = capacitorRepo.findByComponentId(capacitor.getComponentId());
		if(st1 != null)
		{
			Capacitor st = st1.get(0);
			//component values
			if(st.getCount() >= count) {
				if((shoppingCartRepo.findAllByComponentId(st.getComponentId())).isEmpty() == true) {
					ShoppingCart shop = new ShoppingCart(st.getComponentId(), count);
					st.setCount((capacitor.getCount()-count));
					shoppingCartRepo.save(shop);
					capacitorRepo.save(st);
				} else {
					ArrayList<ShoppingCart> shopList =  shoppingCartRepo.findAllByComponentId(st.getComponentId());
					ShoppingCart shop = shopList.get(0);
					shop.setCount(shop.getCount()+count);
					st.setCount((capacitor.getCount()-count));
					shoppingCartRepo.save(shop);
					capacitorRepo.save(st);
				}
				return true;
			}
			return false;
		}
		return false;
	}
	

	@Override
	public boolean addInductorToShoppingCart(Inductor inductor, int count) {
		ArrayList<Inductor> st1 = inductorRepo.findByComponentId(inductor.getComponentId());
		if(st1 != null)
		{
			Inductor st = st1.get(0);
			//component values
			if(st.getCount() >= count) {
				if((shoppingCartRepo.findAllByComponentId(st.getComponentId())).isEmpty() == true) {
					ShoppingCart shop = new ShoppingCart(st.getComponentId(), count);
					st.setCount((inductor.getCount()-count));
					shoppingCartRepo.save(shop);
					inductorRepo.save(st);
				} else {
					ArrayList<ShoppingCart> shopList =  shoppingCartRepo.findAllByComponentId(st.getComponentId());
					ShoppingCart shop = shopList.get(0);
					shop.setCount(shop.getCount()+count);
					st.setCount((inductor.getCount()-count));
					shoppingCartRepo.save(shop);
					inductorRepo.save(st);
				}
				return true;
			}
			return false;
		}
		return false;
	}
	

	@Override
	public boolean addIntegralCircuitToShoppingCart(IntegralCircuit integralCircuit, int count) {
		ArrayList<IntegralCircuit> st1 = integralCircuitRepo.findByComponentId(integralCircuit.getComponentId());
		if(st1 != null)
		{
			IntegralCircuit st = st1.get(0);
			//component values
			if(st.getCount() >= count) {
				if((shoppingCartRepo.findAllByComponentId(st.getComponentId())).isEmpty() == true) {
					ShoppingCart shop = new ShoppingCart(st.getComponentId(), count);
					st.setCount((integralCircuit.getCount()-count));
					shoppingCartRepo.save(shop);
					integralCircuitRepo.save(st);
				} else {
					ArrayList<ShoppingCart> shopList =  shoppingCartRepo.findAllByComponentId(st.getComponentId());
					ShoppingCart shop = shopList.get(0);
					shop.setCount(shop.getCount()+count);
					st.setCount((integralCircuit.getCount()-count));
					shoppingCartRepo.save(shop);
					integralCircuitRepo.save(st);
				}
				return true;
			}
			return false;
		}
		return false;
	}
	
	@Override
	public boolean addMicroControllerToShoppingCart(MicroController microController, int count) {
		ArrayList<MicroController> st1 = microControllerRepo.findByComponentId(microController.getComponentId());
		if(st1 != null)
		{
			MicroController st = st1.get(0);
			//component values
			if(st.getCount() >= count) {
				if((shoppingCartRepo.findAllByComponentId(st.getComponentId())).isEmpty() == true) {
					ShoppingCart shop = new ShoppingCart(st.getComponentId(), count);
					st.setCount((microController.getCount()-count));
					shoppingCartRepo.save(shop);
					microControllerRepo.save(st);
				} else {
					ArrayList<ShoppingCart> shopList =  shoppingCartRepo.findAllByComponentId(st.getComponentId());
					ShoppingCart shop = shopList.get(0);
					shop.setCount(shop.getCount()+count);
					st.setCount((microController.getCount()-count));
					shoppingCartRepo.save(shop);
					microControllerRepo.save(st);
				}
				return true;
			}
			return false;
		}
		return false;
	}
	

	@Override
	public boolean addMOSFETToShoppingCart(MOSFET mosfet, int count) {
		ArrayList<MOSFET> st1 = mosfetRepo.findByComponentId(mosfet.getComponentId());
		if(st1 != null)
		{
			MOSFET st = st1.get(0);
			//component values
			if(st.getCount() >= count) {
				if((shoppingCartRepo.findAllByComponentId(st.getComponentId())).isEmpty() == true) {
					ShoppingCart shop = new ShoppingCart(st.getComponentId(), count);
					st.setCount((mosfet.getCount()-count));
					shoppingCartRepo.save(shop);
					mosfetRepo.save(st);
				} else {
					ArrayList<ShoppingCart> shopList =  shoppingCartRepo.findAllByComponentId(st.getComponentId());
					ShoppingCart shop = shopList.get(0);
					shop.setCount(shop.getCount()+count);
					st.setCount((mosfet.getCount()-count));
					shoppingCartRepo.save(shop);
					mosfetRepo.save(st);
				}
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean addResistorToShoppingCart(Resistor resistor, int count) {
		ArrayList<Resistor> st1 = resistorRepo.findByComponentId(resistor.getComponentId());
		if(st1 != null)
		{
			Resistor st = st1.get(0);
			//component values
			if(st.getCount() >= count) {
				if((shoppingCartRepo.findAllByComponentId(st.getComponentId())).isEmpty() == true) {
					ShoppingCart shop = new ShoppingCart(st.getComponentId(), count);
					st.setCount((resistor.getCount()-count));
					shoppingCartRepo.save(shop);
					resistorRepo.save(st);
				} else {
					ArrayList<ShoppingCart> shopList =  shoppingCartRepo.findAllByComponentId(st.getComponentId());
					ShoppingCart shop = shopList.get(0);
					shop.setCount(shop.getCount()+count);
					st.setCount((resistor.getCount()-count));
					shoppingCartRepo.save(shop);
					resistorRepo.save(st);
				}
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public ArrayList<ShoppingCart> showAllShoppingCart() {
		return (ArrayList<ShoppingCart>) shoppingCartRepo.findAll();
	}

	@Override
	public boolean removeComponentFromShoppingCart(ShoppingCart shoppingCart, int count) {
		ArrayList<Component> compList =  componentRepo.findByComponentId(shoppingCart.getComponentId());
		if(compList.isEmpty() == false) {
			Component comp = compList.get(0);
			if (shoppingCart.getCount() >= count)
			{
				comp.setCount(comp.getCount() + count);
				shoppingCart.setCount(shoppingCart.getCount() - count);	
				if( shoppingCart.getCount() == 0)
				{
					componentRepo.save(comp);
					shoppingCartRepo.delete(shoppingCart);
				} else {
					componentRepo.save(comp);
					shoppingCartRepo.save(shoppingCart);
				}
				return true;
			}
		}
		return false;
	}
	
	@Override
	public ShoppingCart selectById(int id)
	{
		ShoppingCart comp = new ShoppingCart();
		 try {
			  comp = shoppingCartRepo.findById(id).get();
			 } catch (Exception e) {
				 System.out.println("No object found");
			 }
		return comp;
	}
}
