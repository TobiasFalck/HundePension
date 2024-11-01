package org.example.Stay;

import java.sql.*;

public class StayDaoImpl implements StayDao {

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
    public void createStay(Stay stay) throws Exception {
        String sql = "INSERT INTO tblLavOphold (fldVaccine, fldLoppeBehandling, fldForsikring, fldBehov, fldVægt, fldVarighed, fldHundeId) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, stay.getVaccine());
        pstmt.setString(2, stay.getFleaTreatment());
        pstmt.setString(3, stay.getInsurance());
        pstmt.setString(4, stay.getNeed());
        pstmt.setInt(5, stay.getWeight());
        pstmt.setInt(6, stay.getDuration());
        pstmt.setInt(7, stay.getDogId());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Stay added successfully.");
        } else {
            System.out.println("Failed to add the Stay.");
        }
    }

    @Override
    public void readStay(int no) throws Exception{
        String sql = "SELECT * FROM tblLavOphold WHERE fldOpholdsId = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, no);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Stay stay = new Stay();
            stay.setVaccine(rs.getString(2));
            stay.setFleaTreatment(rs.getString(3));
            stay.setInsurance(rs.getString(4));
            stay.setNeed(rs.getString(6));
            stay.setWeight(rs.getInt(5));
            stay.setDuration(rs.getInt(9));
            stay.setDogId(rs.getInt(7));
            System.out.println(stay.getVaccine() + " "+ stay.getFleaTreatment() + " "+ stay.getInsurance()+ " "+ stay.getNeed() + " "+ stay.getWeight() + " "+ stay.getDuration() + " "+ stay.getVaccine());
        } else {
            System.out.println("No Stay found with ID: " + no);
        }
    }

    @Override
    public void readAllStay() throws Exception{
        String sql = "SELECT * FROM tblLavOphold";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasStay = false;
        while (rs.next()) {
            hasStay = true;
            Stay stay = new Stay();
            stay.setVaccine(rs.getString(2));
            stay.setFleaTreatment(rs.getString(3));
            stay.setInsurance(rs.getString(4));
            stay.setNeed(rs.getString(6));
            stay.setWeight(rs.getInt(5));
            stay.setDuration(rs.getInt(9));
            stay.setDogId(rs.getInt(7));
            System.out.println(stay.getVaccine()+" "+ stay.getFleaTreatment()+stay.getInsurance()+" "+ stay.getNeed()+" "+ stay.getWeight()+" "+ stay.getDuration()+" "+ stay.getDuration());
        }
        if (!hasStay) {
            System.out.println("No Stay found.");
        }
    }
}