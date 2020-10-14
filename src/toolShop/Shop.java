package toolShop;

import java.util.ArrayList;

/**
 * Represents a class to manage the inventory 
 * @author David Laditan
 *
 */
public class Shop {
	private Inventory myInventory;
	private ArrayList<Supplier> supplierList;
	
	/**
	 * constructor of shop item
	 * @param itemsFile text file containing items in store
	 * @param suppliersFile text file containing store suppliers information
	 */
	public Shop(String itemsFile, String suppliersFile){
		
		FileManager myManager = new FileManager();
		
		ArrayList<Item> items = myManager.readItems(itemsFile, suppliersFile);
		myInventory = new Inventory(items);
		
		supplierList = myManager.readSuppliers(suppliersFile);
	}

	/**
	 * 
	 * @return inventory of shop
	 */
	public Inventory getMyInventory() {
		return myInventory;
	}

	/**
	 * 
	 * @return list of suppliers
	 */
	public ArrayList<Supplier> getSupplierList() {
		return supplierList;
	}
	
	/**
	 * adds 1 quantity of an item to the inventory
	 * @param toolId
	 */
	public void addItem(int toolId) {
		myInventory.increaseItem(toolId);
	}
	
	/**
	 * removes an item from shop inventory, simulates the sale of an item
	 * @param toolId
	 */
	public void removeItem(int toolId) {
		myInventory.decreaseItem(toolId);
	}
	
	/**
	 * searches for an item by its id
	 * @param id id of an item
	 * @return returns the item
	 */
	public Item searchItemById(int id) {
		return myInventory.searchItem(id);
	}
	
	/**
	 * searches for an item by its name
	 * @param name name of an item
	 * @return returns the item
	 */
	public Item searchItemByName(String name) {
		return myInventory.searchItem(name);
	}
	

}
