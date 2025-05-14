package PD;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;

public class Session {

	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	Cashier cashier;
	Register register;
	ArrayList<Sale> sales;

	public Session() {
		// TODO - implement Session.Session
		this.startDateTime = null;
		sales = new ArrayList<Sale>();
		
	}

	/**
	 * 
	 * @param cashier
	 * @param register
	 */
	public Session(Cashier cashier, Register register) {
		// TODO - implement Session.Session
		this();
		
		this.setCashier(cashier);
		this.setRegister(register);
	}

	/**
	 * 
	 * @param sale
	 */
	public void addSale(Sale sale) {
		// TODO - implement Session.addSale
		sales.add(sale);
	}

	/**
	 * 
	 * @param sale
	 */
	public void removeSale(Sale sale) {
		// TODO - implement Session.removeSale
		sales.remove(sale);
	}

	/**
	 * 
	 * @param cash
	 */
	public BigDecimal calcCashCountDiff(BigDecimal cash) {
		// TODO - implement Session.calcCashCountDiff
		return cash.subtract(register.getCashDrawer().getCashAmount());
	}

	public BigDecimal calcTotal() {
		// TODO - implement Session.calcTotal
		BigDecimal total = new BigDecimal(0);
		
		for(Sale sale: this.getSales()) {
			total = total.add(sale.calcTotal());
		}
		return total.setScale(2, RoundingMode.HALF_UP);
	}

	public String toString() {
		// TODO - implement Session.toString
		String string;
		string = "Session:  Cashier: " + this.cashier + "  Register: "  + this.register + " Total: " + this.calcTotal().toString()  + " Date: " + this.startDateTime + "\n\n";
		 
		 return string;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Cashier getCashier() {
		return cashier;
	}

	public void setCashier(Cashier cashier) {
		if(this.cashier != null) {
			this.cashier.removeSession(this);
		}
		this.cashier = cashier;
		cashier.addSession(this);
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		if(this.register != null) {
			this.register.removeSession(this);
		}
		this.register = register;
		register.addSession(this);
	}

	public ArrayList<Sale> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Sale> sales) {
		this.sales = sales;
	}

}