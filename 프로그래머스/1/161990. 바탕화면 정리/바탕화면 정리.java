class Solution {
    public int[] solution(String[] wallpaper) {
        int[][] board = new int[wallpaper.length][wallpaper[0].length()];
        int lux= -1, luy= -1, rdx= -1, rdy = -1;
    
        
//         for(int i=0; i<wallpaper.length; i++){
//             for(int j=0;j<wallpaper[0].length(); j++){
//                 board[i][j] = (wallpaper[i].charAt(j) =='#') ? 1 : 0;
//                 if(lux == -1){
//                     lux = j;
//                     luy = i;
//                     rdx = j;
//                     rdy = i;
//                 }
//                 if(board[i][j] == 1){
//                     // rdx 갱신
//                     if()
                        
//                     // rdy갱신
                        
                        
//                     // lux 갱신
                        
                        
//                     // luy 갱신
//                 }
//             }
//         }
        
        // 값 초기화
        for(int i=0;i<wallpaper.length; i++){
            int index = wallpaper[i].indexOf('#');
            if(index != -1 && lux == -1){
                lux = i;
                luy = index;
                rdx = i;
                rdy = index;
                break;
            }
        }

        for(int i=0;i<wallpaper.length; i++){
            int front = wallpaper[i].indexOf('#');
            int back = wallpaper[i].lastIndexOf('#');
            if(front != -1){
                // lux 
                if(i < lux)
                    lux = i;
                
                // luy
                if(front < luy)
                    luy = front;
                    
                // rdx
                if(i > rdx)
                    rdx = i;
                    
                // rdy
                if(back > rdy)
                    rdy = back;
                
            }
        }
        

        
        
        
        int[] answer = {lux, luy, rdx+1, rdy+1};
        return answer;
    }
}