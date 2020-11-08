package toolShop;

/**
 * Represents an item/tool available in the tool shop
 * @author David Laditan
 *
 */
public class Item {
	
	private int id;
	private String itemName;
	private int quantity;
	private double price;
	private Supplier supplier;
	private Boolean isLow;
	
	/**
	 * 
	 * @param id item id
	 * @param itemName item name
	 * @param quantity item quantity 
	 * @param price price of item
	 * @param supplier Supplier object
	 */
	public Item(int id, String itemName, int quantity, double price, Supplier supplier) {
		setId(id);
		setItemName(itemName);
		setQuantity(quantity);
		setPrice(price);
		setSupplier(supplier);
		isLow = false; //quantity > 40 ? false: true;
	}
	
	/**
	 * 
	 * @return item id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return item name
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * 
	 * @param itemName item name to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	 * 
	 * @return quantity of item in stock
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * 
	 * @param quantity quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * 
	 * @return price of item
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @param price price of item to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * 
	 * @return supplier of item (Supplier object)
	 */
	public Supplier getSupplier() {
		return supplier;
	}
	
	/**
	 * 
	 * @param supplier supplier of item 
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	/**
	 *  String representation of item
	 */
	public String toString() {
		return "Tool id: " + id + ", Tool name: " + itemName + ", Supplier id: " + supplier.getId() + " ,amount left: " + getQuantity();
	}
	
	/**
	 * Increases the quantity of an item by 1
	 */
	public void increaseQuantity() {
		quantity++;
		
		if (quantity > 40 ) {
			isLow = false;
			
		}
		
	}
	
	/**
	 * Decreases the quantity of the item by one. Also creates an order line for the item and adds to order if the item quantity is below 40  
	 * @param order Order object created by Inventory
	 */
	public void decreaseQuantity(Order order) {
		quantity--;
		
		
		if (quantity < 40 && isLow == false) {
			isLow = true;
			order.getOrderLines().add(createOrder());
			System.out.println("Item low, generating order..");
		}
		
	}
	
	/**
	 * Creates an order line for the item
	 * @return returns an OrderLine object
	 */
	private OrderLine createOrder() {
		OrderLine myOrder = new OrderLine(this);
		return myOrder;
	}

}
