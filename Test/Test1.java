package Test;

import java.math.BigDecimal;

import PD.CashDrawer;
import PD.Cashier;
import PD.Item;
import PD.Person;
import PD.Price;
import PD.Register;
import PD.Sale;
import PD.SaleLineItem;
import PD.Session;
import PD.Store;
import PD.TaxCategory;
import PD.UPC;
import UI.POSframe;
import DM.loadData;

public class Test1 {

	public void ac1() {
		// TODO Auto-generated method stub
		Store store = new Store();
		
		loadData.loadStore(store);
		
		System.out.println(store.toString());
	
		
		System.out.println("============");
		System.out.println("Cashiers");
		System.out.println("============");
		for(Cashier cashier: store.getCashiers().values()) {
			System.out.println(cashier.toString());
		}
		System.out.println("============");
		System.out.println("Registers");
		System.out.println("============");
		for(Register register: store.getRegisters().values()) {
			System.out.println(register.toString());
		}
		System.out.println("============");
		System.out.println("Items");
		System.out.println("============");
		for(Item item: store.getItems().values()) {
			System.out.println(item.toString());
		}
		System.out.println("============");
		System.out.println("Sessions");
		System.out.println("============");
		for(Session session: store.getSessions()) {
			System.out.println(session.toString());
			for(Sale sale: session.getSales()) {
				System.out.println(sale.toString());
				for(SaleLineItem sli : sale.getSaleLineItems()) {
					System.out.println(sli.toString()); 
				}
			}
		}
		
		
	
		
//		for (Item item: store.getItems()) {
//		System.out.println(item.toString());
//	}

//		Store store1 = new Store("1", "Israel's Store");
//		
//		Item item1 = new Item("1", "Chips");
//		Item item2 = new Item("2", "Coke");
//		Item item3 = new Item("3", "Pizza");
//		
//		Price price1 = new Price("3.14", "09/21/22");
//		Price price2 = new Price("1.00", "09/21/22");
//		Price price3 = new Price("4.50", "09/21/22");
//		
//		TaxCategory taxCategory1 = new TaxCategory("Food");
//		TaxCategory taxCategory2 = new TaxCategory("Drinks");
//		TaxCategory taxCategory3 = new TaxCategory("Frozen");
//		
//		UPC upc1 = new UPC("0001");
//		UPC upc2 = new UPC("0002");
//		UPC upc3 = new UPC("0003");
//		
//		item1.addPrice(price1);
//		item1.setTaxCategory(taxCategory1);
//		item1.addUPC(upc1);
//		
//		item2.addPrice(price2);
//		item2.setTaxCategory(taxCategory2);
//		item2.addUPC(upc2);
//		
//		item3.addPrice(price3);
//		item3.setTaxCategory(taxCategory3);
//		item3.addUPC(upc3);
//		
//		store1.addItem(item1);
//		store1.addItem(item2);
//		store1.addItem(item3);
//		
//		
//		
//		Person person1 = new Person("Israel", "Calle Las Trancas #110", "Aguascalientes", "Ags", "20361", "449 433 7018", "1234");
//		Person person2 = new Person("Paola", "Fracc La No se #111", "Aguascalientes", "Ags", "18920", "449 111 2138", "4321");
//		Person person3 = new Person("Frida", "Fracc No me Acuerdo #116", "Aguascalientes", "Ags", "88921", "449 999 999", "2381");
//		
//		Cashier cashier1 = new Cashier("1", person1, "Password1");
//		Cashier cashier2 = new Cashier("2", person2, "Password2");
//		Cashier cashier3 = new Cashier("3", person3, "Password3");
//		
//		store1.addCashier(cashier1);
//		store1.addCashier(cashier2);
//		store1.addCashier(cashier3);
//		
//		CashDrawer cashDrawer1 = new CashDrawer(BigDecimal.valueOf(50.00) ,1);
//		CashDrawer cashDrawer2 = new CashDrawer(BigDecimal.valueOf(30.00), 2);
//		
//		Register register1 = new Register("1");
//		Register register2 = new Register("2");
//		
//		store1.addRegister(register1);
//		store1.addRegister(register2);
//		
//		Session session1 = new Session(cashier1, register1);
//		Sale sale1 = new Sale("false");
//		SaleLineItem sli1 = new SaleLineItem(sale1, item1, "2");
//		SaleLineItem sli2 = new SaleLineItem(sale1, item2, "4");
//		session1.addSale(sale1);
//		
//		
//		System.out.println(store1.toString());
//		System.out.println("--------------------");
//		System.out.println("      Items         ");
//		System.out.println("--------------------");	
//		System.out.println(upc1.toString() + " " + item1.toString() + " " + price1.toString() + " " + taxCategory1.toString());
//		System.out.println(upc2.toString() + " " + item2.toString() + " " + price2.toString() + " " + taxCategory2.toString());
//		System.out.println(upc3.toString() + " " + item3.toString() + " " + price3.toString() + " " + taxCategory3.toString());
//		System.out.println("--------------------");
//		System.out.println("      Cashiers      ");
//		System.out.println("--------------------");
//		System.out.println(cashier1.toString());
//		System.out.println(cashier2.toString());
//		System.out.println(cashier3.toString());
//		System.out.println("--------------------");
//		System.out.println("      Registers     ");
//		System.out.println("--------------------");
//		System.out.println(register1.toString());
//		System.out.println(register2.toString());
//		System.out.println("--------------------");
//		System.out.println("      Sessions      ");
//		System.out.println("--------------------");
//		System.out.println(session1.toString());
	
		
	}
	
	public void acScreens() {
		Store store = new Store();
		loadData.loadStore(store);
		POSframe frame = new POSframe(store);
		frame.setVisible(true);
	}

}
