package org.krisbox.examples.utils;

import org.krisbox.examples.utils.impl.JavaTime;
import org.krisbox.examples.utils.impl.RhinoTime;

import java.sql.Time;

public class CompareDates {
    private TimeConversion rhino;
    private TimeConversion java;

    public CompareDates() {
    }

    public CompareDates(long epoch, String timeformat) {
        rhino = new RhinoTime(epoch, timeformat);
        java  = new JavaTime(epoch, timeformat);
    }

    public boolean compare() {
        try {
            doCompare(this.rhino, this.java);
            return true;
        }catch(CompareDatesException ex){
            ex.printStackTrace();
            return false;
        }
    }

    public boolean compare(TimeConversion rhino, TimeConversion java) {
        try {
            doCompare(rhino, java);
            return true;
        }catch(CompareDatesException ex){
            ex.printStackTrace();
            return false;
        }
    }

    private boolean doCompare(TimeConversion rhino, TimeConversion java) throws CompareDatesException {
        if(rhino.getDatetime().equals(java.getDatetime())){
            return true;
        }else{
            throwException(this.rhino, this.java);
            return false;
        }
    }

    private CompareDatesException throwException(TimeConversion rhino, TimeConversion java) throws CompareDatesException {
        throw new CompareDatesException("Java and Rhino have do not have the same results\n"
                +"RhinoTime == " + rhino.getDatetime() + "\n"
                +"JavaTime == " + rhino.getDatetime());
    }
}
