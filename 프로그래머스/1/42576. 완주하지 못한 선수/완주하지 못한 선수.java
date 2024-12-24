import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> h1 = new HashMap<String, Integer>();
        
        for(String name : participant){
            h1.put(name, h1.getOrDefault(name, 0)+1);
        }
        
        for(String name : completion){
            h1.put(name, h1.get(name)-1);
        }
        
        for(String name : h1.keySet()){
            if(h1.get(name) != 0)
                return name;
        }
        
        
        
        return "";
    }
}