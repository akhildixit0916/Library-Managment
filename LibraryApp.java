import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1. ABSTRACTION: Defining a general template for any library item
abstract class LibraryItem {
    private String title;
    private String id;
    protected boolean isAvailable;

    public LibraryItem(String title, String id) {
        this.title = title;
        this.id = id;
        this.isAvailable = true;
    }

    // ENCAPSULATION: Using getters to protect data
    public String getTitle() { return title; }
    public String getId() { return id; }
    public boolean getStatus() { return isAvailable; }

    // This method must be implemented by child classes (Polymorphism)
    public abstract void displayDetails();
}

// 2. INHERITANCE: Book "is-a" LibraryItem
class Book extends LibraryItem {
    private String author;

    public Book(String title, String id, String author) {
        super(title, id); // Passing data to the parent constructor
        this.author = author;
    }

    @Override
    public void displayDetails() {
        String status = isAvailable ? "Available" : "Checked Out";
        System.out.println("[" + getId() + "] " + getTitle() + " | Author: " + author + " | Status: " + status);
    }
}

// 3. THE CONTROLLER: Managing the collection
class Library {
    private List<LibraryItem> inventory = new ArrayList<>();

    public void addItem(LibraryItem item) {
        inventory.add(item);
    }

    public void showAllItems() {
        if (inventory.isEmpty()) {
            System.out.println("The library is currently empty.");
            return;
        }
        System.out.println("\n--- Library Inventory ---");
        for (LibraryItem item : inventory) {
            item.displayDetails();
        }
    }

    public void borrowItem(String searchTitle) {
        for (LibraryItem item : inventory) {
            // Logic: Case-insensitive search
            if (item.getTitle().equalsIgnoreCase(searchTitle)) {
                if (item.getStatus()) {
                    // Logic: Updating the object's internal state
                    ((Book)item).isAvailable = false; 
                    System.out.println("Success! You have borrowed: " + item.getTitle());
                } else {
                    System.out.println("Sorry, this item is already checked out.");
                }
                return;
            }
        }
        System.out.println("Item not found in our records.");
    }
}

// 4. THE EXECUTION: Main Class
public class LibraryApp {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        Scanner scanner = new Scanner(System.in);

        // Pre-loading some data
        myLibrary.addItem(new Book("The Great Gatsby", "B001", "F. Scott Fitzgerald"));
        myLibrary.addItem(new Book("1984", "B002", "George Orwell"));
        myLibrary.addItem(new Book("The Hobbit", "B003", "J.R.R. Tolkien"));

        System.out.println("Welcome to the Smart Library System!");
        
        while (true) {
            System.out.println("\n1. View Inventory\n2. Borrow a Book\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                myLibrary.showAllItems();
            } else if (choice == 2) {
                System.out.print("Enter book title to borrow: ");
                String title = scanner.nextLine();
                myLibrary.borrowItem(title);
            } else {
                System.out.println("Goodbye!");
                break;
            }
        }
        scanner.close();
    }
}