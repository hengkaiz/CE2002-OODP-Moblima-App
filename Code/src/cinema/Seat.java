package cinema;
import java.io.Serializable;
/**
 * represents the seats in the cinema
 *
 */
public class Seat implements Serializable {
	/**
	 * determines whether a seat is assigned or not
	 */
    private boolean assigned = false;
    /**
     * the customer's full name
     */
    private String customer_name;
    /**
     * constructs a Seat object for the Seat class
     */
    public Seat(){
        customer_name = "";
    }
    /**
     * 
     * @return customer's name
     */
    public String getCustomerId(){ return customer_name; }
    /**
     * 
     * @return whether the seat is occupied or not
     */

    public boolean isOccupied() { return assigned; }
    /**
     * assigns a seat to a customer
     * @param name input for name to assign to seat
     */

    public void assign(String name){
        customer_name = name;
        assigned = true;
    }
    /**
     * unassigns a seat, set customer's name associated to seat to blank
     */
    public void unAssign(){
        assigned = false;
        customer_name = "";
    }
}
