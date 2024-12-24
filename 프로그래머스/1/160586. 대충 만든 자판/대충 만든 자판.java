class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        // targets 배열
        for(int i=0; i< targets.length; i++){
            
            // targets배열의 각 원소 문자 EX. ABCD -> A,B,C,D
            for(int j=0; j<targets[i].length(); j++){
                int min = 0;
                
                // keymap에서 해당 문자를 포함하는지 확인
                for(int k=0; k<keymap.length; k++){
                    if(keymap[k].indexOf(targets[i].charAt(j)) != -1){
                        if(min == 0){
                            min = keymap[k].indexOf(targets[i].charAt(j))+1;
                        } else if( min > keymap[k].indexOf(targets[i].charAt(j))+1){
                            min = keymap[k].indexOf(targets[i].charAt(j))+1;
                        }
                    }
                    if(k+1 == keymap.length && min == 0){
                        answer[i] = -1;
                    }
                }
                answer[i] += min;
                if(answer[i] == -1)
                    break;
                
            }
        }
        
        return answer;
    }
}