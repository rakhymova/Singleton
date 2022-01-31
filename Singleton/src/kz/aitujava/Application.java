package kz.aitujava;

public class Application { // this is my 'Client' class that requires an established connection to the database from 'Database' (Singleton) class

    public static void main(String[] args) {
        Database check = Database.getInstance();
        Database check2 = Database.getInstance();
        check.setWord("Hello :) ");
        check2.setWord("Goodbye!");
        check.print();
        check2.print();
        // 'Goodbye!' will be printed twice because we are working
        // with one instance of the 'Database' class throughout the entire code
    }
}
