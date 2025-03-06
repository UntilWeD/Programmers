import java.util.*;

class Solution {
    public int solution(String[] maps) {
        //  X=0, O=1, L=2, E=3
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('X', 0);
        map.put('O', 1);
        map.put('S', 1);
        map.put('L', 2);
        map.put('E', 3);
        
        int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1,0}};
        int[][] game = new int[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        // 인덱스별 값 -> 0 = x, 1 = y, 2 = answer, 3 = 레버체크
        int[] current = new int[3];
        for(int i=0; i < maps.length; i++){
            for(int j=0; j < maps[i].length(); j++){
                char ch = maps[i].charAt(j);
                game[i][j] = map.get(ch);
                if(ch == 'S'){
                    current[0] = i;
                    current[1] = j;
                    visited[i][j] = true;
                }
            }
        }
        
        Queue<int[]> que1 = new LinkedList<>();
        Queue<int[]> que2 = new LinkedList<>();
        que1.add(current);
        
        // 1. 시작지점에서 레버까지
        while(!que1.isEmpty()){
            current = que1.poll(); 
            int x = current[0];
            int y = current[1];
            
            if(game[x][y] == 2){
                que2.offer(new int[]{x, y, current[2]});
            }
            
            for(int i=0; i < direct.length; i++){
                int nx = x + direct[i][0];
                int ny = y + direct[i][1];
                if(0 <= nx && nx < game.length && 0 <= ny && ny < game[0].length && game[nx][ny] != 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    que1.offer(new int[]{nx, ny, current[2]+1});
                }
            }
        }
        if(que2.isEmpty())
            return -1;

        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }

        //1. 레버에서 끝까지
        while(!que2.isEmpty()){
            current = que2.poll(); 
            int x = current[0];
            int y = current[1];
            
            if(game[x][y] == 3)
                return current[2];
            
            for(int i=0; i < direct.length; i++){
                int nx = x + direct[i][0];
                int ny = y + direct[i][1];
                if(0 <= nx && nx < game.length && 0 <= ny && ny < game[0].length && game[nx][ny] != 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    que2.offer(new int[]{nx, ny, current[2]+1});
                }
            }
            
        }
        
        
        return -1;
    }
}