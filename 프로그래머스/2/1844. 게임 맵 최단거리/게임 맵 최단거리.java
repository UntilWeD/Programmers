import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // 동, 서, 남, 북
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        maps[0][0] = 0;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            if(x == n-1 && y == m-1){
                return dist;
            }
            
            for(int i=0; i< 4; i++){
                int tx = x + dx[i];
                int ty = y + dy[i];
                
                if(tx >= 0 && tx < n &&  ty >= 0 && ty < m && maps[tx][ty] == 1){
                    queue.add(new int[]{tx, ty, dist+1});
                    // 방문 처리
                    maps[tx][ty] = 0; 
                }
            }
        }
        
        
        return -1;
    }
}