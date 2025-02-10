import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> que = new LinkedList<>();
        boolean[] visited = new boolean[y+1];
        que.offer(new int[]{x, 0});
        
        while(!que.isEmpty()){
            int[] temp = que.poll();
            int num = temp[0];
            int count = temp[1];
            
            if(num == y){
                return count;
            }
            
            int[] nextNums = {num + n, num*2, num*3};
            for(int nextNum : nextNums){
                if(nextNum <= y && !visited[nextNum]){
                    visited[nextNum] = true;
                    que.offer(new int[]{nextNum, count+1});
                }
            }
        }
        
        
        return -1;
    }
}