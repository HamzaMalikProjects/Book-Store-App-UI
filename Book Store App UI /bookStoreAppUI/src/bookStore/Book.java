//Amanats Part
/*
The Book class is like a digital sticker for each book in a computerized bookstore. 
Think of it as the price tag and a tiny checkbox you'd see on a shopping website. 
This sticker tells you the book's name and how much it costs and lets you tick
a box if interested. JavaFX uses a unique tool which makes things look pretty on
your computer screen. So, when you want to create a new sticker (or book tag) 
in the system, you give it a book's name and price. Automatically, it gets a fresh,
unticked checkbox. Later, if someone wants to know the book's title or price, or if
the box is ticked, there are simple tools to find out. This sticker or tag is a small
part of a bigger online bookstore where you can look at books, pick what you like,
and buy them.
*/
package bookstore;

/*
*
Author: Omer, Hamza & Amanat
*
*/

// JavaFX libraries for UI components
import javafx.scene.control.CheckBox;

// The Book class represents a book with a name, price and a selection checkbox.
public class Book {

    // The name of the book
    private final String bookName;
    
    // The price of the book
    private final double price;
    
    // A checkbox that indicates whether the book is selected or not
    private CheckBox selection;

    // Constructor method for the Book class.
    // Initializes a new Book with the given title, price, and an unselected checkbox.
    public Book (String bookTitle, double bookPrice) {
        this.bookName = bookTitle;
        this.price = bookPrice;
        selection = new CheckBox();
    }

    // Getter method for the book's name
    public String getBookName() {
        return this.bookName;
    }

    // Getter method for the book's price
    public double getPrice() {
        return this.price;
    }

    // Getter method for the book's selection status
    public CheckBox getSelection() {
        return selection;
    }

    // Setter method for the book's selection status
    // Allows to change the selection status of the book
    public void setSelection(CheckBox select) {
        this.selection = select;
    }
    
}
