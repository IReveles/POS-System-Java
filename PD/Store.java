package PD;
import java.util.*;

public class Store {

	private String number;
	private String name;
	TreeMap<String, TaxCategory> taxCategories;
	ArrayList<Session> sessions;
	TreeMap<String, Cashier> cashiers;
	TreeMap<String, Register> registers;
	TreeMap<String, Item> items;
	TreeMap<String, UPC> upcs;

	public Store() {
		// TODO - implement Store.Store
		this.name = "";
		this.number = "0";
		taxCategories = new TreeMap<String, TaxCategory>();
		sessions = new ArrayList<Session>();
		cashiers = new TreeMap<String, Cashier>();
		registers = new TreeMap<String, Register>();
		items = new TreeMap<String, Item>();
		upcs = new TreeMap<String, UPC>();
	}

	/**
	 * 
	 * @param number
	 * @param name
	 */
	public Store(String number, String name) {
		// TODO - implement Store.Store
		this();
		this.name = name;
		this.number = number;
	}
	

	/**
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		// TODO - implement Store.addItem
		items.put(item.getNumber(), item);
	}

	/**
	 * 
	 * @param item
	 */
	public void removeItem(Item item) {
		// TODO - implement Store.removeItem
		items.remove(item.getNumber());
	}

	/**
	 * 
	 * @param upc
	 */
	public void addUPC(UPC upc) {
		// TODO - implement Store.addUPC
		upcs.put(upc.getUPC(), upc);
	}

	/**
	 * 
	 * @param upc
	 */
	public void removeUPC(UPC upc) {
		// TODO - implement Store.removeUPC
		upcs.remove(upc.getUPC());
	}

	/**
	 * 
	 * @param register
	 */
	public void addRegister(Register register) {
		// TODO - implement Store.addRegister
		registers.put(register.getNumber(), register);
	}

	/**
	 * 
	 * @param register
	 */
	public void removeRegister(Register register) {
		// TODO - implement Store.removeRegister
		registers.remove(register.getNumber());
	}

	/**
	 * 
	 * @param cashier
	 */
	public void addCashier(Cashier cashier) {
		// TODO - implement Store.addCashier
		cashiers.put(cashier.getNumber(), cashier);
	}

	/**
	 * 
	 * @param cashier
	 */
	public void removeCashier(Cashier cashier) {
		// TODO - implement Store.removeCashier
		cashiers.remove(cashier.getNumber());
	}

	/**
	 * 
	 * @param taxCategory
	 */
	public void addTaxCategory(TaxCategory taxCategory) {
		// TODO - implement Store.addTaxCategory
		taxCategories.put(taxCategory.getCategory(), taxCategory);
	}

	/**
	 * 
	 * @param taxCategory
	 */
	public void removeTaxCategory(TaxCategory taxCategory) {
		// TODO - implement Store.removeTaxCategory
		taxCategories.remove(taxCategory.getCategory());
	}

	/**
	 * 
	 * @param session
	 */
	public void addSession(Session session) {
		// TODO - implement Store.addSession
		sessions.add(session);
	}

	/**
	 * 
	 * @param session
	 */
	public void removeSession(Session session) {
		// TODO - implement Store.removeSession
		sessions.remove(session);
	}

	/**
	 * 
	 * @param number
	 */
	public Register findRegisterByNumber(String number) {
		// TODO - implement Store.findRegisterByNumber
		Register register;
		register = getRegisters().get(number);
		return register;
	}

	/**
	 * 
	 * @param upc
	 */
	public Item findItemForUPC(String upc) {
		// TODO - implement Store.findItemForUPC
		Item item;
		if(getUpcs().get(upc) == null) {
			return null;
		}
		item = getUpcs().get(upc).getItem();
		return item;
	}

	/**
	 * 
	 * @param number
	 */
	public Item findItemForNumber(String number) {
		// TODO - implement Store.findItemForNumber
		Item item;
		item = getItems().get(number);
		return item;
	}

	/**
	 * 
	 * @param number
	 */
	public Cashier findCashierForNumber(String number) {
		// TODO - implement Store.findCashierForNumber
		Cashier cashier;
		cashier = getCashiers().get(number);
		return cashier;
	}

	/**
	 * 
	 * @param category
	 */
	public TaxCategory findTaxCategoryByName(String category) {
		// TODO - implement Store.findTaxCategoryByName
		TaxCategory taxCategory;
		taxCategory = getTaxCategories().get(category);
		return taxCategory;
	}

	public String toString() {
		// TODO - implement Store.toString
		return "Store: " + this.name + " Number: " + this.number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeMap<String, TaxCategory> getTaxCategories() {
		return taxCategories;
	}

	public void setTaxCategories(TreeMap<String, TaxCategory> taxCategories) {
		this.taxCategories = taxCategories;
	}

	public ArrayList<Session> getSessions() {
		return sessions;
	}

	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}

	public TreeMap<String, Cashier> getCashiers() {
		return cashiers;
	}

	public void setCashiers(TreeMap<String, Cashier> cashiers) {
		this.cashiers = cashiers;
	}

	public TreeMap<String, Register> getRegisters() {
		return registers;
	}

	public void setRegisters(TreeMap<String, Register> registers) {
		this.registers = registers;
	}

	public TreeMap<String, Item> getItems() {
		return items;
	}

	public void setItems(TreeMap<String, Item> items) {
		this.items = items;
	}

	public TreeMap<String, UPC> getUpcs() {
		return upcs;
	}

	public void setUpcs(TreeMap<String, UPC> upcs) {
		this.upcs = upcs;
	}

	public boolean isTaxCategoryUsed(TaxCategory selectedValue) {
		// TODO Auto-generated method stub
		boolean used = false;
		for(Item item: items.values()) {
			if(item.getTaxCategory().equals(selectedValue)) {
				used = true;
			}
		}
		return used;
	}

}