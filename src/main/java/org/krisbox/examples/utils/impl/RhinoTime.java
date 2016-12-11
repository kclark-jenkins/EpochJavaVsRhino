package org.krisbox.examples.utils.impl;

import org.krisbox.examples.utils.TimeConversion;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import java.text.SimpleDateFormat;

public class RhinoTime implements TimeConversion {
    private long   epoch;
    private String dateformat;
    private String stringTime;
    private String jsCmd = "function epochToString(epoch){"
                         + "  var fromEpoch = new Date(epoch);"
                         + "  var strDate   = fromEpoch.getFullYear() + '-' + (fromEpoch.getMonth()+1) + '-' + fromEpoch.getDate();"
                         + "  var strTime   = fromEpoch.getHours() + ':' + fromEpoch.getMinutes() + ':' + fromEpoch.getSeconds() + '.' + fromEpoch.getMilliseconds();"
                         + "  return strDate + ' ' + strTime;"
                         + "}";


    public RhinoTime(long epoch, String dateformat) {
        this.epoch = epoch;
        this.dateformat = new String(dateformat);
        stringTime      = new String();
    }

    public String getDatetime() {
        return (String)doScript(epoch);
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

    private Object doScript(long epoch) {
        Context cx = Context.enter();

        try {
            Scriptable scope = cx.initStandardObjects();

            // Now evaluate the string we've collected. We'll ignore the result.
            cx.evaluateString(scope, jsCmd, "<cmd>", 1, null);

            // Call function "f('my arg')" and print its result.
            Object fObj = scope.get("epochToString", scope);
            if (!(fObj instanceof Function)) {
                System.out.println("epochToString is undefined or not a function.");
            } else {
                Object functionArgs[] = { epoch };
                Function f = (Function)fObj;
                Object result = f.call(cx, scope, scope, functionArgs);

                return Context.toString(result);
            }
        }finally {
            cx.exit();
        }

        return null;
    }
}
