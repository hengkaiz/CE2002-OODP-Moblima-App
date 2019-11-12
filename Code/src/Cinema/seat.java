package Cinema;

import Booking.BookingDetails;

public class seat {
    private boolean assigned = false;
    private int customer_id;

    public seat(){
        customer_id = 0;
    }

    public int getCustomerId(){ return customer_id; }

    public boolean isOccupied() { return assigned; }

    public void assign(int b){
        customer_id = b;
        assigned = true;
    }

    public void unAssign(){
        assigned = false;
        customer_id = 0;
    }
}
