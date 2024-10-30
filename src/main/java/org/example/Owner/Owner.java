package org.example.Owner;

public class Owner {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private String zipcode;

    public Owner(String name, String phoneNumber, String address, String zipcode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipcode = zipcode;
    }
    public Owner() {
        //What doing?
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
