import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 101;
        
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        for(int i=0; i < wires.length; i++){
            Arrays.fill(visited, false);
            
            que.add(1);
            visited[1] = true;
            int count = 1;
            
            while(!que.isEmpty()){
                int current = que.poll();
                
                for(int j=0; j < wires.length; j++){
                    if(i==j)
                        continue;
                    
                    int v1 = wires[j][0];
                    int v2 = wires[j][1];
                    
                    if(current == v1 && !visited[v2]){
                        que.add(v2);
                        count++;
                        visited[v2] = true;
                    } else if(current == v2 && !visited[v1]){
                        que.add(v1);
                        count++;
                        visited[v1] = true;
                    }
                }
            }
            int sum = Math.abs(count - (n-count));
            answer = Math.min(answer, sum);
        }
        
        return answer;
    }
}