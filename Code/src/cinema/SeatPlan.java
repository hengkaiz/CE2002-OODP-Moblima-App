package cinema;

//import booking.BookingDetails;

import java.util.ArrayList;
import java.io.Serializable;

public class SeatPlan implements Serializable{
    public static int rows = 8;
    public static int columns = 10;
    private int numEmptySeat = rows*columns;
    private ArrayList<ArrayList<Seat>> seat;

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

    public boolean checkSeat(int r, int c){
        if(seat.get(r).get(c).isOccupied() == true){
            System.out.println("Seat already assigned to a customer.");
            return false;
        }
        return true;
    }

    public void assignSeat(int r, int c, String name){
        seat.get(r).get(c).assign(name);
        numEmptySeat--;
        System.out.println("Seat Assigned!");
    }

    public void unAssignSeat(int r, int c){
        seat.get(r).get(c).unAssign();
        numEmptySeat++;
        System.out.println("Seat unassigned!");
    }

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

