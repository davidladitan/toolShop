package toolShop;

import java.util.ArrayList;

public class Shop {
	private Inventory myInventory;
	private ArrayList<Supplier> supplierList;
	
	public Shop(String itemsFile, String suppliersFile){
		
		FileManager myManager = new FileManager();
		
		ArrayList<Item> items = myManager.readItems(itemsFile, suppliersFile);
		myInventory = new Inventory(items);
		
		supplierList = myManager.readSuppliers(suppliersFile);
	}

	public Inventory getMyInventory() {
		return myInventory;
	}

	public ArrayList<Supplier> getSupplierList() {
		return supplierList;
	}
	
	public void addItem(int toolId) {
		myInventory.increaseItem(toolId);
	}
	
	public void removeItem(int toolId) {
		myInventory.decreaseItem(toolId);
	}
	
	public Item searchItemById(int id) {
		return myInventory.searchItem(id);
	}
	
	public Item searchItemByName(String name) {
		return myInventory.searchItem(name);
	}
	

}
