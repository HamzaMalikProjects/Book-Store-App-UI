// Hamza and Omers Part 
/*
The fileHandle class serves as the digital filing cabinet of the bookstore system. 
This class saves and retrieves data, allowing the bookstore to effortlessly store details
of books in a book file and customer file. When invoked, it writes down the names and prices 
of books or the usernames, passwords, and points of customers. Moreover, if there's ever a need 
to start fresh, this class offers a reset function to clear out all stored data. Whenever the 
system needs to review its book collection or customer list, fileHandle steps in, reading from 
these files and transforming the data into lists for easy access. In essence, it ensures that
the bookstore's digital records are always organized and easily accessible.
*/

package bookstore;

/*
*
Author: Omer, Hamza & Amanat
*
*/
// Import necessary classes for file handling and data manipulation
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// The fileHandle class handles file-related operations for the Bookstore.
public class fileHandle {

    // Method to write book information to a file
    public void bookFileWrite(ArrayList<Book> books) throws IOException {
        // Create a FileWriter object for the "book.txt" file in append mode
        FileWriter bookFile = new FileWriter("book.txt", true);
        
        // Loop through each book in the ArrayList and write its information to the file
        for (Book b : books) {
            String bookInfo = b.getBookName() + ", " + b.getPrice() + "\n";
            bookFile.write(bookInfo);
        }
        
        // Close the FileWriter
        bookFile.close();
    }

    // Method to write customer information to a file
    public void customerFileWrite(ArrayList<Customer> customers) throws IOException {
        // Create a FileWriter object for the "customer.txt" file in append mode
        FileWriter customerFile = new FileWriter("customer.txt", true);
        
        // Loop through each customer in the ArrayList and write its information to the file
        for (Customer c : customers) {
            String outputText = c.getUsername() + ", " + c.getPassword() + ", " + c.getPoints() + "\n";
            customerFile.write(outputText);
        }
        
        // Close the FileWriter
        customerFile.close();
    }

    // Method to reset the book file (delete all data)
    public void bookFileReset() throws IOException {
        // Create a FileWriter object for the "book.txt" file in overwrite mode
        FileWriter bookFile = new FileWriter("book.txt", false);
        bookFile.close();
    }

    // Method to reset the customer file (delete all data)
    public void customerFileReset() throws IOException {
        // Create a FileWriter object for the "customer.txt" file in overwrite mode
        FileWriter customerFile = new FileWriter("customer.txt", false);
        customerFile.close();
    }

    // Method to read book information from a file
    public ArrayList<Book> readBookFile() throws IOException {
        // Create a Scanner object for the "book.txt" file
        Scanner scan = new Scanner(new FileReader("book.txt"));
        ArrayList<Book> tempBookHolder = new ArrayList<>();

        // Loop through each line in the file, parse the book information and add it to the ArrayList
        while (scan.hasNext()) {
            String[] bookInfo = scan.nextLine().split(",");
            String title = bookInfo[0].trim();
            double price = Double.parseDouble(bookInfo[1].trim());
            tempBookHolder.add(new Book(title, price));
        }
        scan.close();
        return tempBookHolder;
    }

    // Method to read customer information from a file
    public ArrayList<Customer> readCustomerFile() throws IOException {
        // Create a Scanner object for the "customer.txt" file
        Scanner scan = new Scanner(new FileReader("customer.txt"));
        ArrayList<Customer> tempCustomerHolder = new ArrayList<>();

        // Loop through each line in the file, parse the customer information and add it to the ArrayList
        while (scan.hasNext()) {
            String[] customerInfo = scan.nextLine().split(", ");
            String username = customerInfo[0];
            String password = customerInfo[1];
            int points = Integer.parseInt(customerInfo[2]);
            tempCustomerHolder.add(new Customer(username, password));
            tempCustomerHolder.get(tempCustomerHolder.size() - 1).setPoints(points);
        }
        scan.close();
        return tempCustomerHolder;
    }
}
