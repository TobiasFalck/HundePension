package org.example.City;


public interface CityDao {
    void readCity(String no) throws Exception;
    void readAllCities() throws Exception;
    void createCity(City city) throws Exception;
}
