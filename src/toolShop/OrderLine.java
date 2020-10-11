package toolShop;


public class OrderLine {

	
	private Item item;
	private int amountOrdered;
	
	public OrderLine(Item it) {
		setItem(it);
		
		amountOrdered = 50 - item.getQuantity();
		
	}
	
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}
	
	public String toString() {
		String s = "Item description:\t\t\t" + item.getItemName() + "\n"
				+ "Amount ordered:\t\t\t\t" + amountOrdered + "\n"
				+ "Supplier: \t\t\t\t" + item.getSupplier().getCompanyName() + "\n\n";
		return s;
		
	}
	
}
