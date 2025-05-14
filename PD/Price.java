package PD;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Price implements Comparable<Price>{

	TreeSet<Item> item;
	private BigDecimal price;
	private LocalDate effectiveDate;

	public Price() {
		// TODO - implement Price.Price
		this.price = new BigDecimal(0);
		this.effectiveDate = null;
		item = new TreeSet<Item>();
	}

	/**
	 * 
	 * @param price
	 * @param effectiveDate
	 */
	public Price(String price, String effectiveDate) {
		// TODO - implement Price.Price
		this();
		this.price = new BigDecimal(price);
		this.effectiveDate = LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("M/d/yy"));
	}

	/**
	 * 
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) {
		// TODO - implement Price.isEffective
		if(date.isBefore(this.getEffectiveDate())) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param quantity
	 */
	public BigDecimal calcAmountForQty(int quantity) {
		// TODO - implement Price.calcAmountForQty
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param price
	 */
	public int compareTo(Price price) {
		// TODO - implement Price.compareTo
		return this.getEffectiveDate().compareTo(price.getEffectiveDate());
	}

	public String toString() {
		// TODO - implement Price.toString
		return this.price.toString();
	}

	public TreeSet<Item> getItem() {
		return item;
	}

	public void setItem(TreeSet<Item> item) {
		this.item = item;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

}