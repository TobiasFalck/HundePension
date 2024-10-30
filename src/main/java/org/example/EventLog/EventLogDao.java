package org.example.EventLog;

public interface EventLogDao {
    void readEventLog(String no) throws Exception;
    void readAllEventLogs() throws Exception;
    void createEventLog(EventLog eventLog) throws Exception;
}
