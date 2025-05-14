package PD;

import java.math.BigDecimal;

public class Check extends AuthorizedPayment {

	private String routingNumber;
	private String accountNumber;
	private String checkNumber;

	public Check() {
		// TODO - implement Check.Check
		
	}

	/**
	 * 
	 * @param amount
	 * @param accountNumber
	 * @param checkNumber
	 */
	public Check(BigDecimal amount, BigDecimal amtTendered, String accountNumber, String checkNumber) {
		// TODO - implement Check.Check
		setAmount(amount);
		setAmtTendered(amtTendered);
		this.accountNumber = accountNumber;
		this.checkNumber = checkNumber;
	}

	public Boolean isAuthorized() {
		// TODO - implement Check.isAuthorized
		return true;
	}

	public String toString() {
		// TODO - implement Check.toString
		throw new UnsupportedOperationException();
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

}