package PD;

import java.util.ArrayList;

public class Register {

	private String number;
	CashDrawer cashDrawer;
	ArrayList<Session> sessions;

	public Register() {
		// TODO - implement Register.Register
		this.number = null;
		cashDrawer = new CashDrawer();
		sessions = new ArrayList<Session>();
	}

	/**
	 * 
	 * @param number
	 */
	public Register(String number) {
		// TODO - implement Register.Register
		this();
		this.number = number;
	}

	public String toString() {
		// TODO - implement Register.toString
		return this.number; // + "  Cash: " + cashDrawer.getCashAmount();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public CashDrawer getCashDrawer() {
		return cashDrawer;
	}

	public void setCashDrawer(CashDrawer cashDrawer) {
		this.cashDrawer = cashDrawer;
	}
	
	public boolean isUsed() {
		return !sessions.isEmpty();
	}
	
	public ArrayList<Session> getSessions() {
		return sessions;
	}

	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}

	public void addSession(Session session) {
		// TODO Auto-generated method stub
		getSessions().add(session);
	}

	public void removeSession(Session session) {
		// TODO Auto-generated method stub
		getSessions().remove(session);
	}

}