package com.bb.logobservers;

public class DatabaseLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("Writing to Database :"+message);
    }
}
