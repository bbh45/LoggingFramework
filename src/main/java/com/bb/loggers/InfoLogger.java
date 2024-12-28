package com.bb.loggers;

import com.bb.LoggerTarget;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(LoggingLevel level){
        this.loggingLevel = level;
    }
    @Override
    protected void displayLog(String msg, LoggerTarget loggerTarget) {
        loggerTarget.notifyAllObservers(LoggingLevel.INFO, "INFO: "+ msg);
    }
}
