package cinema;

//import booking.BookingDetails;

import java.util.ArrayList;
import java.io.Serializable;
/**
 * represents the seatplan inside a cinema
 *
 */
public class SeatPlan implements Serializable{
	/**
	 * sets the number of rows as 8
	 */
    public static int rows = 8;
    /**
     * sets the number of columns as 10
     */
    public static int columns = 10;
    /**
     * sets the number of empty seats to rows x columns
     */
    private int numEmptySeat = rows*columns;
    /**
     * a lists of seats in array list form
     */
    private ArrayList<ArrayList<Seat>> seat;
    /**
     * construct a object SeatPlan for SeatPlan class
     */
    public SeatPlan(){
        seat = new ArrayList<ArrayList<Seat>>();
        for(int i = 0; i < rows; i++)  {
            seat.add(new ArrayList<Seat>());
        }
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                seat.get(i).add(new Seat());
            }
        }
    }
    /**
     * checks the seat to see if it is occupied or not
     * @param r input for the row of seat being checked
     * @param c input for the column of seat being checked
     * @return whether the checked seat is occupied or not
     */
    public boolean checkSeat(int r, int c){
        if(seat.get(r).get(c).isOccupied() == true){
            System.out.println("Seat already assigned to a customer.");
            return false;
        }
        return true;
    }
    /**
     * assigns a seat to a customer
     * @param r input for the row of the chosen seat 
     * @param c input for the column of the chosen seat
     * @param name input for the customer's name
     */

    public void assignSeat(int r, int c, String name){
        seat.get(r).get(c).assign(name);
        numEmptySeat--;
        System.out.println("Seat Assigned!");
    }
    
    /**
     * unassigns a seat
     * @param r input for the row of the chosen seat to be unassigned
     * @param c input for the column of the chosen seat to be unassigned
     */

    public void unAssignSeat(int r, int c){
        seat.get(r).get(c).unAssign();
        numEmptySeat++;
        System.out.println("Seat unassigned!");
    }
    
    /**
     * prints out the seats, showing which seats are taken and which seats are available
     */

    public void printSeats(){
        int printcolumns = (columns*3)+4;
        int b = 0;

        System.out.print("  ");
        for(int a=0;a<printcolumns;a++){
            System.out.print("-");
            while(a>=(printcolumns/2)-4 && a<(printcolumns/2)+2){
                System.out.print("SCREEN".charAt(b));
                b++;
                a++;
            }
        }

        b = 65; //ascii value of 'A'
        System.out.println();
        for(int i=0;i<rows;i++){
            System.out.print((char)b + " ");
            b++;
            for(int j=0;j<columns;j++){
                if(j==2 || j ==8){
                    System.out.print("  ");
                }
                if(seat.get(i).get(j).isOccupied() == false){
                    System.out.print("[ ]");
                }
                else{
                    System.out.print("[X]");
                }

            }
            System.out.print("\n");
        }
        b = 0;
        System.out.print("  ");
        for(int c=0;c<printcolumns;c+=3) {
            if (c == 6 || c == 27){
                System.out.printf("  ");
            }
            else{
                System.out.printf(" %d ", b);
                b++;
            }
        }
        System.out.print("\n");
    }

/*    public static void main(String[] args ){
        SeatPlan seatPlan = new SeatPlan();
        //System.out.println("ScREEN".charAt(0));
        seatPlan.printSeats();
    }*/
}

