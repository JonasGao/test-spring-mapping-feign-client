package com.example.demo.api;

public class SomeBody {
    @Override
    public String toString() {
        return "SomeBody{" +
                "description='" + description + '\'' +
                '}';
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
