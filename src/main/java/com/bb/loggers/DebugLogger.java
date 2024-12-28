package com.bb.loggers;

import com.bb.LoggerTarget;

public class DebugLogger extends AbstractLogger {

    public DebugLogger(LoggingLevel level){
        this.loggingLevel = level;
    }
    @Override
    protected void displayLog(String msg, LoggerTarget loggerTarget) {
        loggerTarget.notifyAllObservers(LoggingLevel.DEBUG, "DEBUG: "+ msg);
    }
}
