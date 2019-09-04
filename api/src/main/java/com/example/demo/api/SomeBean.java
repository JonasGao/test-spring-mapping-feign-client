package com.example.demo.api;

import java.util.Date;

public class SomeBean {
    private Date dateField;

    @Override
    public String toString() {
        return "SomeBean{" +
                "dateField=" + dateField +
                '}';
    }

    public Date getDateField() {
        return dateField;
    }

    public void setDateField(Date dateField) {
        this.dateField = dateField;
    }
}
