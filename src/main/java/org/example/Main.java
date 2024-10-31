package org.example;

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

import java.util.Scanner;

public class Main
{
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
        System.out.println("%nSelect one of the following options: ");
        System.out.println("1. Owner ");
        System.out.println("2. Dog ");
        System.out.println("3. EventLog ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.print("Enter owner ID to read: ");
                int readId = scanner.nextInt();
                Owner owner = oDao.readOwner(1);
                if (owner != null) {
                    System.out.println("owner found: " + owner);
                    ownerChosen(scanner, owner);
                    break
                } else {
                    System.out.println("owner not found");
                }
                break;
            case 2:
                System.out.print("Enter dog ID to read: ");
                int readId = scanner.nextInt();
                Dog dog = dDao.read(readId);
                if (dog != null) {
                    System.out.println("dog found: " + dog);
                } else {
                    System.out.println("dog not found");
                }
                break;
        }
    }
    private static void ownerChosen(Scanner scanner, Owner owner)
    {


    }
}

