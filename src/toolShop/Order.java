package toolShop;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Represents an order which is a collection of order lines for different items for a particular day
 * @author David Laditan
 *
 */
public class Order {
	
	private String orderId;
	private String date;
	private ArrayList<OrderLine> orderLines;
	
	/**
	 * Constructor for Order
	 */
	public Order() {
		SecureRandom random = new SecureRandom();
		int num = random.nextInt(100000);
		String formatted = String.format("%05d", num); 
		setOrderId(formatted);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String formatedDate = df.format(new Date());
		
		setDate(formatedDate);
		
		orderLines = new ArrayList<OrderLine>();
	}

	/**
	 * 
	 * @return order lines in order
	 */
	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}

	/**
	 *  
	 * @param orderLines list of order lines for each item
	 */
	public void setOrderLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	/**
	 * 
	 * @return date an order is made
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 
	 * @param date date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 
	 * @return order Id of order
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 
	 * @param orderId order Id to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * String representation of order
	 */
	public String toString() {
		String header = "ORDER ID:\t\t\t\t" + orderId + "\n"
				+ "Date Ordered:\t\t\t\t" + date + "\n\n";
		
		String s = "";
		
		for (OrderLine ol : orderLines) {
			s += ol.toString();
		}
		s += "\n";
		
		return header + s;
	}
	

}
