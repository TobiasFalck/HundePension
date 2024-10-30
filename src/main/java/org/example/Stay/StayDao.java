package org.example.Stay;

public interface StayDao
{
    void readStay(String no) throws Exception;
    void readAllStay() throws Exception;
    void createStay(Stay stay) throws Exception;
}
