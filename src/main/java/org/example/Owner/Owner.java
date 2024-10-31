package org.example.Owner;

public class Owner {
    private Integer ownerId;
    private String name;
    private String phoneNumber;
    private String address;
    private String zipCode;

    public Owner(String name, String phoneNumber, String address, String zipcode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipCode = zipcode;
    }

    public Owner(int ownerId, String name, String phoneNumber, String address, String zipCode)
    {
        this.ownerId = ownerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipCode = zipCode;

    }
    public Owner()
    {

    }

    public Integer getOwnerId()
    {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId)
    {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }
}
