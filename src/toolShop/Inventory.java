package toolShop;

import java.util.ArrayList;

/**
 * Holds the inventory of all tools available in the store
 * @author odladitan
 *
 */
public class Inventory {
	
	private ArrayList<Item> items;
	private Order order;
	
	/**
	 * 
	 * @param items list of items in inventory
	 */
	public Inventory(ArrayList<Item> items) {
		setItems(items);
		order = new Order();
	}
	
	/**
	 * Gets the list of all items in inventory
	 * @return list of items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * 
	 * @param items items to set
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	/**
	 * 
	 * @return orders made in inventory
	 */
	public Order getOrder() {
		return order;
	}

	
	/**
	 * 
	 * @param order order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	
	/**
	 * Increases the quantity of an item by calling the items's increaseQuantity() method
	 * @param id id of the item
	 */
	public void increaseItem(int id) {
		for (Item item : items) {
			if (item.getId() == id)
				item.increaseQuantity();
		}
	}
	
	/**
	 * Decreases the quantity of an item by calling the items's increaseQuantity() method
	 * @param id id of the item
	 */
	public void decreaseItem(int id) {
		for (Item item : items) {
			if (item.getId() == id) {
				item.decreaseQuantity(order);
				System.out.println("Item is now " + item.getQuantity());
			}
		}
		
	}
	
	/**
	 * Searches for an item in the inventory by its id
	 * @param id id of item
	 * @return returns an Item object
	 */
	public Item searchItem(int id) {
		
		for (Item item : items) {
			if (item.getId() == id)
				return item;
		}
		return null;
	}
	
	/**
	 * Searches for an item in the inventory by its name
	 * @param name name of item
	 * @return returns an Item object 
	 */
	public Item searchItem(String name) {
		
		for (Item item : items) {
			if (item.getItemName().equals(name))
				return item;
		}
		return null;
	}
	
	/**
	 * Checks the quantity of an item available in stock
	 * @param itemId id of item
	 * @return the quantity of the item available in stock
	 */
	public int checkQuantity(int itemId) {
		int quantity = 0;
		for (Item item : items) {
			if (item.getId() == itemId)
				quantity = item.getQuantity();
		}
		return quantity;
	}
}

	
