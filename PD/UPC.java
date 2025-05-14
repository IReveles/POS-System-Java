package PD;
public class UPC {

	private String uPC;
	Item item;

	public UPC() {
		// TODO - implement UPC.UPC
		this.uPC = null;
	}

	/**
	 * 
	 * @param upc
	 */
	public UPC(String upc) {
		// TODO - implement UPC.UPC
		this();
		this.uPC = upc;
	}

	public String toString() {
		// TODO - implement UPC.toString
		return this.uPC;
	}

	public String getUPC() {
		return uPC;
	}

	public void setUPC(String uPC) {
		this.uPC = uPC;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}