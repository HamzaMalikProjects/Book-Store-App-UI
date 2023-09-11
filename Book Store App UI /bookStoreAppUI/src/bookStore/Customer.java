//Amanats Part 
/*
The Customer class is like a digital loyalty card for people shopping 
at a virtual bookstore. When customers buy stuff, they earn points. 
Once they have enough points, this digital card promotes them to a 
particular club. Everyone starts in the 'Silver' club, but if they 
collect over 1,000 points, they get bumped up to the fancier 'Gold' club.
The system is smart; it keeps tabs on which club each customer belongs
to without needing clarification. Imagine having a regular coffee card,
and once you buy enough coffee, you get a golden coffee card as a reward. 
That's how this customer system works but for books!
*/
package bookstore;

/*
*
Author: Omer, Hamza & Amanat
*
*/


// The Customer class represents a customer with a username, password, points, and customer state.
public class Customer {
    // The username of the customer
    private final String username;
    
    // The password of the customer
    private final String password;
    
    // The number of points the customer has earned
    private int points;
    
    // The customer's current state (e.g., Silver or Gold)
    private CustomerState state;

    // Constructor method for the Customer class.
    // Initializes a new Customer with the given username and password, and sets points to 0 and state to SilverState.
    Customer(String username, String password) {
        points = 0;
        this.username = username;
        this.password = password;
        state = new SilverState();
    }

    public String getUsername() {
        return username;
    }

    // Getter method for the customer's password
    public String getPassword() {
        return password;
    }

    // Getter method for the customer's points
    public int getPoints() {
        return points;
    }

    // Setter method for the customer's points
    // This method also updates the state of the customer based on the new point value.
    public void setPoints(int points) {
        this.points = ++points;
        state.updateState(this);
    }

    // Setter method for the customer's state
    public void setState(CustomerState state) {
        this.state = state;
    }

    // Getter method for the customer's state status
    public String getStatus() {
        return state.getStatus();
    }
}

// Abstract class CustomerState
// Represents the state of a customer.
abstract class CustomerState {
    // Abstract method to get the status of the state
    public abstract String getStatus();
    
    // Abstract method to update the state of the customer
    public abstract void updateState(Customer customer);
}

// Class representing the Silver state of a customer
class SilverState extends CustomerState {
    // Returns the status of the Silver state
    public String getStatus() {
        return "SILVER";
    }

    // Updates the state of the customer from Silver to Gold if the customer's points exceed 1000.
    public void updateState(Customer customer) {
        if (customer.getPoints() > 1000) {
            customer.setState(new GoldState());
        }
    }
}

// Class representing the Gold state of a customer
class GoldState extends CustomerState {
    // Returns the status of the Gold state
    public String getStatus() {
        return "GOLD";
    }

    // The updateState method for the Gold state does nothing because there is no higher state than Gold.
    public void updateState(Customer customer) {
  
    }
}
