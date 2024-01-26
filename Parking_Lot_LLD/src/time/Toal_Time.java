package time;

public class Toal_Time {
	public static int[] CalculateTime(String enterdate,String exitdate,String entertime,String exittime) {
		int firstDay = Integer.parseInt(enterdate.substring(8, 10));
        int lastDay = Integer.parseInt(exitdate.substring(8, 10));
        int firstMonth = Integer.parseInt(enterdate.substring(5, 7));
        int lastMonth = Integer.parseInt(exitdate.substring(5, 7));
        int firstYear = Integer.parseInt(enterdate.substring(0, 4));
        
        // Hours
        int Total_Hours=0;
        Total_Hours=(lastDay-firstDay)*24;
        
        int Total_Minutes_First_day=0;
        Total_Minutes_First_day = 60 - Integer.parseInt(entertime.substring(3, 5));
        
        int Total_Minutes_Last_day=0;
        Total_Minutes_Last_day=Integer.parseInt(exittime.substring(3, 5));
        
        int minute=Total_Minutes_First_day+Total_Minutes_Last_day;
        

        if (minute >= 60) {
            minute = minute - 60;
            Total_Hours=Total_Hours+1;
        }
        
        return new int[] {Total_Hours,minute};
	}
}