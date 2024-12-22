class Solution {
    public int solution(String dartResult) {
        String temp = "";
        int[] scores  = new int[3];
        char[] bonus = new char[3];
        int scoreIndex = 0;
        
        for(int i=0; i < dartResult.length(); i++){
            char ch = dartResult.charAt(i);
            temp += ch; // 1S
            
            // 보너스에 따라 계산 시작
            if(ch >= 'A' && ch <= 'Z'){
                // temp로부터 점수 분리
                int score = Integer.parseInt(temp.substring(0,temp.indexOf(ch)));
                
                // 보너스에 따라 score 계산
                switch(ch) {
                    case 'S':
                        score = (int)Math.pow(score, 1);
                        break;
                    case 'D':
                        score = (int)Math.pow(score, 2);
                        break;
                    default: // T
                        score = (int)Math.pow(score, 3);
                        break;
                }
                
                if(i+1 < dartResult.length() && dartResult.charAt(i+1) == '*'){
                    // 1번째의 스타상 당첨시
                    if(scoreIndex == 0){
                        score = score*2;
                    } else {
                        //2,3 번째의 스타상 당첨시
                        scores[scoreIndex-1] *= 2;
                        score *= 2;
                    }
                    i++;
                } else if(i+1 < dartResult.length() && dartResult.charAt(i+1) == '#'){
                    score = score*(-1);
                    i++;
                } else{
                    scores[scoreIndex] = score;
                }
                
                System.out.println(score);
                scores[scoreIndex] = score;
                scoreIndex++;
                temp = "";
            }
            
        }
        
        return scores[0]+scores[1]+scores[2];
    }
}