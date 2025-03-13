import java.util.*;

class Solution {
    public int solution(String[] board) {      
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int[][] map = new int[board.length][board[0].length()];
        int[][] counts = new int[board.length][board[0].length()];
        HashMap<Character, Integer> ref = new HashMap<>();
        ref.put('.', 1);
        ref.put('D', 0);
        ref.put('R', 2);
        ref.put('G', 3);    
        
        int[] current = new int[3]; 
        int[] goal = new int[2];
        for(int i=0; i < board.length; i++){
            for(int j =0; j < board[i].length(); j++){
                counts[i][j] = Integer.MAX_VALUE;
                map[i][j] = ref.get(board[i].charAt(j));
                if(map[i][j] == 2){
                    map[i][j] = 1;
                    current[0] = 0;
                    current[1] = i;
                    current[2] = j;
                    counts[i][j] = 0;
                } else if(map[i][j] == 3){
                    map[i][j] = 1;
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(((a,b) -> a[0] - b[0]));
        pq.add(current);
        
        while(!pq.isEmpty()){
            current = pq.poll();
            int count = current[0];
            int x = current[1];
            int y = current[2];
            
            
            if(count > counts[x][y]) continue;
            
            if(x == goal[0] && y == goal[1])
                return count;
            
            for(int i=0; i < directions.length; i++){
                int nx = x;
                int ny = y;
                int tempX = nx + directions[i][0];
                int tempY = ny + directions[i][1];
                
                
                while(tempX >= 0 && tempX < map.length    &&
                      tempY >= 0 && tempY < map[0].length &&
                      map[tempX][tempY] != 0){
                    nx = tempX;
                    ny = tempY;
                    tempX = nx + directions[i][0];
                    tempY = ny + directions[i][1];
                }
                
                if(count + 1 < counts[nx][ny]){
                    counts[nx][ny] = count+1;
                    pq.add(new int[]{count+1, nx, ny});
                }
            }
        }
        
        
        return -1;
    }
}