package com.bb.loggers;

import com.bb.LoggerTarget;

public abstract class AbstractLogger {
    protected LoggingLevel loggingLevel;
    private AbstractLogger nextLevelLogger;
    public void setNextLevelLogger(AbstractLogger nextLevelLogger){
        this.nextLevelLogger = nextLevelLogger;
    }

    public void logMessage(LoggingLevel level, String message, LoggerTarget loggerTarget){
        if(loggingLevel.ordinal() <= level.ordinal()){
            displayLog(message, loggerTarget);
        }
        if(nextLevelLogger != null){
            nextLevelLogger.logMessage(level, message, loggerTarget);
        }
    }

    protected abstract void displayLog(String msg, LoggerTarget loggerTarget);

}
