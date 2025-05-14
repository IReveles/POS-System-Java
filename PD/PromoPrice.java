package PD;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PromoPrice extends Price {

	private LocalDate endDate;

	public PromoPrice() {
		// TODO - implement PromoPrice.PromoPrice
	
	}

	/**
	 * 
	 * @param price
	 * @param effectiveDate
	 * @param endDate
	 */
	public PromoPrice(String price, String effectiveDate, String endDate) {
		// TODO - implement PromoPrice.PromoPrice
		this();
		setPrice(new BigDecimal(price));
		setEffectiveDate(LocalDate.parse(effectiveDate,  DateTimeFormatter.ofPattern("M/d/yy")));
		setEndDate(LocalDate.parse(endDate,  DateTimeFormatter.ofPattern("M/d/yy")));
	}

	/**
	 * 
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) {
		// TODO - implement PromoPrice.isEffective
		if(date.isBefore(getEffectiveDate())|| date.isAfter(endDate)) {
			return false;
		}
		return true;
	}

	public String toString() {
		// TODO - implement PromoPrice.toString
		return this.getPrice().toString() + " " + this.getEffectiveDate().toString() + " " + this.getEndDate().toString();
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}