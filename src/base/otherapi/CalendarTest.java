package base.otherapi;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args){
        Calendar calendar=Calendar.getInstance();
        Date date = calendar.getTime();
        System.out.println(date);
        System.out.println(calendar.get(Calendar.MONTH));
    }
}
