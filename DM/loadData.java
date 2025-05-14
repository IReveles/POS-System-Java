package DM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import PD.Cash;
import PD.Cashier;
import PD.Check;
import PD.Credit;
import PD.Item;
import PD.Payment;
import PD.Person;
import PD.Price;
import PD.PromoPrice;
import PD.Register;
import PD.Sale;
import PD.SaleLineItem;
import PD.Session;
import PD.Store;
import PD.TaxCategory;
import PD.TaxRate;
import PD.UPC;

public class loadData {

	public static void loadStore(Store store) {
		
		TaxCategory taxCategory = new TaxCategory();
		TaxRate taxRate = new TaxRate();
		Person person = new Person();
		Cashier cashier = new Cashier();
		Item item = new Item();
		UPC upc = new UPC();
		Price price = new Price();
		Register register = new Register();
		Session session = new Session();
		Sale sale = new Sale();
		SaleLineItem saleLineItem = new SaleLineItem();
		PromoPrice promoPrice = new PromoPrice();
		Credit credit = new Credit();
		Cash cash = new Cash();
		Check check = new Check();
		Payment payment;
		
		
		
	String fileName = "StoreData_v2022.csv";

	try {
	FileReader fileReader = 
            new FileReader(fileName);

	BufferedReader bufferedReader = 
            new BufferedReader(fileReader);
	
	String line = null;
	
	while((line = bufferedReader.readLine()) != null) 
    {
     
		
		String result[] = line.split(",");
		
		if(result[0].contentEquals("Store")) {
			
		 store .setName(result[1]);
		 store.setNumber("1");
			
		}else if(result[0].contentEquals("TaxCategory")) {
			
			taxCategory = new TaxCategory(result[1], result[3]);
			taxRate = new TaxRate(taxCategory.getEffectiveDate(), new BigDecimal(result[2]));
			taxCategory.addTaxRate(taxRate);
			store.addTaxCategory(taxCategory);
		
		}else if(result[0].contentEquals("Cashier")) {
			person = new Person(result[2], result[4], result[5], result[6], result[7], result[8], result[3]);
			cashier = new Cashier(result[1], person, result[9]);
			store.addCashier(cashier);
		}else if(result[0].contentEquals("Item")) {
			item = new Item(result[1], result[3], result[4], store);
			upc = new UPC(result[2]);
			price = new Price(result[5], result[6]);
			
			item.addUPC(upc);
			upc.setItem(item);
			item.addPrice(price);
			if(result.length > 7) {
				promoPrice =  new PromoPrice(result[7], result[8], result[9]);
				item.addPrice(promoPrice);
			}
			store.addItem(item);
			store.addUPC(upc);
		}else if(result[0].contentEquals("Register")) {
			register = new Register(result[1]);
			store.addRegister(register);
		}else if(result[0].contentEquals("Session")) {
			session = new Session(store.findCashierForNumber(result[1]), store.findRegisterByNumber(result[2]));
			store.addSession(session);
		}else if(result[0].contentEquals("Sale")) {
			sale = new Sale(result[1]);
			session.addSale(sale);
		}else if(result[0].contentEquals("SaleLineItem") ) {
			saleLineItem =  new SaleLineItem(sale, store.findItemForNumber(result[1]), result[2]);
			sale.addSaleLineItem(saleLineItem);
		}else if(result[0].contentEquals("Payment")) {
			
			
			
			if(result[1].contentEquals("Cash")) {
				cash = new Cash(new BigDecimal(result[2]), result[3]);
				sale.addPayment(cash);
			}else if(result[1].contentEquals("Credit")) {
				credit = new Credit(new BigDecimal(result[2]), new BigDecimal(result[3]), result[4], result[5], result[6]);
				sale.addPayment(credit);
			}else if(result[1].contentEquals("Check")) {
				check = new Check(new BigDecimal(result[2]), new BigDecimal(result[3]), result[4], result[5]);
				sale.addPayment(check);
			}
		}
		
		
    }    
  // Always close files.
  bufferedReader.close();            

	
		}
	catch(FileNotFoundException ex) {
		System.out.println( "Unable to open file '" +  fileName + "'");
		}
	catch(IOException ex) 
	 {
	    System.out.println (  "Error reading file '" + fileName + "'");   	
	  }

	}

}
