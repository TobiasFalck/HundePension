package org.example.Dog;



public class Dog
{
    private String name;
    private String breed;
    private String birthday;
    private int ownerId;


    public Dog(String name, String breed, String birthday)
    {
        this.name = name;
        this.breed = breed;
        this.birthday = birthday;
    }

    public Dog()
    {

    }

    public int getOwnerId()
    {
        return ownerId;
    }

    public void setOwnerId(int ownerId)
    {
        this.ownerId = ownerId;
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
