package org.example.EventLog;

import java.sql.*;

public class EventLogDaoImpl implements EventLogDao {

    private static final String URL = "jdbc:sqlserver://localhost;portNumber=1433;databaseName=dbHundePension";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "123456"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    @Override //Annotering, noget man tilføjer man overstyrer ovenstående
    public void createEventLog(EventLog eventlog) throws Exception {
        String sql = "INSERT INTO tblHaendelsesLog VALUES (?, ?, ?)";
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
    public void readEventLog(String no) throws Exception{
        String sql = "SELECT * FROM tblHaendelsesLog WHERE fldHaendelseId = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            EventLog eventlog = new EventLog();
            eventlog.setDescription(rs.getString(1));
            eventlog.setHealth(rs.getString(2));
            //department.setLocation(rs.getString(3));
            System.out.println(eventlog.getDescription() + " "+ eventlog.getHealth()+ " ");
        } else {
            System.out.println("No eventlog found with ID: " + no);
        }
    }

    @Override
    public void readAllEventLogs() throws Exception{
        String sql = "SELECT * FROM tblHaendelsesLog";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasEventlogs = false; //Skal vi have en Boolean her
        while (rs.next()) {
            hasEventlogs = true;
            EventLog eventLog = new EventLog();
            eventLog.setDescription(rs.getString(1));
            eventLog.setHealth(rs.getString(2));
            //department.setLocation(rs.getString(3));
            System.out.println(eventLog.getDescription()+" "+ eventLog.getHealth());
        }
        if (!hasEventlogs) {
            System.out.println("No eventlogs found.");
        }
    }
}


