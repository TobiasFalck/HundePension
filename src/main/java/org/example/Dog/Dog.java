package org.example.Dog;



public class Dog
{
    private int dogId;
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

    public Dog(String name, String breed, String birthday, int ownerId)
    {
        this.name = name;
        this.breed = breed;
        this.birthday = birthday;
        this.ownerId = ownerId;

    }

    public int getDogId()
    {
        return dogId;
    }

    public void setDogId(int dogId)
    {
        this.dogId = dogId;
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
