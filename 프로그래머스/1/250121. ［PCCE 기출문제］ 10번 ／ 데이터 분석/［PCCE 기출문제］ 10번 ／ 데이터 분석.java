import java.util.*;

// *ext에 해당하는 값 : data[i][h1.get(ext)]
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> h1 = new HashMap<String, Integer>();
        h1.put("code", 0);
        h1.put("date", 1);
        h1.put("maximum", 2);
        h1.put("remain", 3);
        
        List<int[]> list = new ArrayList<>();
        
        //1. ext에 따른 데이터 뽑아내기
        for(int i=0; i<data.length; i++){
            if(data[i][h1.get(ext)] < val_ext){
                list.add(data[i]);
            }
        }
        
        list.sort((a, b) -> a[h1.get(sort_by)]-b[h1.get(sort_by)]);

        
        
        int[][] answer = list.toArray(new int[0][]);
        return answer;
    }
    
}