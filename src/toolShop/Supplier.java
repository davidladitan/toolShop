package toolShop;

import java.util.ArrayList;

/**
 * Represents the supplier of an item in the tool shop
 * @author David Laditan
 *
 */
public class Supplier {

	private int id;
	private String companyName;
	private String address;
	private String salesContact;
	
	private ArrayList<Item> itemsList;
	
	/**
	 * Constructor of Supplier object
	 * @param id supplier id
	 * @param companyName company name of supplier
	 * @param address address of supplier
	 * @param salesContact sales contact of supplier
	 */
	public Supplier(int id, String companyName, String address, String salesContact) {
		setId(id);
		setCompanyName(companyName);
		setAddress(address);
		setSalesContact(salesContact);
		itemsList = new ArrayList<Item>();
	}
	
	/**
	 * 
	 * @return id of supplier
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id id to be set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return company name of supplier
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * 
	 * @param companyName company name to be set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * 
	 * @return address of supplier 
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * 
	 * @param address address to be set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 
	 * @return sales contact of supplier 
	 */
	public String getSalesContact() {
		return salesContact;
	}
	
	/**
	 * 
	 * @param salesContact sales contact to be set
	 */
	public void setSalesContact(String salesContact) {
		this.salesContact = salesContact;
	}


	/**
	 * 
	 * @return list of items 
	 */
	public ArrayList<Item> getItemsList() {
		return itemsList;
	}
	
	/**
	 * String representation of Supplier object
	 */
	public String toString() {
		return id + " " + companyName;
	}
	
}
