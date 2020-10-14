package toolShop;

/**
 * Represents an order line for an item when the item quantity is low(<40)
 * @author David Laditan
 *
 */
public class OrderLine {

	
	private Item item;
	private int amountOrdered;
	
	/**
	 * constructor of an OrderLine object
	 * @param it item
	 */
	public OrderLine(Item it) {
		setItem(it);
		
		amountOrdered = 50 - item.getQuantity();
		
	}
	
	/**
	 * 
	 * @param item item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	/**
	 * 
	 * @return item 
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * string representation of an OrderLine object
	 */
	public String toString() {
		String s = "Item description:\t\t\t" + item.getItemName() + "\n"
				+ "Amount ordered:\t\t\t\t" + amountOrdered + "\n"
				+ "Supplier: \t\t\t\t" + item.getSupplier().getCompanyName() + "\n\n";
		return s;
		
	}
	
}
