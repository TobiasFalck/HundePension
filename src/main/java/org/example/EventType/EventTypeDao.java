package org.example.EventType;


public interface EventTypeDao
{
        void readEventType(String no) throws Exception;
        void readAllEventType() throws Exception;
        void createEventType(EventType eventType) throws Exception;
}
