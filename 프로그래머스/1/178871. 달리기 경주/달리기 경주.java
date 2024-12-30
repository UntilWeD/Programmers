import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> h1 = new HashMap<>();
        
        for(int i=0; i < players.length; i++){
            h1.put(players[i], i);
        }
        
        for(int i=0; i< callings.length; i++){
            // 호명된 선수 위치
            int index = h1.get(callings[i]);
            // players 연산부터
            String temp = players[index-1];
            players[index-1] = players[index];
            players[index] = temp;
            
            // 이후 h1 연산
            // 앞에 있는 선수 이름
            String pre = players[index-1];
            
            h1.replace(players[index-1], index-1);
            h1.replace(players[index], index);
        }
        
        
        return players;
    }
}