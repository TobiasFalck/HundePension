package org.example.Dog;

import java.sql.*;

public class DogDaoImpl implements DogDao {

    private static final String URL = "jdbc:sqlserver://localhost;instanceName=TH;portNumber=1433;databaseName=sample";
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
        pstmt.setString(1, dog.getBreed());
        pstmt.setString(2, dog.getName());
        pstmt.setString(3, dog.getBirthday().toString());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Dog added successfully.");
        } else {
            System.out.println("Failed to add the dog.");
        }
    }

    @Override
    public void readDog(String no) throws Exception{
        String sql = "SELECT * FROM tblHundeOpl WHERE fldHundeId = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Dog dog = new Dog();
            dog.getBreed(rs.getString(1));
            department.setName(rs.getString(2));
            department.setLocation(rs.getString(3));
            System.out.println(department.getNo() + " "+ department.getName()+ " "+ department.getLocation());
        } else {
            System.out.println("No department found with ID: " + no);
        }
    }

    @Override
    public void readAllDepartments() throws Exception{
        String sql = "SELECT * FROM Department";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDepartments = false;
        while (rs.next()) {
            hasDepartments = true;
            Department department = new Department();
            department.setNo(rs.getString(1));
            department.setName(rs.getString(2));
            department.setLocation(rs.getString(3));
            System.out.println(department.getNo()+" "+ department.getName()+department.getLocation());
        }
        if (!hasDepartments) {
            System.out.println("No departments found.");
        }
    }
}

