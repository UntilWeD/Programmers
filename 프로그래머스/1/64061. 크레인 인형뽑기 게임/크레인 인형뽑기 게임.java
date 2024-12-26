import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        
        
        for(int move : moves){
            int currentCol = move-1;
            for(int row=0; row < board.length; row++){
                
                if(board[row][currentCol] != 0){
                    
                    if(!basket.empty() && basket.peek() == board[row][currentCol]){
                        basket.pop();
                        answer= answer + 2;
                    } else{
                        basket.push(board[row][currentCol]);
                    }
                    board[row][currentCol] = 0;
                    break;
                }
                
            }
            
        }
        
        return answer;
    }
}