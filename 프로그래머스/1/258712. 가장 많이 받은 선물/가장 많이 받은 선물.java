import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> h1 = new HashMap<>();
        int[][] giftBoard = new int[friends.length][friends.length];
        int[] giftScore = new int[friends.length];
        int[] answer = new int[friends.length];
        int max = -1;
        
        for(int i=0; i< friends.length; i++){
            h1.put(friends[i], i);
        }
        
        for(int i=0; i<gifts.length; i++){
            String[] temp = gifts[i].split(" ");
            giftBoard[h1.get(temp[0])][h1.get(temp[1])]++;
            
            // 선물지수 보낸사람 계산
            giftScore[h1.get(temp[0])]++;
            giftScore[h1.get(temp[1])]--;
            // sendMap.get(temp[0]).add(temp[1]);
        }
        
        for(int i=0; i<giftBoard.length-1; i++){
            for(int j=i+1; j<giftBoard.length; j++){
                if(giftBoard[i][j] > giftBoard[j][i]){
                    answer[i]++;
                } else if(giftBoard[i][j] < giftBoard[j][i]){
                    answer[j]++;
                } else{
                    // 선물 지수 비교
                    if(giftScore[i] > giftScore[j]){
                        answer[i]++;
                    } else if(giftScore[i] < giftScore[j]){
                        answer[j]++;
                    }
                }
            }
        }
        
        for(int i=0; i < answer.length; i++){
            max = Math.max(max, answer[i]);
        }
        
        return max;
    }
}