package PD;

public  abstract class AuthorizedPayment extends Payment {

	private String authorizationCode;

	public abstract Boolean isAuthorized();

	public Boolean countAsCash() {
		// TODO - implement AuthorizedPayment.countAsCash
		return false;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

}