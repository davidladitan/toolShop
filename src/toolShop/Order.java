package toolShop;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {
	
	private String orderId;
	private String date;
	private ArrayList<OrderLine> orderLines;
	
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

	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
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
