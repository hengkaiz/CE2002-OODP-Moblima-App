package moblima;

public abstract class MenuTemplate {
    protected MenuTemplate previousMenu;
    private String username;
    private int cineplexNum;

    public MenuTemplate(MenuTemplate previousMenu){
        this.previousMenu = previousMenu;
    }

    public MenuTemplate(){}

    public int getCineplexNum() {
        return cineplexNum;
    }

    public void setCineplexNum(int cineplexNum) {
        this.cineplexNum = cineplexNum;
    }

    public MenuTemplate returnPrevious(){
        if (previousMenu != null) return previousMenu.run();
        else return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public abstract MenuTemplate run();
}
