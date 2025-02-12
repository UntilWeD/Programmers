import java.util.*;

class Solution {
    public String[] solution(String[] record) {
       
        
        List<String[]> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
 
        for(String str : record){
            String[] info = str.split(" ");
            
            switch(info[0]){
                case "Enter":
                    map.put(info[1], info[2]);
                    list.add(new String[]{info[1],"님이 들어왔습니다."});
                    break;
                case "Leave":
                    list.add(new String[]{info[1],"님이 나갔습니다."});
                    break;
                case "Change":
                    map.replace(info[1], info[2]);
                    break;
                default:
                    break;
            }
        }

        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = map.get(list.get(i)[0]) + list.get(i)[1];
        }
        
        return answer;
    }
}