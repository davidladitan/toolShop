package toolShop;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Item> items;
	private Order order;
	
	
	public Inventory(ArrayList<Item> items) {
		setItems(items);
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public void increaseItem(int id) {
		for (Item item : items) {
			if (item.getId() == id)
				item.increaseQuantity();
		}
	}
	
	public void decreaseItem(int id) {
		for (Item item : items) {
			if (item.getId() == id) {
				item.decreaseQuantity();
				System.out.println("Item is now" + item.getQuantity());
			}
		}
		
	}
	
	public Item searchItem(int id) {
		
		for (Item item : items) {
			if (item.getId() == id)
				return item;
		}
		return null;
	}
	
	public Item searchItem(String name) {
		
		for (Item item : items) {
			if (item.getItemName().equals(name))
				return item;
		}
		return null;
	}
	
	public int checkQuantity(int itemId) {
		int quantity = 0;
		for (Item item : items) {
			if (item.getId() == itemId)
				quantity = item.getQuantity();
		}
		return quantity;
	}
}

	
