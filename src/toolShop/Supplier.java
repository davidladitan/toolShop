package toolShop;

import java.util.ArrayList;

public class Supplier {

	private int id;
	private String companyName;
	private String address;
	private String salesContact;
	
	private ArrayList<Item> itemsList;
	
	
	public Supplier(int id, String companyName, String address, String salesContact) {
		setId(id);
		setCompanyName(companyName);
		setAddress(address);
		setSalesContact(salesContact);
		itemsList = new ArrayList<Item>();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSalesContact() {
		return salesContact;
	}
	public void setSalesContact(String salesContact) {
		this.salesContact = salesContact;
	}


	public ArrayList<Item> getItemsList() {
		return itemsList;
	}
	
	public String toString() {
		return id + " " + companyName;
	}
	
}
