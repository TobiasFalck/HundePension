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
        signUp();
    }

    private static void startMenu()
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
                    break;

                case "new":
                    System.out.println("Welcome! Let's create a new Owner profile");
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
