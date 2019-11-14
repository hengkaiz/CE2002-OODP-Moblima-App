package moblima;

import cinema.ShowTime;
import cinema.ShowTimeDatabase;

//initialize the databases here
public class DatabaseInitialization {
    private ShowTimeDatabase db = new ShowTimeDatabase();

    public ShowTimeDatabase getDb() {
        return db;
    }

    public void setDb(ShowTimeDatabase db) {
        this.db = db;
    }
}
