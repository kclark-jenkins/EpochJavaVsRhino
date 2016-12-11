package org.krisbox.examples;

import org.krisbox.examples.utils.CompareDates;

public class EpochTime {
    public EpochTime(long epoch, String dateformat) {
        CompareDates compare = new CompareDates(epoch, dateformat);
        boolean compareResult = compare.compare();

        if(compareResult) {
            System.out.println("Java and Rhino match.");
        }else{
            System.out.println("Java and Rhino do not match.");
        }
    }

    public static void main(String[] args) {
        new EpochTime(1481489586705L, "yyyy-MM-dd HH:mm:s.SSS");
    }
}
