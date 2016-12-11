package org.krisbox.examples.utils.impl;

import org.krisbox.examples.utils.CompareDates;
import org.krisbox.examples.utils.TimeConversion;

import java.text.SimpleDateFormat;

public class JavaTime implements TimeConversion {
    private long   epoch;
    private String dateformat;
    private String stringTime;

    public JavaTime(long epoch, String dateformat) {
        this.epoch = epoch;
        this.dateformat   = new String(dateformat);
        stringTime        = new String();
    }

    public String getDatetime() {
        return doJavaTimeConversion(epoch, dateformat);
    }

    public long getEpoch() {
        return epoch;
    }

    public String getDateFormat() {
        return dateformat;
    }

    public void setEpoch(long epoch) {
        this.epoch = epoch;
    }

    public void setDateformat(String dateformat) {
        this.dateformat = dateformat;
    }

    public void setJavaTime(String stringTime) {
        this.stringTime = stringTime;
    }

    public String getStringTime() {
        return doJavaTimeConversion(epoch, dateformat);
    }

    public String getStringTime(long epoch, String dateformat) {
        return doJavaTimeConversion(epoch, dateformat);
    }

    public long getEpochTime() {
        return epoch;
    }

    public String getTimeFormat() {
        return dateformat;
    }

    private String doJavaTimeConversion(long timestamp, String dateformat) {
        try {
            return new SimpleDateFormat(dateformat).format(timestamp);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    private long doEpochTimeConversion(String stringTime, String dateformat) {
        return 0;
    }
}
