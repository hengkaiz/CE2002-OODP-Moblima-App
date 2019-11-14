package menu;

abstract class MenuBase {
    protected MenuBase previousMenu;

    public MenuBase(MenuBase previousMenu){
        this.previousMenu = previousMenu;
    }

    public MenuBase returnPrevious(){
        if (previousMenu != null) return previousMenu;
        else return this;
    }
}
