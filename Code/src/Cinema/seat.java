package Cinema;

public class seat {
    private boolean assigned = false;
    private int customerId;

    public seat(int c){ customerId = c; }

    public int getCustomerId(){ return customerId; }

    public boolean isOccupied() { return assigned; }

    public void assign(int c){
        customerId = c;
        assigned = true;
    }

    public void unAssign(){
        assigned = false;
        customerId = 0;
    }
}
