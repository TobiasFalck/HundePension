package org.example;

import org.example.Dog.Dog;
import org.example.Dog.DogDao;
import org.example.Dog.DogDaoImpl;
import org.example.Stay.Stay;
import org.example.Stay.StayDao;
import org.example.Stay.StayDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main
{


    public static void main(String[] args) throws Exception
    {
    System.out.println("start");

    DogDao dao = new DogDaoImpl();

    dao.readDog(1);

    Dog d = new Dog("Thunder","Labrador Retriever","2019-10-15");
    dao.createDog(d);

    dao.readAllDogs();

    System.out.println("slut");
    }
}