package PD;
public class Person {

	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String sSN;

	public Person() {
		// TODO - implement Person.Person
		this.name = null;
		this.address = null;
		this.city = null;
		this.state = null;
		this.zip = null;
		this.phone = null;
		this.sSN = null;

	}

	/**
	 * 
	 * @param name
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 * @param sSN
	 */
	public Person(String name, String address, String city, String state, String zip, String phone, String sSN) {
		// TODO - implement Person.Person
		this();
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.sSN = sSN;
	}

	public String toString() {
		// TODO - implement Person.toString
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getsSN() {
		return sSN;
	}

	public void setsSN(String sSN) {
		this.sSN = sSN;
	}

}