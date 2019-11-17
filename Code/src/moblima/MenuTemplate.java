package moblima;
/**
 * represents the menutemplate
 *
 */
public abstract class MenuTemplate {
	/**
	 *points to the previous menu
	 */
    protected MenuTemplate previousMenu;
    /**
     * user's username
     */
    private String username;
    /**
     * cineplex's number
     */
    private int cineplexNum;
    /**
     * menu constructor
     * @param previousMenu points to the previous menu
     */
    public MenuTemplate(MenuTemplate previousMenu){
        this.previousMenu = previousMenu;
    }
    /**
     * menu constructor
     */
    public MenuTemplate(){}
    /**
     * 
     * @return current cineplex number
     */
    public int getCineplexNum() {
        return cineplexNum;
    }
    /**
     * 
     * @param cineplexNum cineplex's number to set
     */

    public void setCineplexNum(int cineplexNum) {
        this.cineplexNum = cineplexNum;
    }
    /**
     * 
     * @return previous menu
     */
    public MenuTemplate returnPrevious(){
        if (previousMenu != null) return previousMenu.run();
        else return this;
    }
    /**
     * 
     * @return current username
     */
    public String getUsername() {
        return username;
    }
    /**
     * 
     * @param username username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * prints menu options and asks user to pick an option
	 * the next menu will be run based on user input
     * @return
     */
    public abstract MenuTemplate run();
}
