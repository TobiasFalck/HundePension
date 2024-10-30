package org.example.EventLog;

import java.sql.*;

public class EventlogDaoImpl implements EventLogDao {

    private static final String URL = "jdbc:sqlserver://localhost;instanceName=Naja;portNumber=1433;databaseName=sample";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "9876"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    @Override //Annotering, noget man tilføjer man overstyrer ovenstående
    public void createEventlog(Eventlog eventlog) throws Exception {
        String sql = "INSERT INTO Eventlog VALUES (?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, eventlog.getDescription());
        pstmt.setString(2, eventlog.getHealth());
        //pstmt.setString(3, eventlog.getLocation());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Eventlog added successfully.");
        } else {
            System.out.println("Failed to add the department.");
        }
    }

    @Override
    public void readEventlog(String no) throws Exception{
        String sql = "SELECT * FROM Eventlog WHERE dept_no = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Eventlog eventlog = new Eventlog();
            eventlog.setDescription(rs.getString(1));
            eventlog.setHealth(rs.getString(2));
            //department.setLocation(rs.getString(3));
            System.out.println(eventlog.getDescription() + " "+ eventlog.getHealth()+ " ");
        } else {
            System.out.println("No eventlog found with ID: " + no);
        }
    }

    @Override
    public void readAllEventlogs() throws Exception{
        String sql = "SELECT * FROM Eventlog";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasEventlogs = false; //Skal vi have en Boolean her
        while (rs.next()) {
            hasEventlogs = true;
            EventLog eventLog = new EventLog();
            EventLog.setDescription(rs.getString(1));
            EventLog.setHealth(rs.getString(2));
            //department.setLocation(rs.getString(3));
            System.out.println(eventLog.getDescription()+" "+ eventLog.getHealth());
        }
        if (!hasEventlogs) {
            System.out.println("No eventlogs found.");
        }
    }
}


