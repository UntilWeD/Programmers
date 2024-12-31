class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[][] board = new int[park.length][park[0].length()];
        
        for(int i=0; i<park.length; i++){
            for(int j=0;j<park[0].length(); j++){
                switch(park[i].charAt(j)){
                    case 'O':
                        board[i][j]= 0;
                        break;
                    case 'X':
                        board[i][j] = 1;
                        break;
                    default:
                        answer[0] = i;
                        answer[1] = j;
                        break;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++){
            int can = 1;
            switch(routes[i].charAt(0)){
                case 'E':
                    for(int j=1; j <= (routes[i].charAt(2))-'0'; j++){
                        // 동쪽으로 넘어가거나 장애물일 경우
                        if(answer[1] +j == board[0].length || board[answer[0]][answer[1]+j] == 1){
                            can = 0;
                            break;
                        }
                    }
                    if(can == 1)
                        answer[1] += (routes[i].charAt(2))-'0';
                    break;
                case 'W':
                    for(int j=1; j<= (routes[i].charAt(2))-'0'; j++){
                        // 서쪽 넘어가거나 장애물일 경우
                        if(answer[1] -j < 0 || board[answer[0]][answer[1]-j] == 1){
                            can = 0;
                            break;
                        }
                    }
                    if(can==1)
                        answer[1] -= (routes[i].charAt(2))-'0';
                    break;
                case 'N':
                    for(int j=1; j<= (routes[i].charAt(2))-'0'; j++){
                        // 북쪽 넘어가거나 장애물일 경우
                        if(answer[0] - j < 0 || board[answer[0]-j][answer[1]] == 1){
                            can = 0;
                            break;
                        }
                    }
                    if(can == 1)
                        answer[0] -= (routes[i].charAt(2))-'0';
                    
                    break;
                default:
                    for(int j=1; j<= (routes[i].charAt(2))-'0'; j++){
                        // 남쪽 넘어가거나 장애물일 경우
                        if(answer[0] + j == board.length || board[answer[0]+j][answer[1]] == 1){
                            can = 0;
                            break;
                        }
                    }
                    if(can == 1)
                        answer[0] += (routes[i].charAt(2))-'0';
                    break;
            }
        }
        
        return answer;
    }
}