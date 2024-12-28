package com.bb;

import com.bb.loggers.*;
import com.bb.logobservers.ConsoleLogger;
import com.bb.logobservers.DatabaseLogger;
import com.bb.logobservers.FileLogger;
import com.bb.logobservers.LogObserver;

public class LogManager {
    public static AbstractLogger doChaining(){

        AbstractLogger infoLogger = new InfoLogger(LoggingLevel.INFO);
        AbstractLogger errorLogger = new ErrorLogger(LoggingLevel.ERROR);
        AbstractLogger debugLogger = new DebugLogger(LoggingLevel.DEBUG);

        infoLogger.setNextLevelLogger(errorLogger);
        errorLogger.setNextLevelLogger(debugLogger);

        return infoLogger;
    }

    public static LoggerTarget addObservers(){
        LoggerTarget loggerTarget = new LoggerTarget();

        LogObserver consoleLogger = new ConsoleLogger();
        loggerTarget.addObserver(LoggingLevel.INFO, consoleLogger);
        loggerTarget.addObserver(LoggingLevel.DEBUG, consoleLogger);
        loggerTarget.addObserver(LoggingLevel.ERROR, consoleLogger);

        LogObserver fileLogger = new FileLogger();
        loggerTarget.addObserver(LoggingLevel.ERROR, fileLogger);

        DatabaseLogger databaseLogger = new DatabaseLogger();
        loggerTarget.addObserver(LoggingLevel.DEBUG, databaseLogger);

        return  loggerTarget;

    }
}
