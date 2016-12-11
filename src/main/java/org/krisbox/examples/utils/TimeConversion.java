package org.krisbox.examples.utils;

public interface TimeConversion {
    String getDatetime();
    long   getEpoch();
    String getTimeFormat();
    void   setEpoch(long epoch);
    void   setDateformat(String dateformat);
    void   setJavaTime(String javaTime);
    String getStringTime();
    String getStringTime(long epoch, String dateformat);
    long   getEpochTime();
}
