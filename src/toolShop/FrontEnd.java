package toolShop;


import java.util.Scanner;

/**
 * Represents the front end to interact with the tool shop 
 * @author David Laditan
 *
 */
public class FrontEnd {
	
	Shop theshop;
	Scanner scanner;
	
	/**
	 * constructor of a FrontEnd object
	 */
	public FrontEnd() {
		theshop = new Shop("items.txt", "suppliers.txt");
		scanner = new Scanner(System.in);
	}
	
	/**
	 * prints the menu list available to a user 
	 */
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
	
	/**
	 * runs the front end application
	 */
	public void menu() {
		
		
		while (true) {
			
			printMenuList();
			
			
			int choice = Integer.parseInt(scanner.nextLine());
			
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
	
	

	/**
	 * displays all the items ordered for the day
	 */
	private void printTodaysOrder() {
		
		System.out.println(theshop.getMyInventory().getOrder());
		
	}

	/**
	 * decreases an item quantity by 1
	 */
	private void decreaseItemQuantity() {
		int toolId = getToolId();
		theshop.removeItem(toolId);
		
	}
	
	/**
	 * increases an item quantity by 1
	 */
	private void increaseItemQuantity() {
		int toolId = getToolId();
		theshop.addItem(toolId);
	}

	/**
	 * lists all the tools available in the inventory
	 */
	private void listAllTools() {
		
		System.out.println("Tools List:\n");
		for (Item item : theshop.getMyInventory().getItems()) {
			System.out.println(item);
		}
		
	}

	/**
	 * checks the quantity of an item available in stock
	 */
	private void checkItemQuantity() {
		
		System.out.println("To check by tool id press 0, to check by tool name enter 1:");
		int choice = Integer.parseInt(scanner.nextLine());
		Item item = null;
		
		while (choice != 0 && choice != 1) {
			System.out.println("Please enter a correct search option");
			choice = Integer.parseInt(scanner.nextLine());
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

	/**
	 * gets a tool name from the user
	 * @return tool name
	 */
	private String getToolName() {
		String name = "";
		
		while(true) {
			System.out.println("Please enter tool name: ");
			name = scanner.nextLine();
			Item item = theshop.searchItemByName(name);
			if (item == null)
				System.out.println("Invalid tool name!");
			else
				break;
			
		}
		return name;
	}
	
	/**
	 * gets a tool id from the user
	 * @return tool id 
	 */
	private int getToolId() {
		int id = 0;
		
		while(true) {
			System.out.println("Please enter tool id: ");
			id = Integer.parseInt(scanner.nextLine());
			Item item = theshop.searchItemById(id);
			if (item == null)
				System.out.println("Invalid tool Id!");
			else
				break;
			
		}
		return id;
	}

	/**
	 * search for a tool by name
	 */
	private void searchByToolName() {
		
		String name = getToolName();
		Item item = theshop.searchItemByName(name);
		System.out.println(item);
	}
	
	/**
	 * search for a tool by id
	 */
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


