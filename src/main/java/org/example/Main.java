package org.example;

import org.example.Dog.DogDao;
import org.example.Dog.DogDaoImpl;
import org.example.Owner.Owner;
import org.example.Owner.OwnerDao;
import org.example.Owner.OwnerDaoImpl;

import java.util.Scanner;

public class Main
{

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception
    {
        startMenu();

    }

    private static void startMenu() throws Exception
    {
        System.out.println("Welcome to Dog Daycare");

        String userStatus = "";
        while(!userStatus.equals("existing") && !userStatus.equals("new"))
        {
            System.out.println("Are you a new or existing owner? (type 'existing' or 'new')");
            userStatus = scanner.nextLine();

            switch (userStatus)
            {
                case "existing":
                    System.out.println("Welcome back! Go and input your Id");
                    logIn();
                    break;

                case "new":
                    System.out.println("Welcome! Let's create a new Owner profile");
                    signUp();
                    break;

                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private static void signUp() throws Exception
    {
        System.out.println("Let's create the owner");
        System.out.println("Please enter a name:");
        String name = scanner.nextLine();
        System.out.println("Please enter a Phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please enter an address:");
        String address = scanner.nextLine();
        System.out.println("Please enter a zip code:");
        String zipCode = scanner.nextLine();

        Owner owner = new Owner(name, phoneNumber, address, zipCode);
        OwnerDao oDao = new OwnerDaoImpl();
        oDao.createOwner(owner);
        oDao.readAllOwners();

        secondMenu();

    }

    private static void logIn() throws Exception
    {
        OwnerDao oDao = new OwnerDaoImpl();
        System.out.println("Here is the list of owners:");
        oDao.readAllOwners();

        boolean validId = false;
        while (!validId) {
            System.out.println("Please enter a valid ID: ");

            if (scanner.hasNextInt()) {
                int ownerId = scanner.nextInt();
                scanner.nextLine();

                if (oDao.ownerExists(ownerId)) {
                    validId = true;
                    oDao.readOwner(ownerId);
                    System.out.println("Welcome backe!");
                    secondMenu();
                } else {
                    System.out.println("Invalid ID. No owner found with ID: " + ownerId);
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric ID.");
                scanner.nextLine();
            }
        }
    }

    private static void secondMenu() throws Exception
    {
        boolean exit = false;
        while (!exit)
        {
            System.out.println("In this Menu you can: Create - Read - Update - Delete Any of the following tables");
            System.out.println("Choose any of the following options:");
            System.out.println("1. Owner");
            System.out.println("2. Dog");
            System.out.println("3. Stay");
            System.out.println("4. EventLog");
            System.out.println("5. EventType");
            System.out.println("6. Food");
            System.out.println("7. City");
            System.out.println("8. Exit to the main menu");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option)
            {
                case 1:
                    System.out.println("You Selected Owner");
                    crudMenuForOwner();
                    break;

                case 2:
                    System.out.println("You Selected Dog");
                    break;

                case 3:
                    System.out.println("You Selected Stay");
                    break;

                case 4:
                    System.out.println("You Selected EventLog");
                    break;

                case 5:
                    System.out.println("You Selected EventType");
                    break;

                case 6:
                    System.out.println("You Selected Food");
                    break;

                case 7:
                    System.out.println("You Selected City");
                    break;

                case 8:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid input. Please enter a valid option.");
            }
        }
    }

    private static void crudMenuForOwner() throws Exception
    {
        System.out.println("CRUD Operations for Owner");
        System.out.println("Choose an action: Create, Read or Read all");
        OwnerDao oDao = new OwnerDaoImpl();
        Owner o = new Owner();

        String action = scanner.nextLine().trim().toLowerCase();

        switch (action) {
            case "create":
                createOwner();
                break;
            case "read":
                readOwner();
                break;
            case "readAll":
                oDao.readAllOwners();
                break;
            default:
                System.out.println("Invalid action. Please choose Create, Read or Read All.");
        }
    }

    private static void createOwner() throws Exception
    {
        System.out.println("Let's create the owner");
        System.out.println("Please enter a name:");
        String name = scanner.nextLine();
        System.out.println("Please enter a Phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please enter an address:");
        String address = scanner.nextLine();
        System.out.println("Please enter a zip code:");
        String zipCode = scanner.nextLine();

        Owner owner = new Owner(name, phoneNumber, address, zipCode);
        OwnerDao oDao = new OwnerDaoImpl();
        oDao.createOwner(owner);
        oDao.readAllOwners();


    }

    private static void readOwner() throws Exception
    {
        System.out.print("Enter Owner ID to read: ");
        int ownerId = scanner.nextInt();
        scanner.nextLine();
        OwnerDao oDao = new OwnerDaoImpl();
        oDao.readOwner(ownerId);
    }

    /*
    private static void crudMenuForDog() throws Exception {
        System.out.println("CRUD Operations for Dog");
        System.out.println("Choose an action: Create, Read, Update, Delete");

        String action = scanner.nextLine().trim().toLowerCase();

        switch (action) {
            case "create":
                createDog();
                break;
            case "read":
                readDog();
                break;
            case "update":
                updateDog();
                break;
            case "delete":
                deleteDog();
                break;
            default:
                System.out.println("Invalid action. Please choose Create, Read, Update, or Delete.");
        }
    }

     */












        /*
        OwnerDao oDao = new OwnerDaoImpl();
        oDao.readOwner(1);
        Owner o = new Owner("John Doe", "14439230", "Ringgade 5", "6400");
        oDao.createOwner(o);
        oDao.readAllOwners();


         */



     /*
    DogDao dDao = new DogDaoImpl();
    dDao.readDog(1);

    //Dog d = new Dog("Thunder","Labrador Retriever","2019-10-15");
    //dao.createDog(d);

    dDao.readAllDogs();



    System.out.println("slut");

      */
}
