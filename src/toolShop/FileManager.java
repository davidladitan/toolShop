package toolShop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * This class reads items and suppliers from text files.
 * @author David Laditan
 *
 */
public class FileManager {
	
	public FileManager() {
		
	}
	
	/**
	 * reads shop items from a text file. checks supplierId of items and to items list of supplier. 
	 * 
	 * @param itemFile 
	 * @param supplierFile
	 * @return returns a list of Item objects containing all items read from the text file. 
	 */
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
						
						item = new Item(Integer.parseInt(temp[0]), temp[1].strip(), Integer.parseInt(temp[2]), Double.parseDouble(temp[3]), s);
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
	
	/**
	 * reads suppliers from a text file and returns a list of Supplier objects
	 * 
	 * @param filename name of text file containing supplier information
	 * @return returns a list of Supplier objects
	 */
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
