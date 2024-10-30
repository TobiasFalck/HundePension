package org.example.City;

public class City {
    private String zipcode;
    private String city;

    public City(String zipcode, String city) {
        this.zipcode = zipcode;
        this.city = city;
    }
    public City() {
        //What doing?
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
