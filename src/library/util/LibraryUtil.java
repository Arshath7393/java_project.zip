package library.util;
import java.util.Scanner;

public class LibraryUtil {

    public static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {

        System.out.println();
        System.out.println("==============================");
        System.out.println("   LIBRARY MANAGEMENT SYSTEM");
        System.out.println("==============================");
        System.out.println("1. Add Book");
        System.out.println("2. Display Books");
        System.out.println("3. Search Book");
        System.out.println("4. Issue Book");
        System.out.println("5. Return Book");
        System.out.println("6. Delete Book");
        System.out.println("7. Exit");
        System.out.println("==============================");
        System.out.print("Enter your choice: ");
    }
}