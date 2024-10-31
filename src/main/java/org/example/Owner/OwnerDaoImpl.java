package org.example.Owner;

import org.example.Dog.Dog;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OwnerDaoImpl implements OwnerDao
{
    private static final String URL = "jdbc:sqlserver://localhost;instanceName=TH;portNumber=1433;databaseName=dbHundePension";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "123456"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    @Override
    public void createOwner(Owner owner) throws Exception {
        String sql = "INSERT INTO tblEjer (fldNavn, fldTlfNr, fldAdresse, fldPostNr) VALUES (?, ?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, owner.getName());
        pstmt.setString(2, owner.getPhoneNumber());
        pstmt.setString(3, owner.getAddress());
        pstmt.setString(4, owner.getZipCode());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Owner added successfully.");
        } else {
            System.out.println("Failed to add the owner.");
        }
    }

    @Override
    public void readOwner(int no) throws Exception{
        String sql = "SELECT * FROM tblEjer WHERE fldEjerId = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, no);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Owner owner = new Owner();
            owner.setName(rs.getString(1));
            owner.setPhoneNumber(rs.getString(2));
            owner.setAddress(rs.getString(3));
            owner.setZipCode(rs.getString(4));
            System.out.println(owner.getName() + " "+ owner.getPhoneNumber()+ " "+ owner.getAddress()+ " "+ owner.getZipCode());
        } else {
            System.out.println("No Owner found with ID: " + no);
        }
    }

    @Override
    public void readAllOwners() throws Exception{
        String sql = "SELECT * FROM tblEjer";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasOwners = false;
        while (rs.next()) {
            hasOwners = true;
            Owner owner = new Owner();
            owner.setName(rs.getString(1));
            owner.setPhoneNumber(rs.getString(2));
            owner.setAddress(rs.getString(3));
            owner.setZipCode(rs.getString(4));
            System.out.println(owner.getName() + " "+ owner.getPhoneNumber()+ " "+ owner.getAddress()+ " "+ owner.getZipCode());
        }
        if (!hasOwners) {
            System.out.println("No owners found.");
        }
    }
}

