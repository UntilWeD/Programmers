import java.util.*;

class Solution {
    
    public boolean solution(String[] phone_book) {
        // 모든 전화번호를 해시맵에 저장
        HashMap<String, Integer> map = new HashMap<>();
        for (String phone : phone_book) {
            map.put(phone, 1);
        }
        
        // 각 전화번호의 가능한 모든 접두어가 맵에 있는지 확인
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if (map.containsKey(prefix)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}