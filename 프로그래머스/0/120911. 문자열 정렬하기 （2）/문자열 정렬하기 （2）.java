import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        
        char[] chararray = my_string.toLowerCase().toCharArray();
        Arrays.sort(chararray);
        
        return new String(chararray);
    }
}