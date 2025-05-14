package PD;
import java.math.BigDecimal;

public class Cash extends Payment {

	public Cash() {
		// TODO - implement Cash.Cash
	}

	/**
	 * 
	 * @param amount
	 * @param amtTendered
	 */
	public Cash(BigDecimal amount, String amtTendered) {
		// TODO - implement Cash.Cash
		setAmount(amount);
		setAmtTendered(new BigDecimal(amtTendered));
	}

	public Boolean countAsCash() {
		// TODO - implement Cash.countAsCash
		return true;
	}

	public String toString() {
		// TODO - implement Cash.toString
		throw new UnsupportedOperationException();
	}

}