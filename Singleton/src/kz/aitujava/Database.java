package kz.aitujava;

import java.sql.Connection;
import java.sql.DriverManager;

//'Database' is my Singleton class that lets clients access the same instance of a database connection
// throughout the program.
public class Database {
    private static Database instance;
    private String word;

    // constructor needs to be private, so that it is impossible to create new instances of 'Database' Class
    // this constructor checks if the connection to the database was successfully established and prints out so
    private Database(){
        Connection con = null;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "73arorak");

            if (con!=null) {
                System.out.println("Connection to the database - Established Successfully!");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // this method provides a global access point to our 'instance', (it's accessible since it's a public method)
    public static Database getInstance() {
        // if instance is not initialized, then this 'if statement' does so and returns the instance
        if (instance==null) {
            // here I could have implemented acquireThreadLock() method that allows to force
            // multiple threads to access a resource one at a time, rather than all of them accessing simultaneously
            instance= new Database();
        }
        return instance;
    }

    //public methods to check if 'instance' is accessible and its methods function properly
    public void setWord (String word) {
        this.word= word;
    }

    public void print() {
        System.out.println(this.word);
    }
}
