import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> intlist = new ArrayList<>();

        for(int i=0; i<my_string.length(); i++){
            if((int)(my_string.charAt(i)) > 47 && (int)(my_string.charAt(i)) < 58 ){
                intlist.add(Character.getNumericValue(my_string.charAt(i)));
            }
        }
        
        int[] answer = intlist.stream().mapToInt(i -> i).toArray();
        
        Arrays.sort(answer);
        
        return answer;
    }
}