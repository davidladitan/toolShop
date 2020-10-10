package toolShop;

public class FrontEnd {
	
	public static void main(String [] args) {
		Shop myshop = new Shop("items.txt", "suppliers.txt");
		
		for(Supplier s: myshop.getSupplierList()) {
			System.out.println(s);
		}
		
	}

}
