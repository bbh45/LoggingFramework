package com.bb.loggers;

import com.bb.LoggerTarget;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(LoggingLevel level){
        this.loggingLevel = level;
    }
    @Override
    protected void displayLog(String msg, LoggerTarget loggerTarget) {
        loggerTarget.notifyAllObservers(LoggingLevel.ERROR, "ERROR: "+ msg);
    }
}
