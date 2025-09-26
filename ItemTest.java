import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String item_name;
    private double price;
    private int sold;
    private int stock;

 
    public Item(String item_name, double price, int stock) {
        this.item_name = item_name;
        this.price = price;
        this.stock = stock;
        this.sold = 0;
    }

    
    public void logDetails() {
        System.out.println("\n=== ITEM DETAILS ===");
        System.out.println("Item: " + item_name);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stock);
        System.out.println("Sold: " + sold);
        System.out.println("====================\n");
    }

    public void buy() {
        if (stock > 0) {
            stock--;
            sold++;
            System.out.println("✅ You bought 1 " + item_name);
        } else {
            System.out.println("❌ Sorry, " + item_name + " is out of stock!");
        }
    }

    public void returnItem() {
        if (sold > 0) {
            stock++;
            sold--;
            System.out.println("↩️ You returned 1 " + item_name);
        } else {
            System.out.println("❌ No " + item_name + " to return!");
        }
    }

    public String getName() {
        return item_name;
    }
}

public class ItemTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> inventory = new ArrayList<>();

        int choice;
        do {
            System.out.println("\n--- INVENTORY MENU ---");
            System.out.println("1. Add New Item");
            System.out.println("2. Buy Item");
            System.out.println("3. Return Item");
            System.out.println("4. Show All Items");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter stock: ");
                    int stock = sc.nextInt();

                    inventory.add(new Item(name, price, stock));
                    System.out.println("✅ Item added successfully!");
                    break;

                case 2: 
                    if (inventory.isEmpty()) {
                        System.out.println("❌ No items in inventory!");
                        break;
                    }
                    System.out.println("Choose item to buy:");
                    for (int i = 0; i < inventory.size(); i++) {
                        System.out.println((i + 1) + ". " + inventory.get(i).getName());
                    }
                    int buyChoice = sc.nextInt();
                    if (buyChoice > 0 && buyChoice <= inventory.size()) {
                        inventory.get(buyChoice - 1).buy();
                    } else {
                        System.out.println("❌ Invalid item choice!");
                    }
                    break;

                case 3: 
                    if (inventory.isEmpty()) {
                        System.out.println("❌ No items in inventory!");
                        break;
                    }
                    System.out.println("Choose item to return:");
                    for (int i = 0; i < inventory.size(); i++) {
                        System.out.println((i + 1) + ". " + inventory.get(i).getName());
                    }
                    int returnChoice = sc.nextInt();
                    if (returnChoice > 0 && returnChoice <= inventory.size()) {
                        inventory.get(returnChoice - 1).returnItem();
                    } else {
                        System.out.println("❌ Invalid item choice!");
                    }
                    break;

                case 4: 
                    if (inventory.isEmpty()) {
                        System.out.println("❌ No items in inventory!");
                    } else {
                        for (Item item : inventory) {
                            item.logDetails();
                        }
                    }
                    break;

                case 5: 
                    System.out.println("👋 Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice, try again!");
            }
        } while (choice != 5);

        sc.close();
    }
}