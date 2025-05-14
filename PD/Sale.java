package PD;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Sale {

	private LocalDate dateTime;
	private Boolean taxFree;
	ArrayList<Payment> payments;
	ArrayList<SaleLineItem> saleLineItems;

	public Sale() {
		// TODO - implement Sale.Sale
		this.dateTime = LocalDate.now();
		this.taxFree = false;
		payments = new ArrayList<Payment>();
		saleLineItems = new ArrayList<SaleLineItem>();
	}

	/**
	 * 
	 * @param taxFree
	 */
	public Sale(String taxFree) {
		// TODO - implement Sale.Sale
		this();
		
		if(taxFree.equals("Y")) {
			this.taxFree = true;
		}else {
			this.taxFree = false;
		}
	}

	/**
	 * 
	 * @param payment
	 */
	public void addPayment(Payment payment) {
		// TODO - implement Sale.addPayment
		getPayments().add(payment);
	}

	/**
	 * 
	 * @param payment
	 */
	public void removePayment(Payment payment) {
		// TODO - implement Sale.removePayment
		payments.remove(payment);
	}

	/**
	 * 
	 * @param sli
	 */
	public void addSaleLineItem(SaleLineItem sli) {
		// TODO - implement Sale.addSaleLineItem
		saleLineItems.add(sli);
	}

	/**
	 * 
	 * @param sli
	 */
	public void removeSaleLineItem(SaleLineItem sli) {
		// TODO - implement Sale.removeSaleLineItem
		saleLineItems.remove(sli);
	}

	public BigDecimal calcTotal() {
		// TODO - implement Sale.calcTotal
		BigDecimal total = new BigDecimal("0");
		for(SaleLineItem sli : saleLineItems) {
			total = total.add(sli.calcSubTotal());
			if(this.taxFree == false) {
				total = total.add(sli.calcTax());
			}
		}
		return total.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal calcSubTotal() {
		// TODO - implement Sale.calcSubTotal
		BigDecimal total = new BigDecimal("0");
		for(SaleLineItem sli : saleLineItems) {
			total = total.add(sli.calcSubTotal());
		}
		return total.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal calcTax() {
		// TODO - implement Sale.calcTax
		BigDecimal total = new BigDecimal("0");
		if(this.taxFree == false) {
			for(SaleLineItem sli : saleLineItems) {
				total = total.add(sli.calcTax());
			}
		}
		return total.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getTotalPayments() {
		// TODO - implement Sale.getTotalPayments
		BigDecimal temp = new BigDecimal("0");
		
		for(Payment payment: this.getPayments()) {
			temp = temp.add(payment.getAmount());
		}
		
		return temp.setScale(2, RoundingMode.HALF_UP);
	}

	public Boolean isPaymentEnough() {
		// TODO - implement Sale.isPaymentEnough
		if(this.calcAmtTendered().compareTo(this.calcTotal()) < 0) {
			return false;
		}else {
			return true;
		}
	}

	/**
	 * 
	 * @param amtTendered
	 */
	public BigDecimal calcAmountForPayment(BigDecimal amtTendered) {
		// TODO - implement Sale.calcAmountForPayment
//		BigDecimal temp = new BigDecimal("0");
//		
//		for(Payment payment: this.getPayments()) {
//			temp = temp.add(payment.getAmtTendered());
//		}
//		temp = temp.add(amtTendered);
		
//		return temp.setScale(2, RoundingMode.HALF_UP);
		return this.calcTotal();
				}

	public BigDecimal calcChange() {
		// TODO - implement Sale.calcChange
		return this.calcAmtTendered().subtract(this.calcTotal()).setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal calcAmtTendered() {
		// TODO - implement Sale.calcAmtTendered
		BigDecimal temp = new BigDecimal("0");
		
		for(Payment payment: this.getPayments()) {
			temp = temp.add(payment.getAmtTendered());
		}
		
		return temp.setScale(2, RoundingMode.HALF_UP);
	}

	public String toString() {
		// TODO - implement Sale.toString
		String string;
		string = "Sale: " + "SubTotal = " + this.calcSubTotal() + " Tax: " + this.calcTax() + " Total: " + this.calcTotal() + " Payment: " + this.calcAmtTendered().toString() + " Change: " + this.calcChange() + "\n";
		return string;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	public Boolean getTaxFree() {
		return taxFree;
	}

	public void setTaxFree(Boolean taxFree) {
		this.taxFree = taxFree;
	}

	public ArrayList<Payment> getPayments() {
		return payments;
	}

	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}

	public ArrayList<SaleLineItem> getSaleLineItems() {
		return saleLineItems;
	}

	public void setSaleLineItems(ArrayList<SaleLineItem> saleLineItems) {
		this.saleLineItems = saleLineItems;
	}

}