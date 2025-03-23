import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        char[][] waitingRoom = new char[5][5];
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}}; // 상, 하, 좌, 우
        
        for(int i = 0; i < places.length; i++){
            Queue<int[]> startPoint = new LinkedList<>();
            for(int j = 0; j < places[i].length; j++){
                waitingRoom[j] = places[i][j].toCharArray();
                for(int k = 0; k < places[i].length; k++){
                    if(waitingRoom[j][k] == 'P')
                        startPoint.add(new int[]{j, k});
                }
            }
            boolean done = false;
            answer[i] = 1;
            
            
            while(!startPoint.isEmpty()){
                boolean[][] visited = new boolean[5][5];
                // 기준 위치 기록 
                Queue<int[]> que = new LinkedList<>();
                int[] start = startPoint.poll();
                que.add(new int[]{start[0], start[1], 0});
                int[] position = {start[0], start[1]};
                visited[position[0]][position[1]] = true;
                
                // ------BFS------
                while(!que.isEmpty()){
                    int[] current = que.poll();
                    int x = current[0];
                    int y = current[1];
                    int distance = current[2];
                    
                    if(distance > 2) continue;
                    
                    if(waitingRoom[x][y] == 'P' && distance > 0){
                        if(distance <= 2){
                            answer[i] = 0;
                            done = true;
                            break;
                        }
                    }
                    
                    for(int j = 0; j < directions.length; j++){
                        int nx = x + directions[j][0];
                        int ny = y + directions[j][1];
                        if(nx >= 0 && nx < waitingRoom.length && ny >= 0 && ny < waitingRoom[0].length 
                           && waitingRoom[nx][ny] != 'X' && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            que.add(new int[]{nx, ny, distance + 1});
                        }
                    }
                }
                // ------BFS------
                if(done)
                    break;
            }

        }
        
        
        return answer;
    }
    
    public boolean isManhatteanDistance(int r1, int c1, int r2, int c2){
        int sum = Math.abs(r1-r2) + Math.abs(c1-c2);
        if(sum <= 2){
            return false;
        } else{
            return true;
        }
    }
}