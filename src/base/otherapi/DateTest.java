package base.otherapi;

import java.text.*;
import java.util.Date;
import java.util.Locale;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        System.out.println(date);

        date.getTime();


        Date date1 = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance();
        String dateStr = dateFormat.format(date1);
        DateFormat dateFormat1 = DateFormat.getDateTimeInstance();
        String timeStr = dateFormat1.format(date1);
        System.out.println(dateStr + " " + timeStr);


        System.out.println("===========================");
        Date myDate = new Date();
        DateFormat myDataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = myDataFormat.format(myDate);
        System.out.println(str);


        System.out.println("===========================");
        String str_date = "2019-2-2";
//        DateFormat dateFormat2=DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = dateFormat2.parse(str_date);
        System.out.println(date2);


    }
}
