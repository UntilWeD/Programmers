import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        List<Integer> list = new ArrayList<>();
        list.add(k);
        while(k != 1){
            if( k % 2 == 0){
                k = k/2;
            } else {
                k = k*3 +1;
            }
            list.add(k);
        }
        
        // 정적분 누적합 계산
        double[] sums = new double[list.size()];
        sums[0] = 0.0;
        double sum = 0;
        for(int i=0; i < sums.length-1; i++){
            sum +=  (list.get(i) + list.get(i+1))/2.0;
            sums[i+1] = sum;
        }

        
        // ranges별 정적분 값 구하기
        int n = list.size()-1;
        for(int i=0; i < ranges.length; i++){
            int[] current = {ranges[i][0], n + ranges[i][1]};
            
            if(current[0] > current[1]){
                answer[i] = -1.0;
                continue;
            }
            if(current[0] == current[1]){
                answer[i] = 0.0;
                continue;
            }
            System.out.println(current[0] + " " + current[1]);
            answer[i] = sums[current[1]] - sums[current[0]];
        }
        
        return answer;
    }
}