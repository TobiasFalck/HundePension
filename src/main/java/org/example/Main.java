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
    private static boolean exit = false;
    private static Owner currentOwner = null;


    public static void main(String[] args) throws Exception
    {
        System.out.println("Welcome to the Dog Daycare");

        String firstMenu = null;
        OwnerDao oDao = new OwnerDaoImpl();
        DogDao dDao = new DogDaoImpl();


        checkUserStatus(oDao);



        while(!exit)
        {
            private static void checkUserStatus(OwnerDao oDao)
            {
                boolean isUserValid = false;

                while(!isUserValid){
                    System.out.println("Are you an existing Owner? (yes/no)");
                    String userResponse = scanner.nextLine();

                    switch(userResponse)
                    {
                        case "yes":
                            isUserValid = true;
                            break;

                        case "no":
                            isUserValid = false;
                            break;

                        default:
                            System.out.println("please try again");
                    }

                }
            }

            private static boolean validateOwner(OwnerDao oDao)
            System.out.println("Pleaser Enter your ID: ");
            int ownerId = Integer.parseInt(scanner.nextLine());

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
}