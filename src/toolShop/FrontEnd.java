package toolShop;

import java.awt.Menu;
import java.util.Scanner;

public class FrontEnd {
	
	Shop theshop;
	Scanner scanner;
	
	public FrontEnd() {
		theshop = new Shop("items.txt", "suppliers.txt");
		scanner = new Scanner(System.in);
	}
	
	public void printMenuList() {
		System.out.println("Please choose one of the following options:\n\n"
				+ "1. List all tools\n"
				+ "2. Search for tool by tool name\n"
				+ "3. Search for tool by tool id\n"
				+ "4. Check item quantity\n"
				+ "5. Decrease item quantity\n"
				+ "6. Print today's order\n"
				+ "7. Quit.\n");
	}
	
	public void menu() {
		
		
		while (true) {
			
			printMenuList();
			
			
			int choice = scanner.nextInt();
			
			switch (choice) {
			
			case 1:
				listAllTools();
				break;
			case 2:
				searchByToolName();
				break;
			case 3:
				searchByToolId();
				break;
			case 4:
				checkItemQuantity();
				break;
			case 5:
				decreaseItemQuantity();
				break;
			case 6:
				printTodaysOrder();
				break;
			case 7:
				System.out.println("You quit the program");
				return;
			default:
				System.out.println("Please select a valid option");
				
			}
		}
	}
	
	

	private void printTodaysOrder() {
		
		System.out.println(theshop.getMyInventory().getOrder());
		
	}

	private void decreaseItemQuantity() {
		int toolId = getToolId();
		theshop.removeItem(toolId);
		
	}
	
	private void increaseItemQuantity() {
		int toolId = getToolId();
		theshop.addItem(toolId);
	}

	private void listAllTools() {
		
		System.out.println("Tools List:\n");
		for (Item item : theshop.getMyInventory().getItems()) {
			System.out.println(item);
		}
		
	}

	private void checkItemQuantity() {
		
		System.out.println("To check by tool id press 0, to check by tool name enter 1:");
		int choice = scanner.nextInt();
		Item item = null;
		
		while (choice != 0 && choice != 1) {
			System.out.println("Please enter a correct search option");
			choice = scanner.nextInt();
		}
		
		if (choice == 0) {
			int toolId = getToolId();
			item = theshop.searchItemById(toolId);
		}else if(choice == 1) {
			String toolName = getToolName();
			item = theshop.searchItemByName(toolName);
		}
		
		System.out.println("Amount of " + item.getItemName() + " left in stock: " + item.getQuantity() + "\n");
		
	}

	private String getToolName() {
		String name = "";
		
		while(true) {
			System.out.println("Please enter tool name: ");
			name = scanner.next();
			Item item = theshop.searchItemByName(name);
			if (item == null)
				System.out.println("Invalid tool name!");
			else
				break;
			
		}
		return name;
	}
	
	private int getToolId() {
		int id = 0;
		
		while(true) {
			System.out.println("Please enter tool id: ");
			id = scanner.nextInt();
			Item item = theshop.searchItemById(id);
			if (item == null)
				System.out.println("Invalid tool Id!");
			else
				break;
			
		}
		return id;
	}

	private void searchByToolName() {
		
		String name = getToolName();
		Item item = theshop.searchItemByName(name);
		System.out.println(item);
	}
	
	private void searchByToolId() {
		int toolId = getToolId();
		Item item = theshop.searchItemById(toolId);
		System.out.println(item);
		
	}

	public static void main(String [] args) {
		
		FrontEnd shopApp = new FrontEnd();
		shopApp.menu();
		}
		
	}


