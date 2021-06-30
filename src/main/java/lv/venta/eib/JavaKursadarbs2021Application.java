package lv.venta.eib;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import lv.venta.eib.enums.capType;
import lv.venta.eib.enums.caseType;
import lv.venta.eib.enums.sensorType;
import lv.venta.eib.enums.valUnits;
import lv.venta.eib.model.BJT;
import lv.venta.eib.model.Capacitor;
import lv.venta.eib.model.Inductor;
import lv.venta.eib.model.IntegralCircuit;
import lv.venta.eib.model.MOSFET;
import lv.venta.eib.model.MicroController;
import lv.venta.eib.model.Resistor;
import lv.venta.eib.model.Sensor;
import lv.venta.eib.model.User;
import lv.venta.eib.model.UserRole;
import lv.venta.eib.repo.IBJTRepo;
import lv.venta.eib.repo.ICapacitorRepo;
import lv.venta.eib.repo.IComponentRepo;
import lv.venta.eib.repo.IInductorRepo;
import lv.venta.eib.repo.IIntegralCircuitRepo;
import lv.venta.eib.repo.IMOSFETRepo;
import lv.venta.eib.repo.IMicroControllerRepo;
import lv.venta.eib.repo.IResistorRepo;
import lv.venta.eib.repo.ISensorRepo;
import lv.venta.eib.repo.IUserRepo;
import lv.venta.eib.repo.IUserRoleRepo;



@SpringBootApplication
public class JavaKursadarbs2021Application {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(JavaKursadarbs2021Application.class, args);
	}
	
	@Bean
	public CommandLineRunner addTestData(IComponentRepo comRepo, IInductorRepo induRepo, IBJTRepo bjtRepo, ICapacitorRepo capacitorRepo, IIntegralCircuitRepo integralCircuitRepo,
			IMicroControllerRepo microControllerRepo, IMOSFETRepo mosfetRepo, IResistorRepo resistorRepo, ISensorRepo sensorRepo, IUserRepo userRepo, IUserRoleRepo userRoleRepo)
	{
		
		return(args) -> {

			Inductor i1 = new Inductor("RS614-2-02", "Individuāli", "http://www.farnell.com/datasheets/18590.pdf", 20, caseType.SMD, "GV2B", "E4", 20, 30.0f, valUnits.MICRO, 2.0f, 0.05f);
			Inductor i2 = new Inductor("SMV40", "Individuāli", "https://www.dem-uk.com/roxburgh/Data/Product_Downloads/roxburgh-smv10-differential-mode-choke-data.pdf", 1, caseType.SMD, "Nezināms", "E4", 10, 210.0f, valUnits.MICRO, 4.0f, 0.1f);
			Inductor i3 = new Inductor("C-3X", "Individuāli", "http://www.farnell.com/datasheets/2015892.pdf", 35, caseType.SMD, "Nezināms", "E4", 1, 10.0f, valUnits.NONE, 0.05f, 500.0f);
			induRepo.save(i1);
			induRepo.save(i2);
			induRepo.save(i3);
			
			BJT b1 = new BJT("2N5551BU", "Jauns pievedums", "http://www.farnell.com/datasheets/79208.pdf", 0, caseType.THT, "TO-92", "E4", 100, 160, 1, "NPN", 200);
			BJT b2 = new BJT("2SC5706-E", "Apšaubāmas izcelsmes", "https://www.onsemi.com/pub/Collateral/EN6912-D.PDF", 0, caseType.THT, "TO-251", "E4", 15, 50, 5, "NPN", 200);
			BJT b3 = new BJT("2SA2222SG", "Virtenēs pa 20", "http://www.farnell.com/datasheets/2255217.pdf", 0, caseType.THT, "SC-67", "E4", 40, 50, 10, "PNP", 150);
			bjtRepo.save(b1);
			bjtRepo.save(b2);
			bjtRepo.save(b3);
			
			Capacitor c1 = new Capacitor("GRM1885C1H472JA01D", "SMD komponenšu mapē", "https://4donline.ihs.com/images/VipMasterIC/IC/MURE/MURE-S-A0010867891/MURE-S-A0010867892-1.pdf?hkey=6D3A4C79FDBF58556ACFDE234799DDF0", 5, caseType.SMD, "0603", "E4", 80, 4700, valUnits.PICO, 125, capType.CERAMIC, 50);
			Capacitor c2 = new Capacitor("T350E106M016AT", "Dārgi, lieki neizmantot!", "https://api.kemet.com/component-edge/download/specsheet/T350E106M016AT.pdf", 20, caseType.THT, "2.54mm Radial", "E4", 10, 10, valUnits.MICRO, 125, capType.TANTALUM, 16);
			Capacitor c3 = new Capacitor("UKW1H100MDD1TD", "Stāvējuši skapī 20 gadus", "http://www.farnell.com/datasheets/2576798.pdf", 20, caseType.THT, "2mm Radial Leaded", "E4", 200, 10, valUnits.MICRO, 85, capType.ELECTROLYTIC, 50);
			capacitorRepo.save(c1);
			capacitorRepo.save(c2);
			capacitorRepo.save(c3);
				
			IntegralCircuit ic1 = new IntegralCircuit("LM358ADR2G", "Operacionālais pastiprinātājs", "http://www.farnell.com/datasheets/2236829.pdf", 0, caseType.SMD, "SOIC-8", "E4", 30, 3);
			IntegralCircuit ic2 = new IntegralCircuit("TL331VSN4T3G", "Komparators", "http://www.farnell.com/datasheets/2571984.pdf", 0, caseType.SMD, "TSOP", "E4", 5, 2);
			IntegralCircuit ic3 = new IntegralCircuit("HA9P2556-9Z", "Signālu reizinātājs/dalītājs", "http://www.farnell.com/datasheets/1928598.pdf", 0, caseType.SMD, "SOIC-16", "E4", 10, 5);
			integralCircuitRepo.save(ic1);
			integralCircuitRepo.save(ic2);
			integralCircuitRepo.save(ic3);
			
			MicroController mc1 = new MicroController("ATmega328PB-AN", "20 MHz, I2C, SPI, UART", "http://www.farnell.com/datasheets/2337828.pdf", 0, caseType.SMD, "TQFP", "E4", 10, 5);
			MicroController mc2 = new MicroController("ATmega1281-16MU", "16 MHz, I2C, SPI, UART", "https://4donline.ihs.com/images/VipMasterIC/IC/MCHP/MCHP-S-A0010212075/MCHP-S-A0010410632-1.pdf?hkey=6D3A4C79FDBF58556ACFDE234799DDF0", 0, caseType.SMD, "QFN", "E4", 2, 5);
			MicroController mc3 = new MicroController("CY8C4247AZI-M485", "48 MHz, ARM Cortex-M0", "http://www.farnell.com/datasheets/2675612.pdf", 0, caseType.SMD, "TQFP", "E4", 5, 5);
			microControllerRepo.save(mc1);			
			microControllerRepo.save(mc2);	
			microControllerRepo.save(mc3);	
			
			MOSFET mosfet1 = new MOSFET("STP310N10F7", "Jaudas tranzistors", "http://www.farnell.com/datasheets/2124343.pdf", 0, caseType.THT, "TO-220", "E4", 50, 100, 180.0f, "N-Channel", 3.5f);
			MOSFET mosfet2 = new MOSFET("VP2106N3-G", "Jaudas tranzistors", "http://www.farnell.com/datasheets/2337825.pdf", 0, caseType.THT, "TO-92", "E4", 20, 60, 0.25f, "P-Channel", 3.5f);
			MOSFET mosfet3 = new MOSFET("BSS138NH6327XTSA2", "Jaudas tranzistors", "https://4donline.ihs.com/images/VipMasterIC/IC/INFN/INFNS15406/INFNS15406-1.pdf?hkey=6D3A4C79FDBF58556ACFDE234799DDF0", 0, caseType.SMD, "SOT-23", "E4", 25, 60, 0.23f, "N-Channel", 1.0f);
			mosfetRepo.save(mosfet1);
			mosfetRepo.save(mosfet2);
			mosfetRepo.save(mosfet3);
			
			Resistor r1 = new Resistor("LR0204F100K","Virtenēs pa 100 gabalā", "http://www.farnell.com/datasheets/1723855.pdf", 1, caseType.THT, "0204", "E4", 100, 100, valUnits.KILO);
			Resistor r2 = new Resistor("MRS25000C2702FCT00", "Individuāli", "http://www.farnell.com/datasheets/2046132.pdf", 1, caseType.THT, "0207", "E4", 50, 27, valUnits.KILO);
			Resistor r3 = new Resistor("CRGP2010F10K", "Lentē pa 10 gabalā", "https://4donline.ihs.com/images/VipMasterIC/IC/TYEL/TYEL-S-A0005460475/TYEL-S-A0005460475-1.pdf?hkey=52A5661711E402568146F3353EA87419", 1, caseType.SMD, "2010", "E4", 200, 10, valUnits.KILO);
			resistorRepo.save(r1);
			resistorRepo.save(r2);
			resistorRepo.save(r3);
			
			Sensor sen1 = new Sensor("G-MRCO-028", "Magnētiskā lauka sensors", "http://www.farnell.com/datasheets/2917180.pdf", 1, caseType.THT, "SOT-4", "E4", 20, 5.0f, sensorType.MAGNETIC);
			Sensor sen2 = new Sensor("HPP801A031", "Mitruma sensors", "http://www.farnell.com/datasheets/2305691.pdf", 2, caseType.THT, "5mm Radial", "E4", 5, 5.0f, sensorType.HUMIDITY);
			Sensor sen3 = new Sensor("MS583730BA01-50", "Spiediena sensors", "http://www.farnell.com/datasheets/2189704.pdf", 1, caseType.SMD, "Nezināms", "E4", 2, 3.0f, sensorType.PRESSURE);
			sensorRepo.save(sen1);
			sensorRepo.save(sen2);
			sensorRepo.save(sen3);
			
			UserRole userRole1 = new UserRole("ADMIN");
			UserRole userRole2 = new UserRole("USER");
			userRoleRepo.save(userRole1);
			userRoleRepo.save(userRole2);
			
			
			User user = new User("Emīls", "Vēveris", "test@venta.lv", "user", passwordEncoder.encode("test"));
			user.addUserRole(userRole1);
			user.addUserRole(userRole2);
			System.out.println("Added new user test");
			
			userRepo.save(user);
			userRole1.addUser(user);
			userRole2.addUser(user);
			userRoleRepo.save(userRole1);
			userRoleRepo.save(userRole2);
		};
		
	}

}
