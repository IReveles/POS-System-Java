package PD;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Item {

	private String number;
	private String description;
	private TaxCategory taxCategory;
	TreeMap<String, UPC> uPCs;
	ArrayList<SaleLineItem> saleLineItems;
	TreeSet<Price> prices;

	public Item() {
		// TODO - implement Item.Item
		this.number = "0";
		this.description = "None";
		uPCs = new TreeMap<String, UPC>();
		prices = new TreeSet<Price>();
		saleLineItems = new ArrayList<SaleLineItem>();
	}

	/**
	 * 
	 * @param number
	 * @param description
	 */
	public Item(String number, String description, String taxCategory, Store store) {
		// TODO - implement Item.Item
		this();
		this.number = number;
		this.description = description;
		setTaxCategory(store.findTaxCategoryByName(taxCategory));
	}
	
	/**
	 * 
	 * @param price
	 */
	public void addPrice(Price price) {
		// TODO - implement Item.addPrice
		if(price != null)
		prices.add(price);
	}

	/**
	 * 
	 * @param price
	 */
	public void removePrice(Price price) {
		// TODO - implement Item.removePrice
		prices.remove(price);
	}

	/**
	 * 
	 * @param upc
	 */
	public void addUPC(UPC upc) {
		// TODO - implement Item.addUPC
		uPCs.put(upc.getUPC(), upc);
	}

	/**
	 * 
	 * @param upc
	 */
	public void removeUPC(UPC upc) {
		// TODO - implement Item.removeUPC
		uPCs.remove(upc.getUPC());
	}

	/**
	 * 
	 * @param date
	 */
	public Price getPriceForDate(LocalDate date) {
		// TODO - implement Item.getPriceForDate
		Price price = new Price();
		for(Price priceDate : prices) {
			if(priceDate.getEffectiveDate().isBefore(date)) {
				price = priceDate;
			}
		}
		return price;
	}

	/**
	 * 
	 * @param date
	 */
	public BigDecimal getTaxRateForDate(LocalDate date) {
		// TODO - implement Item.getTaxRateForDate
		BigDecimal taxRateTotal = new BigDecimal("0");
		taxRateTotal = taxCategory.getTaxRateForDate(date);
		return taxRateTotal;
	}

	/**
	 * 
	 * @param date
	 * @param quantity
	 */
	public BigDecimal calcAmountForDateQty(LocalDate date, int quantity) {
		// TODO - implement Item.calcAmountForDateQty
		BigDecimal amount;
		BigDecimal itemPrice = new BigDecimal("0");
		BigDecimal qty = new BigDecimal(quantity);
		
		for(Price price : prices) {
			if(price.isEffective(date)) {
				itemPrice = price.getPrice();
			}
		}
		amount = itemPrice.multiply(qty);
		return amount;
	}

	/**
	 * 
	 * @param saleLineItem
	 */
	public void addSaleLineItem(SaleLineItem saleLineItem) {
		// TODO - implement Item.addSaleLineItem
		if(saleLineItem != null) {
			saleLineItems.add(saleLineItem);
		}
	}

	/**
	 * 
	 * @param saleLineItem
	 */
	public void removeSaleLineItem(SaleLineItem saleLineItem) {
		// TODO - implement Item.removeSaleLineItem
		if(saleLineItem != null) {
			saleLineItems.remove(saleLineItem);
		}
	}

	public String toString() {
		// TODO - implement Item.toString
		String string;
		string = this.number + " " + this.description + " Price: "  + this.getPriceForDate(LocalDate.now()) + " TaxRate: " + this.getTaxCategory().getTaxRateForDate(LocalDate.now())+ " " + this.getuPCs().firstKey();
		
		
		return string;
	}

	public String getNumber() {
		// TODO Auto-generated method stub
		return this.number;
	}

	public TaxCategory getTaxCategory() {
		return taxCategory;
	}

	public void setTaxCategory(TaxCategory taxCategory) {
		this.taxCategory = taxCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TreeMap<String, UPC> getuPCs() {
		return uPCs;
	}

	public void setuPCs(TreeMap<String, UPC> uPCs) {
		this.uPCs = uPCs;
	}

	public TreeSet<Price> getPrices() {
		return prices;
	}

	public void setPrices(TreeSet<Price> prices) {
		this.prices = prices;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public ArrayList<SaleLineItem> getSaleLineItems() {
		return saleLineItems;
	}

	public void setSaleLineItems(ArrayList<SaleLineItem> saleLineItems) {
		this.saleLineItems = saleLineItems;
	}

}