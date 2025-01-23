import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.split("\\},\\{");
        
        arr[0] = arr[0].replace("{", "");
        arr[arr.length-1] = arr[arr.length-1].replace("}", "");
        Arrays.sort(arr, (String s1, String s2) -> s1.length() - s2.length());
        
        
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        for(String str : arr){
            String[] temp = str.split(",");
            for(String num : temp){
                if(!map.containsKey(num)){
                    map.put(num, index++);
                }
            }
            
        }
        
        int[] answer = new int[map.size()];
        for(String num : map.keySet()){
            answer[map.get(num)] = Integer.parseInt(num);
        }
        return answer;
    }
}