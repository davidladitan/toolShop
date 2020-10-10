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
	
	

}
