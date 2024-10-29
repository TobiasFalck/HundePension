package org.example.Dog;

import java.util.Date;

public class Dog
{
    private String name;
    private String breed;
    private Date birthday;


    public Dog(String name, String breed, Date birthday)
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

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }
}
