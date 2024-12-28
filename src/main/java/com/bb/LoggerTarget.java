package com.bb;

import com.bb.loggers.LoggingLevel;
import com.bb.logobservers.LogObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoggerTarget {
    private HashMap<LoggingLevel, List<LogObserver>> logObservers = new HashMap<LoggingLevel, List<LogObserver>>();

    public void addObserver(LoggingLevel level, LogObserver logObserver){
        List<LogObserver> loggers = logObservers.getOrDefault(level, new ArrayList<>());
        loggers.add(logObserver);
        logObservers.put(level, loggers);
    }

    public void removeObserver(LoggingLevel level, LogObserver logObserver){
        List<LogObserver> loggers = logObservers.getOrDefault(level, new ArrayList<>());
        loggers.remove(logObserver);
        logObservers.put(level, loggers);
    }

    public void notifyAllObservers(LoggingLevel level, String message){
        List<LogObserver> loggers = logObservers.getOrDefault(level, new ArrayList<>());
        for(LogObserver observer: loggers){
            observer.log(message);
        }
    }
}
