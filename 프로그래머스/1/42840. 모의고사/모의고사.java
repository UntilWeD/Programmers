import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int a = 0;
        int b = 0;
        int c = 0;
        int[] bIdx = {1, 3, 4, 5};
        int[] cIdx = {3,3, 1,1, 2,2, 4,4, 5,5};
        
        for(int i=0; i<answers.length; i++){
            // 1번 수포자 번호체크
            if(i%5+1 == answers[i])
                a++;
            // 2번 수포자 번호 체크
            if(i%2==0 && answers[i] == 2 || i%2 !=0 && bIdx[((i-1)/2)%4] == answers[i]){
                b++;
            } 
            //3번 수포자 번호 체크
            if(cIdx[i%cIdx.length] == answers[i])
                c++;
            
        }
        
        // 점수중 가장 큰 값 찾기
        int[] score = {a, b, c};
        int max = a;
        for(int i=0; i<3; i++){
            if(max <= score[i])
                max = score[i];
        }
        
        // max와 비교하여 승리자 리스트 만들기
        List<Integer> winnersList = new ArrayList<Integer>();
        for(int i=0; i<3; i++){
            if(max == score[i])
                winnersList.add(i+1);
        }
        
        // 리스트 int[]로 초기화하여 반환
        int[] winners = new int[winnersList.size()];
        for(int i=0; i<winners.length; i++)
            winners[i] = winnersList.get(i);
        
        return winners;
    }
}