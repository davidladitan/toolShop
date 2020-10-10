package toolShop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class FileManager {
	
	
	
	public FileManager() {
		
	}
	
	public ArrayList<Item> readItems(String itemFile, String supplierFile){
		
		ArrayList<Item> items = new ArrayList<Item>();
		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
		
		suppliers = readSuppliers(supplierFile);
		
		try {
			FileReader fr = new FileReader(itemFile);
			BufferedReader br = new BufferedReader(fr);
			
			String line ="";
			String [] temp;
			line = br.readLine();
			
			while(line != null) {
				temp = line.split(";");
				
				int supplierId = Integer.parseInt(temp[4]);
				
				Item item;
				
				for(Supplier s : suppliers) {
					if (s.getId() == supplierId) {
						
						item = new Item(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), Double.parseDouble(temp[3]), s);
						items.add(item);
						s.getItemsList().add(item);
					}
				}
				line = br.readLine();
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return items;
		
		
	}
	
	public ArrayList<Supplier> readSuppliers(String filename){
		
		ArrayList<Supplier>supplierList = new ArrayList<Supplier>();
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			line = br.readLine();
			String [] temp;
			
			while(line != null) {
				temp = line.split(";");
				
				Supplier theSupplier = new Supplier(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]);
				supplierList.add(theSupplier);
				line = br.readLine();
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return supplierList;
	}

}
