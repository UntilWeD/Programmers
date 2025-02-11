import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        FileName[] arr = new FileName[files.length];
        
        // File 객체 생성하기
        for(int i=0; i<files.length; i++){
            String head = "";
            String number = "";
            
            for(int j=0; j<files[i].length(); j++){
                // number가 끝난다면
                char ch = files[i].charAt(j);
                
                if(Character.isDigit(ch) && head.equals("")){
                    head = files[i].substring(0, j).toLowerCase();
                }
                
                if(!head.equals("") && Character.isDigit(ch)){
                    number += ch;
                    if(number.length() >= 5){
                        break;
                    }
                }else if (!number.isEmpty()){ 
                    break; 
                }
            }
            
            FileName file = new FileName(files[i], head, Integer.parseInt(number));
            arr[i] = file;
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<answer.length; i++){
            answer[i] = arr[i].getOriginalName();
        }
        

        return answer;
    }
    
    class FileName implements Comparable<FileName> {
        String originalName;
        String head;
        int number;
        
        public FileName(String originalName, String head, int number){
            this.originalName = originalName;
            this.head = head;
            this.number = number;
        }
        
        public String getOriginalName(){
            return originalName;
        }
        
        @Override
        public int compareTo(FileName other){
            
            if(head.compareTo(other.head) != 0){
                return head.compareTo(other.head);
            }
            return number - other.number;
        }
    }
}