package org.example;

import org.example.Dog.Dog;
import org.example.Dog.DogDao;
import org.example.Dog.DogDaoImpl;
import org.example.EventLog.EventLog;
import org.example.EventLog.EventLogDao;
import org.example.EventLog.EventLogDaoImpl;
import org.example.EventType.EventType;
import org.example.EventType.EventTypeDao;
import org.example.EventType.EventTypeDaoImpl;
import org.example.Owner.Owner;
import org.example.Owner.OwnerDao;
import org.example.Owner.OwnerDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main
{

    private static final String URL = "jdbc:sqlserver://localhost;portNumber=1433;databaseName=dbHundePension";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "123456"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }
    public static void main(String[] args) throws Exception
    {

        System.out.println("Welcome to the Dog Daycare");
        Scanner scanner = new Scanner(System.in);
        String firstMenu = null;
        OwnerDao oDao = new OwnerDaoImpl();
        DogDao dDao = new DogDaoImpl();
        EventLogDao eDao = new EventLogDaoImpl();
        //EventTypeDao etDao = new EventTypeDaoImpl();

        secondMenu(scanner, oDao);
    }


    private static void secondMenu(Scanner scanner, OwnerDao oDao) throws Exception {
        System.out.printf("%nSelect one of the following options: %n");
        System.out.println("1. Read owner ");
        System.out.println("2. Read all owner ");
        System.out.println("3. Read dog ");
        System.out.println("4. Read all dogs ");
        System.out.println("5. Read eventLog ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.print("Enter owner ID to read: ");
                int readId = scanner.nextInt();
                OwnerDao owner = new OwnerDaoImpl();
                owner.readOwner(readId);
                break;

            case 2:
                OwnerDao allOwners = new OwnerDaoImpl();
                allOwners.readAllOwners();
                break;

            case 3:
                System.out.print("Enter dog ID to read: ");
                int readId2 = scanner.nextInt();
                DogDao dog = new DogDaoImpl();
                dog.readDog(readId2);
                break;

            case 4:
                DogDao allDogs = new DogDaoImpl();
                allDogs.readAllDogs();
                break;

            /*case 5:
                System.out.print("Enter eventLog ID to read: ");
                int readId3 = scanner.nextInt();
                EventLogDao eventLog = new EventLogDaoImpl();
                eventLog.readEventLog(readId3);
                break;

             */
            default:
                break;
        }
    }
}


