package com.bb.logobservers;

public class ConsoleLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("Writing to console :"+message);
    }
}
