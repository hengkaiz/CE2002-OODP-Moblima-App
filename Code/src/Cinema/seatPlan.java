package Cinema;

//import Booking.BookingDetails;

import java.util.ArrayList;

public class seatPlan {
    public static int rows = 8;
    public static int columns = 10;
    private int numEmptySeat = rows*columns;
    private ArrayList<ArrayList<seat>> seat;

    public seatPlan(){
        seat = new ArrayList<ArrayList<seat>>();
        for(int i = 0; i < rows; i++)  {
            seat.add(new ArrayList<seat>());
        }
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                seat.get(i).add(new seat());
            }
        }
    }

    public void assignSeat(int r, int c, int d){
        if(seat.get(r).get(c).isOccupied() == true){
            System.out.println("Seat already assigned to a customer.");
            return;
        }
        seat.get(r).get(c).assign(d);
        numEmptySeat--;
        System.out.println("Seat Assigned!");
    }

    public void unAssignSeat(int r, int c){
        seat.get(r).get(c).unAssign();
        numEmptySeat++;
        System.out.println("Seat unassigned!");
    }

    public void printSeats(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(seat.get(i).get(j).isOccupied() == false){
                    System.out.print("[ ] ");
                }
                else{
                    System.out.print("[X] ");
                }
            }
            System.out.print("\n");
        }
    }
}
