import java.util.*;

class Solution {
    public int[][] solution(int n) {
        
        
        List<int[]> orders = new ArrayList<>();
        
        hanoi(n,1,2,3, orders);
        
        int[][] answer = new int[orders.size()][2];
        for(int i = 0; i < orders.size(); i++){
            answer[i] = orders.get(i);
        }
        
        return answer;
    }
    
    public void hanoi(int n, int from, int mid, int to, List<int[]> moves) {
        if (n == 1) {
            moves.add(new int[] {from, to});
            return;
        }

        hanoi(n-1, from, to, mid, moves);

        moves.add(new int[] {from, to});

        hanoi(n-1, mid, from, to, moves);
    }
}