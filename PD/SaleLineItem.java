package PD;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SaleLineItem {

	private int quantity;
	Sale sale;
	Item item;

	public SaleLineItem() {
		// TODO - implement SaleLineItem.SaleLineItem
		this.quantity = 0;
	}

	/**
	 * 
	 * @param sale
	 * @param item
	 * @param quantity
	 */
	public SaleLineItem(Sale sale, Item item, String quantity) {
		// TODO - implement SaleLineItem.SaleLineItem
		this();
		this.sale = sale;
		this.item = item;
		this.quantity = Integer.parseInt(quantity);
		//sale.addSaleLineItem(this);
		item.addSaleLineItem(this);
	}

	public BigDecimal calcSubTotal() {
		// TODO - implement SaleLineItem.calcSubTotal
		BigDecimal subTotal = new BigDecimal("0");
		
		subTotal = item.calcAmountForDateQty(sale.getDateTime(), quantity);
		
		return subTotal;
		
	}

	public BigDecimal calcTax() {
		// TODO - implement SaleLineItem.calcTax
		BigDecimal taxRate = new BigDecimal("0");
		BigDecimal subTotal = this.calcSubTotal();
		
		taxRate = item.getTaxRateForDate(sale.getDateTime());
		
		return taxRate.multiply(subTotal);
	}

	public String toString() {
		// TODO - implement SaleLineItem.toString
		return " " + getItem().getNumber() + " " + getItem().getDescription() + " " + quantity + " "  + getItem().getPriceForDate(sale.getDateTime()) + " " + this.calcSubTotal().toString();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}