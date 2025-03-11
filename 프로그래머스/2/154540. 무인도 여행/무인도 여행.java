import java.util.*;

class Solution {
    int[][] direction = {{1,0}, {-1,0}, {0,1}, {0, -1}};
    
    public int[] solution(String[] maps) {
        // String[] -> int[]
        int[][] map = new int[maps.length][maps[0].length()];
        for(int i=0; i <maps.length; i++){
            for(int j=0; j < maps[i].length(); j++){
                char ch = maps[i].charAt(j);
                if(ch != 'X'){
                    map[i][j] = ch - '0';
                } else{
                    map[i][j] = 0;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for(int i=0; i < map.length; i++){
            for(int j=0; j < map[i].length; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    list.add(goOtherIsland(map, visited,i, j));
                }
                
            }
        }
        
        if(list.isEmpty()){
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[list.size()];
        for(int i=0; i < list.size(); i++){
            System.out.println(list.get(i));
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    public int goOtherIsland(int[][] map, boolean[][] visited ,int x, int y){
        int sum = map[x][y];
        visited[x][y] = true;
        
        for(int i=0; i < direction.length; i++){
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            
            if(nx < map.length && nx >= 0 && ny <map[0].length && ny >= 0 && !visited[nx][ny] && map[nx][ny] != 0){
                visited[nx][ny] = true;
                sum += goOtherIsland(map, visited, nx,ny);
            }
        }
        
        return sum;
    }
}