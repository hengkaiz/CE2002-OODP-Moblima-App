package Cinema;

public class Seat {
    private boolean assigned = false;
    private String customer_name;

    public Seat(){
        customer_name = "";
    }

    public String getCustomerId(){ return customer_name; }

    public boolean isOccupied() { return assigned; }

    public void assign(String name){
        customer_name = name;
        assigned = true;
    }

    public void unAssign(){
        assigned = false;
        customer_name = "";
    }
}
