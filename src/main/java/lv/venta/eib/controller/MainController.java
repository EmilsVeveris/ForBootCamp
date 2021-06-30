package lv.venta.eib.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.eib.WebSecurityConfig;
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
import lv.venta.eib.model.UserRole;
import lv.venta.eib.repo.IUserRepo;
import lv.venta.eib.repo.IUserRoleRepo;
import lv.venta.eib.service.ICRUDBJTService;
import lv.venta.eib.service.ICRUDCapacitorService;
import lv.venta.eib.service.ICRUDInductorService;
import lv.venta.eib.service.ICRUDIntegralCircuitService;
import lv.venta.eib.service.ICRUDMOSFETService;
import lv.venta.eib.service.ICRUDMicroControllerService;
import lv.venta.eib.service.ICRUDResistorService;
import lv.venta.eib.service.ICRUDSensorService;
import lv.venta.eib.service.ICRUDShoppingCartService;
import lv.venta.eib.service.IComponentService;

@Controller
public class MainController {
	
	@Autowired
	IComponentService componentService;
	@Autowired
	ICRUDInductorService inductorService;
	@Autowired
	ICRUDIntegralCircuitService integralCircuitService;
	@Autowired
	ICRUDMicroControllerService microControllerService;
	@Autowired
	ICRUDMOSFETService mosfetService;
	@Autowired
	ICRUDResistorService resistorService;
	@Autowired
	ICRUDSensorService sensorService;
	@Autowired
	ICRUDBJTService bjtService;
	@Autowired
	ICRUDCapacitorService capacitorService;
	@Autowired
	ICRUDShoppingCartService shoppingCartService;
	@Autowired
	IUserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	IUserRoleRepo userRoleRepo;

	@GetMapping({"/index", "/"})
	 public String getAllComponents(Model model)
	 { 
		 model.addAttribute("induc", inductorService.showAllInductor()); 
		 model.addAttribute("ic", integralCircuitService.showAllIntegralCircuit());
		 model.addAttribute("mc", microControllerService.showAllMicroController());
		 model.addAttribute("mosfet", mosfetService.showAllMOSFET());
		 model.addAttribute("res", resistorService.showAllResistor());
		 model.addAttribute("sen", sensorService.showAllSensor());
		 model.addAttribute("bjt", bjtService.showAllBJT());
		 model.addAttribute("cap", capacitorService.showAllCapacitor());
		 return "index";
	 }
	
	@GetMapping("/addComponent/addInductor")
	public String getAddInductor(Inductor inductor)
	{
		return "/addComponent/addInductor";
	}
	
	@PostMapping("/addComponent/addInductor")
	public String postAddInductor(@Valid Inductor inductor, BindingResult result)
	{

		if(!result.hasErrors())
		{
			if (inductorService.addInductor(inductor) == true)
			{
				return "redirect:/index";
			} else {
				return "error";
			}
		} else
		{
			return "/addComponent/addInductor";
		}
	}
	

	@GetMapping("/addComponent/addBJT")
	public String getAddBJT(BJT bJT, Model model)
	{
		model.addAttribute("bJT", new BJT());
		return "/addComponent/addBJT";
	}
	
	@PostMapping("/addComponent/addBJT")
	public String postAddBJT(@ModelAttribute("bJT")@Valid BJT bJT, BindingResult result, Model model)
	{

		if(!result.hasErrors())
		{
			if (bjtService.addBJT(bJT) == true)
			{
				return "redirect:/index";
			} else {
				return "error";
			}
		} else
		{
			return "/addComponent/addBJT";
		}
	}
	
	@GetMapping("/addComponent/addCapacitor")
	public String getAddCapacitor(Capacitor capacitor)
	{
		return "/addComponent/addCapacitor";
	}
	
	@PostMapping("/addComponent/addCapacitor")
	public String postAddCapacitor(@Valid Capacitor capacitor, BindingResult result)
	{

		if(!result.hasErrors())
		{
			if (capacitorService.addCapacitor(capacitor) == true)
			{
				return "redirect:/index";
			} else {
				return "error";
			}
		} else
		{
			return "/addComponent/addCapacitor";
		}
	}
	
	@GetMapping("/addComponent/addIntegralCircuit")
	public String getAddIntegralCircuit(IntegralCircuit integralCircuit)
	{
		return "/addComponent/addIntegralCircuit";
	}
	
	@PostMapping("/addComponent/addIntegralCircuit")
	public String postAddIntegralCircuit(@Valid IntegralCircuit integralCircuit, BindingResult result)
	{

		if(!result.hasErrors())
		{
			if (integralCircuitService.addIntegralCircuit(integralCircuit) == true)
			{
				return "redirect:/index";
			} else {
				return "error";
			}
		} else
		{
			return "/addComponent/addIntegralCircuit";
		}
	}
	
	@GetMapping("/addComponent/addMicroController")
	public String getAddMicroController(MicroController microController)
	{
		return "/addComponent/addMicroController";
	}
	
	@PostMapping("/addComponent/addMicroController")
	public String postAddMicroController(@Valid MicroController microController, BindingResult result)
	{

		if(!result.hasErrors())
		{
			if (microControllerService.addMicroController(microController) == true)
			{
				return "redirect:/index";
			} else {
				return "error";
			}
		} else
		{
			return "/addComponent/addMicroController";
		}
	}
	
	@GetMapping("/addComponent/addMOSFET")
	public String getAddMOSFET(MOSFET mosfet, Model model)
	{
		model.addAttribute("mosfet", new MOSFET());
		return "/addComponent/addMOSFET";
	}
	
	@PostMapping("/addComponent/addMOSFET")
	public String postAddMOSFET(@ModelAttribute("mosfet")@Valid MOSFET mosfet, BindingResult result, Model model)
	{
		

		if(!result.hasErrors())
		{
			if (mosfetService.addMOSFET(mosfet) == true)
			{
				return "redirect:/index";
			} else {
				return "error";
			}
		} else
		{
			return "/addComponent/addMOSFET";
		}
	}
	
	@GetMapping("/addComponent/addResistor")
	public String getAddResistor(Resistor resistor)
	{
		return "/addComponent/addResistor";
	}
	
	@PostMapping("/addComponent/addResistor")
	public String postAddResistor(@Valid Resistor resistor, BindingResult result)
	{

		if(!result.hasErrors())
		{
			if (resistorService.addResistor(resistor) == true)
			{
				return "redirect:/index";
			} else {
				return "error";
			}
		} else
		{
			return "/addComponent/addResistor";
		}
	}
	
	@GetMapping("/addComponent/addSensor")
	public String getAddSensor(Sensor sensor)
	{
		return "/addComponent/addSensor";
	}
	
	@PostMapping("/addComponent/addSensor")
	public String postAddSensor(@Valid Sensor sensor, BindingResult result)
	{
		if(!result.hasErrors())
		{
			if (sensorService.addSensor(sensor) == true)
			{
				return "redirect:/index";
			} else {
				return "error";
			}
		} else
		{
			return "/addComponent/addSensor";
		}
	}
	
	@GetMapping("/categories")
	public String getCategories()
	{
		return "categories";
	}
	
	@GetMapping("/contacts")
	public String getContacts()
	{
		return "contacts";
	}
	

	@GetMapping("/register")
	public String getRegister(lv.venta.eib.model.User user)
	{
		System.out.println("Added new user test");
		return "register";
	}

	@PostMapping("/register")
	public String postRegister(lv.venta.eib.model.User user)
	{		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println("test1");
		lv.venta.eib.model.User user1 = new lv.venta.eib.model.User(user.getName(), user.getSurname(), user.getEmail(), user.getUsername(), passwordEncoder.encode(user.getPassword()));
		userRepo.save(user1);
		
		UserRole userRole2 = userRoleRepo.findByRoleTitle("USER");

		user1.addUserRole(userRole2);
		System.out.println("Added new user test");
		
		userRepo.save(user1);
		userRole2.addUser(user1);
		userRoleRepo.save(userRole2);

			return "redirect:/index";
	}
	
	//TODO POST REGISTER

	@GetMapping("/login")
	public String getLogin()
	{
		
		return "login";
	}	
	
	@GetMapping("/component/showResistor/{id}")
	public String getShowResistor(Resistor inputData, Model model, @PathVariable(name="id") int id) {
		Resistor data = new Resistor();
		model.addAttribute("res", resistorService.selectById(id));
		model.addAttribute("countData", data);

		return "/component/showResistor";
	}
	
	@PostMapping("/component/showResistor/{id}")
	public String postShowResistor(Resistor inputData, Model model, @PathVariable(name="id") int id)
	{
		Resistor data = resistorService.selectById(id);
		shoppingCartService.addResistorToShoppingCart(data, inputData.getCount());
		
		return "redirect:/index";
	}
	
	@GetMapping("/component/showCapacitor/{id}")
	public String getShowCapacitor(Capacitor inputData, Model model, @PathVariable(name="id") int id) {
		Capacitor data = new Capacitor();
		model.addAttribute("cap", capacitorService.selectById(id));
		model.addAttribute("countData", data);

		return "/component/showCapacitor";
	}
	
	@PostMapping("/component/showCapacitor/{id}")
	public String postShowCapacitor(Capacitor inputData, Model model, @PathVariable(name="id") int id)
	{
		Capacitor data = capacitorService.selectById(id);
		shoppingCartService.addCapacitorToShoppingCart(data, inputData.getCount());
		
		return "redirect:/index";
	}
	
	@GetMapping("/component/showInductor/{id}")
	public String getShowInductor(Inductor inputData, Model model, @PathVariable(name="id") int id) {
		Inductor data = new Inductor();
		model.addAttribute("induc", inductorService.selectById(id));
		model.addAttribute("countData", data);

		return "/component/showInductor";
	}
	
	@PostMapping("/component/showInductor/{id}")
	public String postShowInductor(Inductor inputData, Model model, @PathVariable(name="id") int id)
	{
		Inductor data = inductorService.selectById(id);
		shoppingCartService.addInductorToShoppingCart(data, inputData.getCount());
		
		return "redirect:/index";
	}
	
	@GetMapping("/component/showBjt/{id}")
	public String getShowBjt(BJT inputData, Model model, @PathVariable(name="id") int id) {
		BJT data = new BJT();
		model.addAttribute("bjt", bjtService.selectById(id));
		model.addAttribute("countData", data);

		return "/component/showBjt";
	}
	
	@PostMapping("/component/showBjt/{id}")
	public String postShowBjt(BJT inputData, Model model, @PathVariable(name="id") int id)
	{
		BJT data = bjtService.selectById(id);
		shoppingCartService.addBJTToShoppingCart(data, inputData.getCount());
		
		return "redirect:/index";
	}
	
	@GetMapping("/component/showIc/{id}")
	public String getShowIc(IntegralCircuit inputData, Model model, @PathVariable(name="id") int id) {
		IntegralCircuit data = new IntegralCircuit();
		model.addAttribute("ic", integralCircuitService.selectById(id));
		model.addAttribute("countData", data);

		return "/component/showIc";
	}
	
	@PostMapping("/component/showIc/{id}")
	public String postShowIc(IntegralCircuit inputData, Model model, @PathVariable(name="id") int id)
	{
		IntegralCircuit data = integralCircuitService.selectById(id);
		shoppingCartService.addIntegralCircuitToShoppingCart(data, inputData.getCount());
		
		return "redirect:/index";
	}
	

	@GetMapping("/component/showMicrocontroller/{id}")
	public String getShowMicrocontroller(MicroController inputData, Model model, @PathVariable(name="id") int id) {
		MicroController data = new MicroController();
		model.addAttribute("mc", microControllerService.selectById(id));
		model.addAttribute("countData", data);

		return "/component/showMicrocontroller";
	}
	
	@PostMapping("/component/showMicrocontroller/{id}")
	public String postShowMicrocontroller(MicroController inputData, Model model, @PathVariable(name="id") int id)
	{
		MicroController data = microControllerService.selectById(id);
		shoppingCartService.addMicroControllerToShoppingCart(data, inputData.getCount());
		
		return "redirect:/index";
	}
	
	@GetMapping("/component/showMosfet/{id}")
	public String getShowMosfet(MOSFET inputData, Model model, @PathVariable(name="id") int id) {
		MOSFET data = new MOSFET();
		model.addAttribute("mosfet", mosfetService.selectById(id));
		model.addAttribute("countData", data);

		return "/component/showMosfet";
	}
	
	@PostMapping("/component/showMosfet/{id}")
	public String postShowMosfet(MOSFET inputData, Model model, @PathVariable(name="id") int id)
	{
		MOSFET data = mosfetService.selectById(id);
		shoppingCartService.addMOSFETToShoppingCart(data, inputData.getCount());
		
		return "redirect:/index";
	}

	@GetMapping("/component/showSensor/{id}")
	public String getShowSensor(Sensor sensor, Model model, @PathVariable(name="id") int id) {
		Sensor sen = new Sensor();
		model.addAttribute("sen", sensorService.selectById(id));
		model.addAttribute("countData", sen);

		return "/component/showSensor";
	}
	
	@PostMapping("/component/showSensor/{id}")
	public String postShowSensor(Sensor sensor, Model model, @PathVariable(name="id") int id)
	{
		Sensor sen = sensorService.selectById(id);
		shoppingCartService.addSensorToShoppingCart(sen, sensor.getCount());
		
		return "redirect:/index";
	}
	
	@GetMapping("/component/removeFromShoppingCart/{id}")
	public String getRemoveFromShoppingCart(Component comp, Model model, @PathVariable(name="id") int id) {
		Component sen = new Component();
		model.addAttribute("countData", sen);
		model.addAttribute("sen", shoppingCartService.selectById(id));

		return "/component/removeFromShoppingCart";
	}
	
	@PostMapping("/component/removeFromShoppingCart/{id}")
	public String postRemoveFromShoppingCart(Component comp, Model model, @PathVariable(name="id") int id)
	{

		ShoppingCart sen = shoppingCartService.selectById(id);
		shoppingCartService.removeComponentFromShoppingCart(sen, comp.getCount());
		
		return "redirect:/index";
	}
	
	@GetMapping("/showComponents/showAllResistors")
	public String getShowAllResistors(Model model)
	{
		model.addAttribute("res", resistorService.showAllResistor());
		return "/showComponents/showAllResistors";
	}
	
	@GetMapping("/showComponents/showAllCapacitors")
	public String getShowAllCapacitors(Model model)
	{	
		model.addAttribute("cap", capacitorService.showAllCapacitor());
		return "/showComponents/showAllCapacitors";
	}
	
	@GetMapping("/showComponents/showAllInductors")
	public String getShowAllInductors(Model model)
	{
		model.addAttribute("induc", inductorService.showAllInductor()); 
		return "/showComponents/showAllInductors";
	}
	
	@GetMapping("/showComponents/showAllSensors")
	public String getShowAllSensors(Model model)
	{
		model.addAttribute("sen", sensorService.showAllSensor());
		return "/showComponents/showAllSensors";
	}
	
	@GetMapping("/showComponents/showAllBjts")
	public String getShowAllBjts(Model model)
	{
		model.addAttribute("bjt", bjtService.showAllBJT());
		return "/showComponents/showAllBjts";
	}
	
	@GetMapping("/showComponents/showAllMosfets")
	public String getShowAllMosfets(Model model)
	{
		model.addAttribute("mosfet", mosfetService.showAllMOSFET());
		return "/showComponents/showAllMosfets";
	}
	
	@GetMapping("/showComponents/showAllMicrocontrollers")
	public String getShowAllMicrocontrollers(Model model)
	{
		model.addAttribute("mc", microControllerService.showAllMicroController());
		return "/showComponents/showAllMicrocontrollers";
	}
	
	@GetMapping("/showComponents/showAllIcs")
	public String getShowAllIcs(Model model)
	{
		model.addAttribute("ic", integralCircuitService.showAllIntegralCircuit());
		return "/showComponents/showAllIcs";
	}
	
	@GetMapping("/showComponents/showAllShoppingCart")
	public String getShowAllShoppingCart(Model model)
	{
		model.addAttribute("cart", shoppingCartService.showAllShoppingCart());
		return "/showComponents/showAllShoppingCart";
	}
	
	@GetMapping("/editComponent/editInductor/{id}")
	public String getEditInductor(Inductor inductor, Model model, @PathVariable(name = "id") int id)
	{
		try {
			model.addAttribute("inductor", inductorService.selectById(id));
			return"/editComponent/editInductor";
		} catch (Exception e) {
			return "error";
		}

	}

	@PostMapping("/editComponent/editInductor/{id}")
	public String postEditInductor(@Valid Inductor inductor, @PathVariable(name = "id") int id)
	{
		if (inductorService.editById(id, inductor))
		{
			return "redirect:/index";
		} else {
			return "error";
		}
	}
	
	@GetMapping("/editComponent/editBJT/{id}")
	public String getEditBJT(BJT bjt, Model model, @PathVariable(name = "id") int id)
	{
		try {
			model.addAttribute("bjt", bjtService.selectById(id));
			return"/editComponent/editBJT";
		} catch (Exception e) {
			return "error";
		}
	}

	@PostMapping("/editComponent/editBJT/{id}")
	public String postEditBJT(@Valid BJT bjt, @PathVariable(name = "id") int id)
	{
		if (bjtService.editById(id, bjt))
		{
			return "redirect:/index";
		} else {
			return "error";
		}
	}
	
	@GetMapping("/editComponent/editCapacitor/{id}")
	public String getEditCapacitor(Capacitor capacitor, Model model, @PathVariable(name = "id") int id)
	{
		try {
			model.addAttribute("capacitor", capacitorService.selectById(id));
			return"/editComponent/editCapacitor";
		} catch (Exception e) {
			return "error";
		}
	}

	@PostMapping("/editComponent/editCapacitor/{id}")
	public String postEditCapacitor(@Valid Capacitor capacitor, @PathVariable(name = "id") int id)
	{
		if (capacitorService.editById(id, capacitor))
		{
			return "redirect:/index";
		} else {
			return "error";
		}
	}
	
	@GetMapping("/editComponent/editIntegralCircuit/{id}")
	public String getEditIntegralCircuit(IntegralCircuit integralCircuit, Model model, @PathVariable(name = "id") int id)
	{
		try {
			model.addAttribute("integralCircuit", integralCircuitService.selectById(id));
			return"/editComponent/editIntegralCircuit";
		} catch (Exception e) {
			return "error";
		}
	}

	@PostMapping("/editComponent/editIntegralCircuit/{id}")
	public String postEditIntegralCircuit(@Valid IntegralCircuit integralCircuit, @PathVariable(name = "id") int id)
	{
		if (integralCircuitService.editById(id, integralCircuit))
		{
			return "redirect:/index";
		} else {
			return "error";
		}
	}
	
	@GetMapping("/editComponent/editMicroController/{id}")
	public String getEditMicroController(MicroController microController, Model model, @PathVariable(name = "id") int id)
	{
		try {
			model.addAttribute("microController", microControllerService.selectById(id));
			return"/editComponent/editMicroController";
		} catch (Exception e) {
			return "error";
		}
	}

	@PostMapping("/editComponent/editMicroController/{id}")
	public String postEditMicroController(@Valid MicroController microController, @PathVariable(name = "id") int id)
	{
		if (microControllerService.editById(id, microController))
		{
			return "redirect:/index";
		} else {
			return "error";
		}
	}
	
	@GetMapping("/editComponent/editMOSFET/{id}")
	public String getEditMOSFET(MOSFET mosfet, Model model, @PathVariable(name = "id") int id)
	{
		try {
			model.addAttribute("mosfet", mosfetService.selectById(id));
			return"/editComponent/editMOSFET";
		} catch (Exception e) {
			return "error";
		}
	}

	@PostMapping("/editComponent/editMOSFET/{id}")
	public String postEditMOSFET(@Valid MOSFET mosfet, @PathVariable(name = "id") int id)
	{
		if (mosfetService.editById(id, mosfet))
		{
			return "redirect:/index";
		} else {
			return "error";
		}
	}

	@GetMapping("/editComponent/editResistor/{id}")
	public String getEditResistor(Resistor resistor, Model model, @PathVariable(name = "id") int id)
	{
		try {
			model.addAttribute("resistor", resistorService.selectById(id));
			return"/editComponent/editResistor";
		} catch (Exception e) {
			return "error";
		}
	}

	@PostMapping("/editComponent/editResistor/{id}")
	public String postEditResistor(@Valid Resistor resistor, @PathVariable(name = "id") int id)
	{
		if (resistorService.editById(id, resistor))
		{
			return "redirect:/index";
		} else {
			return "error";
		}
	}

	@GetMapping("/editComponent/editSensor/{id}")
	public String getEditSensor(Sensor sensor, Model model, @PathVariable(name = "id") int id)
	{
		try {
			model.addAttribute("sensor", sensorService.selectById(id));
			return"/editComponent/editSensor";
		} catch (Exception e) {
			return "error";
		}
	}

	@PostMapping("/editComponent/editSensor/{id}")
	public String postEditSensor(@Valid Sensor sensor, @PathVariable(name = "id") int id)
	{
		if (sensorService.editById(id, sensor))
		{
			return "redirect:/index";
		} else {
			return "error";
		}
	}
	
	@GetMapping("/editComponent/editResistorList")
	public String getEditResistorList(Model model)
	{
		model.addAttribute("res", resistorService.showAllResistor());
		return "/editComponent/editResistorList";
	}
	
	@GetMapping("/editComponent/editCapacitorList")
	public String getEditCapacitorList(Model model)
	{	
		model.addAttribute("cap", capacitorService.showAllCapacitor());
		return "/editComponent/editCapacitorList";
	}
	
	@GetMapping("/editComponent/editInductorList")
	public String getEditInductorList(Model model)
	{
		model.addAttribute("induc", inductorService.showAllInductor()); 
		return "/editComponent/editInductorList";
	}
	
	@GetMapping("/editComponent/editSensorList")
	public String getEditSensorList(Model model)
	{
		model.addAttribute("sen", sensorService.showAllSensor());
		return "/editComponent/editSensorList";
	}
	
	@GetMapping("/editComponent/editBJTList")
	public String getEditBJTList(Model model)
	{
		model.addAttribute("bjt", bjtService.showAllBJT());
		return "/editComponent/editBJTList";
	}
	
	@GetMapping("/editComponent/editMOSFETList")
	public String getEditMOSFETList(Model model)
	{
		model.addAttribute("mosfet", mosfetService.showAllMOSFET());
		return "/editComponent/editMOSFETList";
	}
	
	@GetMapping("/editComponent/editMicroControllerList")
	public String getEditMicroControllerList(Model model)
	{
		model.addAttribute("mc", microControllerService.showAllMicroController());
		return "/editComponent/editMicroControllerList";
	}
	
	@GetMapping("/editComponent/editIntegralCircuitList")
	public String getEditIntegralCircuitList(Model model)
	{
		model.addAttribute("ic", integralCircuitService.showAllIntegralCircuit());
		return "/editComponent/editIntegralCircuitList";
	}
	
	@GetMapping("/admin/adminPanel")
	public String getAdminPanel()
	{
		return "/admin/adminPanel";
	}
	
	@GetMapping("/search")
	public String getSearch() 
	{
		return "/search";
	}
	
	@PostMapping("/search")
	public String postSearch(@RequestParam("searchresult")String searchresult, Model model) {
		 model.addAttribute("induc", inductorService.findInductorBySearchTerm(searchresult)); 
		 model.addAttribute("ic", integralCircuitService.findICBySearchTerm(searchresult));
		 model.addAttribute("mc", microControllerService.findMCBySearchTerm(searchresult));
		 model.addAttribute("mosfet", mosfetService.findMOSFETBySearchTerm(searchresult));
		 model.addAttribute("res", resistorService.findResistorBySearchTerm(searchresult));
		 model.addAttribute("sen", sensorService.findSensorBySearchTerm(searchresult));
		 model.addAttribute("bjt", bjtService.findBJTBySearchTerm(searchresult));
		 model.addAttribute("cap", capacitorService.findCapacitorBySearchTerm(searchresult));
		 return "/showComponents/showAllSearchResults";
	}
}
