import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String[] day = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, a-1, b);
        
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        return day[dayOfWeek-1];
    }
}