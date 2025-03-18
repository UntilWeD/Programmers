import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] board = new int[rows][columns];
        
        
        int num = 0;
        for(int i=0; i < rows; i++){
            for(int j=0; j < columns; j++){
                board[i][j] = ++num;
            }
        }
        
        for(int i=0; i < queries.length; i++){
            num = Integer.MAX_VALUE;
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            int cur  = 0;
            int temp = 0;
            
            // 우 -> 하 -> 좌 -> 상
            // 우
            cur = board[x1][y1];
            num = Math.min(num, cur);
            for(int j = y1; j < y2; j++){
                temp = board[x1][j+1];
                board[x1][j+1] = cur;
                cur = temp;
                num = Math.min(temp, num);
            }
            
            // 하
            for(int j = x1; j < x2; j++){
                temp = board[j+1][y2];
                board[j+1][y2] = cur;
                cur = temp;
                num = Math.min(temp, num);
            }
            
            // 좌
            for(int j = y2; y1 < j; j--){
                temp = board[x2][j-1];
                board[x2][j-1] = cur;
                cur = temp;
                num = Math.min(temp, num);
            }
            
            // 상
            for(int j = x2; x1 < j; j--){
                temp = board[j-1][y1];
                board[j-1][y1] = cur;
                cur = temp;
                num = Math.min(temp, num);
            }
            
            
            answer[i] = num;
        }
        
        return answer;
    }
}