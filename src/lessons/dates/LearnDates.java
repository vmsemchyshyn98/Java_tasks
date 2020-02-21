package lessons.dates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LearnDates {

    void getTimeZone(){

    }
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
/*
        ///date.setHours(12);

        TimeZone timeZone = TimeZone.getTimeZone("GMT+10"); //GMT,UTC
        Calendar calendar = Calendar.getInstance(timeZone);
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz yyyy");
       // UTC:     2019-02-14 19:08:04 GMT 2019
        simpleDateFormat.setTimeZone(timeZone);

        System.out.println("Time zone: " + timeZone.getID());
        System.out.println("default time zone: " + TimeZone.getDefault().getID());
        System.out.println();

        System.out.println("UTC:     " + simpleDateFormat.format(calendar.getTime()));
        System.out.println("Default: " + calendar.getTime());
        System.out.println(calendar.getTimeZone().getID());

//        System.out.println(date);
/*

        Date localDate1 = new Date();
        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeZone();
        System.out.println(calendar);

        calendar.set(2019, 1, 15);
        Date d = calendar.getTime();
        System.out.println(d);

        calendar.add(Calendar.MONTH, 1);
        Date d2 = calendar.getTime();
        System.out.println(d2);

        calendar.add(Calendar.MONTH, 3);
        calendar.add(Calendar.DATE, 10);
        Date d3 = calendar.getTime();

        System.out.println(d3);

//        System.out.println(calendar.getTime());
//        Date s1=calendar.getTime();
//
//        TimeZone q1=calendar.getTimeZone();
//        System.out.println("TimeZone: "+q1);
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
//
//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
//        System.out.println(simpleDateFormat.format(s1));
//
//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
//        System.out.println(simpleDateFormat.format(localDate1));
/*
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
      //  calendar.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));

        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println(simpleDateFormat.format("yyyy-MM-dd HH:mm:ssZ"));
        System.out.println();
        System.out.println(calendar.getTimeZone());

        System.out.println(calendar.getTime());
        System.out.println(calendar.getCalendarType());
      // calendar.set();

/*        LocalDateTime now = LocalDateTime.now();

        LocalDateTime days = now.minusDays(5);
        LocalDate localDate=LocalDate.now();
        System.out.println("localDate: "+localDate);

        now=now.minusDays(2);
        System.out.println(now);



        System.out.println(now);
        System.out.println(days);

        LocalDateTime zone = LocalDateTime.now(ZoneId.of("UTC"));
        LocalDateTime zone2 = LocalDateTime.now(ZoneId.of("GMT"));
        LocalDateTime zone3 = LocalDateTime.now(ZoneId.of("GMT-5"));
        System.out.println("Zone: "+zone);
        System.out.println("Zone: "+zone2);
        System.out.println("Zone: "+zone3);


/*
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


            Date dat = simpleDateFormat.parse("10-11-1990");

        System.out.println("1)"+dat+"  2)");
*/

        // Date now = new Date();
/*
        Date localDate1=new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");

        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println(simpleDateFormat.format(localDate1));

        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        System.out.println(simpleDateFormat.format(localDate1));

        */


/*
        LocalDate date1 = LocalDate.parse("2017-02-03");
        LocalDate date2 = LocalDate.parse("2017-03-03");
        System.out.println(date1.isAfter(date1));
        */
/*
        LocalDate d1 = LocalDate.of(1999, 1, 20);
        LocalDate d2 = LocalDate.of(2016, 12, 15);
        Period p = d1.until(d2);
        System.out.println(p);

        System.out.printf("Years: %s, Months: %s, Days: %s%n",
                p.getYears(), p.getMonths(), p.getDays());

        //alternatively
        Period p2 = Period.between(d1, d2);
        System.out.println(p2);

        */

        // Calendar c = new GregorianCalendar(2015, 01, 25);
        /*
        Calendar c = new GregorianCalendar();


        System.out.println(c.get(Calendar.MONTH)); // 01
        System.out.println(c.get(Calendar.YEAR));  // 2015

        System.out.println("1)"+
                c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("2)"+
                c.get(Calendar.DAY_OF_WEEK));
        System.out.println("3)"+
                c.get(Calendar.DAY_OF_YEAR));
        System.out.println("4)"+
                c.get(Calendar.DAY_OF_MONTH));




        // create a calendar
        Calendar cal = Calendar.getInstance();

        // print current date
        System.out.println("The current date is : " + cal.getTime());

        // add 20 days to the calendar
        cal.add(Calendar.DATE, 20);
        System.out.println("20 days later: " + cal.getTime());

        // subtract 2 months from the calendar
        cal.add(Calendar.MONTH, -2);
        System.out.println("2 months ago: " + cal.getTime());

        // subtract 5 year from the calendar
        cal.add(Calendar.YEAR, -5);
        System.out.println("5 years ago: " + cal.getTime());
*/

/*
        Calendar calendar1 = new GregorianCalendar(2019, Calendar.FEBRUARY , 25);
        Date date1 = calendar.getTime();
        System.out.println(date);*/

//        LocalDate localDate=LocalDate.now();
//        String k=localDate.toString();
//        System.out.println(localDate);
//        System.out.println(k);

        String input_date="2012-08-01";
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
        Date dt1=format1.parse(input_date);
        DateFormat format2=new SimpleDateFormat("dd");
        String finalDay=format2.format(dt1);
        System.out.println(finalDay);


        TimeZone timeZone = TimeZone.getTimeZone("Asia/Singapore");
        Calendar calendar=Calendar.getInstance(timeZone);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("DD-MMMM");
        simpleDateFormat.setTimeZone(timeZone);

        System.out.println(simpleDateFormat.format(calendar.getTime()));
        //System.out.println(simpleDateFormat.format(Calendar.getInstance().));

        System.out.println(timeZone.getID());
        System.out.println(timeZone.getRawOffset());
        System.out.println(timeZone.getDisplayName(false, TimeZone.LONG));
        System.out.println(timeZone.getDisplayName(false, TimeZone.SHORT));
        System.out.println(timeZone.getDisplayName(true, TimeZone.LONG));
        System.out.println(timeZone.getDisplayName(true, TimeZone.SHORT));
    }
}
