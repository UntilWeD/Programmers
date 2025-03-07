import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {   
        HashMap<String, Integer> map = new HashMap<>();
        int[] max = new int[course.length];
        
        for(int i=0; i < orders.length; i++){
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            String order = new String(chars);
            
            for(int j=0; j <course.length; j++){
                int length = course[j];
                // 모든 가능한 코스 요리 만들기 
                dfs(map, order, length, "",0, max, j);
            }
        }
        
        HashMap<Integer, Integer> dict = new HashMap<>();
        for(int i =0; i <max.length; i++){
            dict.put(course[i], max[i]);
        }
        
        // 값 넣기
        List<String> list = new ArrayList<>();
        for(String name : map.keySet()){
            if(dict.get(name.length()) == map.get(name) && map.get(name) >= 2){
                list.add(name);
            }
        }
        
        // 값 변환
        String[] answer = new String[list.size()];
        for(int i=0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    public void dfs(HashMap<String, Integer> map, String order, int length, String current,int index, int[] max, int j){
        if(current.length() == length){
            map.put(current, map.getOrDefault(current, 0)+ 1);
            max[j] = Math.max(max[j], map.get(current));
            return;
        }
        
        for(int i=index; i<order.length(); i++){
            String temp = current + order.charAt(i);
            dfs(map, order, length, temp, i+1, max, j);
        }
        
    }
    
}