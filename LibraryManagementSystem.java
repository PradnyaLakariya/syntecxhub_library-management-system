import java.util.*;

class Book {
    String title;
    boolean isBorrowed;

    Book(String title) {
        this.title = title;
        this.isBorrowed = false;
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Sample Books
        books.add(new Book("Java Programming"));
        books.add(new Book("Data Structures"));
        books.add(new Book("Operating Systems"));

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Staff");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    staffMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= STAFF =================
    static void staffMenu() {
        while (true) {
            System.out.println("\n--- STAFF MENU ---");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Back");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= CUSTOMER =================
    static void customerMenu() {
        while (true) {
            System.out.println("\n--- CUSTOMER MENU ---");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Back");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= FUNCTIONS =================
    static void displayBooks() {
        System.out.println("\nAvailable Books:");
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            System.out.println((i + 1) + ". " + b.title + 
                (b.isBorrowed ? " (Borrowed)" : ""));
        }
    }

    static void addBook() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        books.add(new Book(title));
        System.out.println("Book added successfully!");
    }

    static void deleteBook() {
        displayBooks();
        System.out.print("Enter book number to delete: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index > 0 && index <= books.size()) {
            books.remove(index - 1);
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Invalid book number!");
        }
    }

    static void borrowBook() {
        displayBooks();
        System.out.print("Enter book number to borrow: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index > 0 && index <= books.size()) {
            Book b = books.get(index - 1);
            if (!b.isBorrowed) {
                b.isBorrowed = true;
                System.out.println("Book borrowed successfully!");
            } else {
                System.out.println("Book already borrowed!");
            }
        } else {
            System.out.println("Invalid book number!");
        }
    }
}