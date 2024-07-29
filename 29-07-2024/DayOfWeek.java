import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter Day:");
	int day=sc.nextInt();
	System.out.println("Enter Month:");
	int month=sc.nextInt();
    System.out.println("Enter Year:");
	int year=sc.nextInt();

    String res1=dayOfTheWeek1(day,month,year);
    System.out.println(res1);

    String res2=dayOfTheWeek2(day,month,year);
    System.out.println(res2);

    String res3=dayOfTheWeek3(day,month,year);
    System.out.println(res3);

    }

    public static String dayOfTheWeek1(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        java.time.DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.toString();
    }


     public static String dayOfTheWeek2(int day, int month, int year) {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return days[dayOfWeek - 1];
    }

    public static String dayOfTheWeek3(int day, int month, int year) {
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int k = year % 100;
        int j = year / 100;
        int h = (day + (13 * (month + 1)) / 5 + k + (k / 4) + (j / 4) + 5 * j) % 7;
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return days[h];
    }
}