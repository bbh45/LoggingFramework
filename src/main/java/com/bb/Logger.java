package com.bb;

import com.bb.loggers.AbstractLogger;
import com.bb.loggers.LoggingLevel;

public class Logger {
    private static Logger logger;
    private static AbstractLogger chainOfLogger;
    private static LoggerTarget loggerTarget;
    private Logger(){
        if(logger != null)
            throw new IllegalStateException("Object already exists");
    }

    public static Logger getLogger(){
        if(logger == null){
            synchronized (Logger.class){
                if(logger == null){
                    logger = new Logger();
                    chainOfLogger = LogManager.doChaining();
                    loggerTarget = LogManager.addObservers();
                }
            }
        }
        return logger;
    }

    public void info(String message){
        createLog(LoggingLevel.INFO, message);
    }

    public void error(String message){
        createLog(LoggingLevel.ERROR, message);
    }

    public void debug(String message){
        createLog(LoggingLevel.DEBUG, message);
    }

    private void createLog(LoggingLevel level, String message){
        chainOfLogger.logMessage(level, message, loggerTarget);
    }
}
