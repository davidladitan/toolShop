package toolShop;

public class Item {
	
	private int id;
	private String itemName;
	private int quantity;
	private double price;
	private Supplier supplier;
	
	public Item(int id, String itemName, int quantity, double price, Supplier supplier) {
		setId(id);
		setItemName(itemName);
		setQuantity(quantity);
		setPrice(price);
		setSupplier(supplier);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public String toString() {
		return id + " " + itemName + " " + supplier.getId();
	}
	
	public void increaseQuantity() {
		quantity++;
	}
	
	public void decreaseQuantity() {
		quantity--;
	}
	
	

}
