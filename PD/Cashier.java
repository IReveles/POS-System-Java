package PD;
import java.util.*;

public class Cashier {

	private String number;
	private String password;
	ArrayList<Session> sessions;
	Person person;

	public Cashier() {
		// TODO - implement Cashier.Cashier
		this.number = null;
		this.password = null;
		this.person = new Person();
		sessions = new ArrayList<Session>();
	}

	/**
	 * 
	 * @param number
	 * @param person
	 * @param password
	 */
	public Cashier(String number, Person person, String password) {
		// TODO - implement Cashier.Cashier
		this();
		this.number = number;
		this.password = password;
		this.person = person;
	}

	/**
	 * 
	 * @param session
	 */
	public void addSession(Session session) {
		// TODO - implement Cashier.addSession
		getSessions().add(session);
	}

	/**
	 * 
	 * @param session
	 */
	public void removeSession(Session session) {
		// TODO - implement Cashier.removeSession
		getSessions().remove(session);
	}

	/**
	 * 
	 * @param password
	 */
	public Boolean isAuthorized(String password) {
		// TODO - implement Cashier.isAuthorized
		boolean authorized = false;
		
		if(this.getPassword().equals(password)) {
			authorized = true;
		}
		
		return authorized;
	}

	public String toString() {
		// TODO - implement Cashier.toString
	
		return this.person.getName();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Session> getSessions() {
		return sessions;
	}

	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public boolean isUsed() {
		return !sessions.isEmpty();
	}

}