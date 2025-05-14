package PD;
import java.math.BigDecimal;

public class CashDrawer {

	private BigDecimal cashAmount;
	private int position;

	public CashDrawer() {
		// TODO - implement CashDrawer.CashDrawer
		this.cashAmount = null;
		this.position = 0;
	}
	
	public CashDrawer(BigDecimal cashAmount, int position){
		this();
		this.cashAmount = cashAmount;
		this.position = position;
	}

	/**
	 * 
	 * @param cash
	 */
	public void removeCash(BigDecimal cash) {
		// TODO - implement CashDrawer.removeCash
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cash
	 */
	public void addCash(BigDecimal cash) {
		// TODO - implement CashDrawer.addCash
		this.cashAmount = this.cashAmount.add(cash);
	}

	public String toString() {
		// TODO - implement CashDrawer.toString
		throw new UnsupportedOperationException();
	}

	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}