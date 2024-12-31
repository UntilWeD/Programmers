import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> count_map = new HashMap<>();
        HashMap<String, Integer> id_index = new HashMap<>();
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        
        
        for(int i=0; i<id_list.length; i++){
            id_index.put(id_list[i], i);
        }
        
        for(int i=0; i <report.length; i++){
            // detail[0] = 신고자, detail[1] = 피신고자
            String[] detail = report[i].split(" ");
            
            reportMap.putIfAbsent(detail[0], new HashSet<>());
            if(reportMap.get(detail[0]).add(detail[1])){
                count_map.put(detail[1], count_map.getOrDefault(detail[1], 0) + 1);
            }

        }
        
        
        for(String reporter : reportMap.keySet()){
            for(String reported : reportMap.get(reporter)){
                if(count_map.getOrDefault(reported, 0) >= k){
                    answer[id_index.get(reporter)]++;
                }
            }
        }
        
        
        
        return answer;
    }
}