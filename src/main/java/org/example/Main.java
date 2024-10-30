package org.example;
import org.example.EventLog.EventLog;
import org.example.EventLog.EventLogDao;
import org.example.EventLog.EventlogDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main
{
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


    public static void main(String args []) throws Exception{
        System.out.println("start");
        //Connection conn = getConnection();


        EventLogDao dao = new EventlogDaoImpl(); //Den her connector også og så er der ikke behov for ovenstående connection.

        dao.readEventLog("");

        EventLog eventLog = new EventLog("","","");
        dao.createEventLog(eventLog);

        dao.readAllEventLogs();

        System.out.println("slut");
    }
}
