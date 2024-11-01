package org.example;

import org.example.Dog.Dog;
import org.example.Dog.DogDao;
import org.example.Dog.DogDaoImpl;
import org.example.Owner.Owner;
import org.example.Owner.OwnerDao;
import org.example.Owner.OwnerDaoImpl;
import org.example.Stay.Stay;
import org.example.Stay.StayDao;
import org.example.Stay.StayDaoImpl;

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
                    System.out.println("Welcome back!");
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
                    crudMenuForDog();
                    break;

                case 3:
                    System.out.println("You Selected Stay");
                    crudMenuForStay();
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
        Owner owner = new Owner();

        String action = scanner.nextLine().trim().toLowerCase();

        switch (action) {
            case "create":
                createOwner();
                break;
            case "read":
                readOwner();
                break;
            case "readall":
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

    private static void crudMenuForDog() throws Exception
    {
        System.out.println("CRUD Operations for Dog");
        System.out.println("Choose an action: Create, Read, Update, Delete");
        DogDao dDao = new DogDaoImpl();

        String action = scanner.nextLine().trim().toLowerCase();

        switch (action) {
            case "create":
                createDog();
                break;
            case "read":
                readDog();
                break;
            case "readall":
                dDao.readAllDogs();
                break;
            default:
                System.out.println("Invalid action. Please choose Create, Read, Update, or Delete.");
        }
    }

    private static void createDog() throws Exception
    {
        System.out.println("Let's create a Dog");
        System.out.println("Please enter a Name:");
        String name = scanner.nextLine();
        System.out.println("Please enter a Breed:");
        String breed = scanner.nextLine();
        System.out.println("Please enter a date of Birth:");
        String birthday = scanner.nextLine();
        System.out.println("Please assign a owner ID to the dog:");
        int ownerId = scanner.nextInt();

        Dog dog = new Dog(name, breed, birthday, ownerId);
        DogDao dDao = new DogDaoImpl();
        dDao.createDog(dog);
        dDao.readAllDogs();
    }

    private static void readDog() throws Exception
    {
        System.out.print("Enter Dog ID to read: ");
        int dogId = scanner.nextInt();
        scanner.nextLine();
        DogDao dDao = new DogDaoImpl();
        dDao.readDog(dogId);
    }

    private static void crudMenuForStay() throws Exception
    {
        System.out.println("CRUD Operations for Stay");
        System.out.println("Choose an action: Create, Read, Update, Delete");
        StayDaoImpl sDao = new StayDaoImpl();

        String action = scanner.nextLine().trim().toLowerCase();
        switch (action) {
            case "create":
                createStay();
                break;
            case "read":
                readStay();
                break;
            case "readall":
                sDao.readAllStay();
                break;
            default:
                System.out.println("Invalid action. Please choose Create, Read, Update, or Delete.");
        }
    }

    private static void createStay() throws Exception
    {
        System.out.println("Let's create a Stay");
        System.out.println("Please enter a if they have gotten their vaccine (y/n): ");
        String vaccine = scanner.nextLine();
        System.out.println("Please enter a if they have gotten their flea treatment (y/n): ");
        String fleaTreatment = scanner.nextLine();
        System.out.print("Please enter a if they have gotten their vaccine (y/n): ");
        String insurence = scanner.nextLine();
        System.out.println("Please enter Weight in KG: ");
        int weight = scanner.nextInt();
        System.out.println("Please enter the dogs special needs if it has any (max 200 characters): ");
        String need = scanner.nextLine();
        System.out.println("Please enter the length of the stay in days: ");
        int duration = scanner.nextInt();
        System.out.println("Please assign a dogId: ");
        int dogId = scanner.nextInt();

        Stay stay = new Stay(vaccine, fleaTreatment, insurence, need, weight, duration, dogId);
        StayDao sDao = new StayDaoImpl();
        sDao.createStay(stay);
        sDao.readAllStay();
    }

    private static void readStay() throws Exception
    {
        System.out.print("Enter Stay ID to read: ");
        int stayId = scanner.nextInt();
        scanner.nextLine();
        StayDao sDao = new StayDaoImpl();
        sDao.readStay(String.valueOf(stayId));
    }











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
