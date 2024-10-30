package org.example.Dog;

import java.util.Date;

public class Dog
{
    private String name;
    private String breed;
    private String birthday;



    public Dog(String name, String breed, String birthday)
    {
        this.name = name;
        this.breed = breed;
        this.birthday = birthday;
    }

    public Dog()
    {
        // What doing - Er den overhovedet relevant
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBreed()
    {
        return breed;
    }

    public void setBreed(String breed)
    {
        this.breed = breed;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }
}
