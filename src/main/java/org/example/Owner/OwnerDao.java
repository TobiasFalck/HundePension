package org.example.Owner;

public interface OwnerDao {
    void readOwner(String no) throws Exception;
    void readAllOwners() throws Exception;
    void createOwner(Owner owner) throws Exception;
}
