package com.bb.logobservers;

public class FileLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("Writing to file :"+message);
    }
}
