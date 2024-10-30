package org.example.Dog;

import java.sql.*;

public class DogDaoImpl implements DogDao {

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
    public void createDog(Dog dog) throws Exception {
        String sql = "INSERT INTO tblHundeOpl VALUES (?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(2, dog.getBreed());
        pstmt.setString(1, dog.getName());
        pstmt.setString(3, dog.getBirthday());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Dog added successfully.");
        } else {
            System.out.println("Failed to add the dog.");
        }
    }

    @Override
    public void readDog(int no) throws Exception{
        String sql = "SELECT * FROM tblHundeOpl WHERE fldHundeId = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, no);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Dog dog = new Dog();
            dog.setBreed(rs.getString(2));
            dog.setName(rs.getString(1));
            dog.setBirthday(rs.getString(3));
            System.out.println(dog.getBreed() + " "+ dog.getName()+ " "+ dog.getBirthday());
        } else {
            System.out.println("No department found with ID: " + no);
        }
    }

    @Override
    public void readAllDogs() throws Exception{
        String sql = "SELECT * FROM Department";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDogs = false;
        while (rs.next()) {
            hasDogs = true;
            Dog dog = new Dog();
            dog.setBreed(rs.getString(2));
            dog.setName(rs.getString(1));
            dog.setBirthday(rs.getString(3));
            System.out.println(dog.getBreed()+" "+ dog.getName()+dog.getBirthday());
        }
        if (!hasDogs) {
            System.out.println("No dogs found.");
        }
    }
}

