package base.otherapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePracticeTest {
    public static void main(String[] args) throws ParseException {
        String str_date1="2012-3-17";
        String str_date2="2012-4-17";
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse(str_date1);
        Date date2 = dateFormat.parse(str_date2);
        long l_date1=date1.getTime();
        long l_date2=date2.getTime();
        long time=Math.abs(l_date2-l_date1);
        System.out.println(time);
    }
}
