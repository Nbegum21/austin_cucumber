package Utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String returnNextMonth() {
        // Creating Date object
        Date dNow = new Date();

        // Creating Calender object for gregorian calender
        Calendar calender = new GregorianCalendar();

        // sSet Calender date to current date
        calender.setTime(dNow);

        // Create object of simpleDateFormats
        // Defining date object to- example: (dec-2021)
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-YYY");

        // Incrementing the current month
        calender.add(calender.MONTH,1);

        // Generating the date based on the specified format
        String date = sdf.format(calender.getTime());

        return date;
    }
}
