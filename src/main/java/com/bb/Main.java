package com.bb;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger();
        logger.info("This is info message");
        System.out.println("----------");
        logger.error("This is error message");
        System.out.println("----------");
        logger.debug("This is debug message");
    }
}