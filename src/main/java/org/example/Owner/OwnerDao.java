package org.example.Owner;

public interface OwnerDao {
    void readOwner(int no) throws Exception;
    void readAllOwners() throws Exception;
    void createOwner(Owner owner) throws Exception;
    boolean ownerExists(int ownerId) throws Exception;
}
