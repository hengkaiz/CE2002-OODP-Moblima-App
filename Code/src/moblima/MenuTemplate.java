package moblima;

public abstract class MenuTemplate {
    protected MenuTemplate previousMenu;

    public MenuTemplate(MenuTemplate previousMenu){
        this.previousMenu = previousMenu;
    }

    public MenuTemplate(){}

    public MenuTemplate returnPrevious(){
        if (previousMenu != null) return previousMenu;
        else return this;
    }

    public abstract MenuTemplate run();
}
