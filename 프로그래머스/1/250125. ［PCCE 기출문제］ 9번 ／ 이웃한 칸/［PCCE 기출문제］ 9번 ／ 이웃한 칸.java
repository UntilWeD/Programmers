class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        // 오른쪽, 위, 아래, 왼쪽
        for(int i=0; i<4; i++){
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if(h_check >= 0 && h_check < board.length){
                if(w_check >= 0 && w_check < board[h].length){
                    if(board[h][w].equals(board[h_check][w_check])){
                        answer++;
                    }
                }
            }
        }
        
        
        return answer;
    }
}