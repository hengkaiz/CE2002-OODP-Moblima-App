package moblima;

public abstract class MenuTemplate {
    protected MenuTemplate previousMenu;
    private String username;

    public MenuTemplate(MenuTemplate previousMenu){
        this.previousMenu = previousMenu;
    }

    public MenuTemplate(){}

    public MenuTemplate returnPrevious(){
        if (previousMenu != null) return previousMenu;
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
