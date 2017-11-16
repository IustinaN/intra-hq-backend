package com.example.events;

import java.util.Date;

public class Event {

    private EventType type;

    private Date lastUpdatedDate;

    private String payload;

    public Event() {
    }

    public Event(EventType type, Date lastUpdatedDate, String payload) {
        this.type = type;
        this.lastUpdatedDate = lastUpdatedDate;
        this.payload = payload;
    }

    public EventType getType() {
        return type;
    }

    public String getPayload() {
        return payload;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return String.format("Event[type='%s', lastUpdatedDate='%s', payload='%s']",
               type, lastUpdatedDate, payload);
    }
}
