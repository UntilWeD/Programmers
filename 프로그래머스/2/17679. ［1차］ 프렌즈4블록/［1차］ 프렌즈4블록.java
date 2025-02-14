import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] bd = new char[m][n];
        int[][] score = new int[m][n];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                bd[i][j] = board[i].charAt(j);
            }
        }
        
        boolean check = true;
        
        while(check){
            // 1. 2*2 박스의 경우 인덱스 기록하기
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length(); j++){
                    char temp = bd[i][j];
                    if(temp != '0' && i+1 < m && j+1 < n && temp == bd[i][j+1] && temp == bd[i+1][j] && temp == bd[i+1][j+1]){
                        score[i][j] = 1;
                        score[i][j+1] = 1;
                        score[i+1][j] = 1;
                        score[i+1][j+1] = 1;
                    }
                }
            }
            check = false;
            // 1-1. 한거번에 체크하기
            for(int i=0; i <score.length; i++){
                for(int j=0; j< score[i].length; j++){
                    if(score[i][j] == 1){
                        bd[i][j] = '0';
                        score[i][j] = 0;
                        check = true;
                        answer++;
                    }
                }
            }
            
            // 2. 중력효과 구현
            for(int j=0; j < n; j++){
                for(int i=m-1; i >= 0; i--){
                    if(bd[i][j] == '0'){
                        for(int k=i-1; k >= 0; k--){
                            if(bd[k][j] != '0'){
                                bd[i][j] = bd[k][j];
                                bd[k][j] = '0';
                                break;
                            }
                        }
                    }
                }
            }
            
            
        }
        return answer;
    }

}