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
	
	public void increaseItem(int itemId) {
		for (Item item : items) {
			if (item.getId() == itemId)
				item.increaseQuantity();
		}
	}
	
	public void decreaseItem(int itemId) {
		for (Item item : items) {
			if (item.getId() == itemId)
				item.decreaseQuantity();
		}
	}

}

	
