import java.util.*;

class Solution {
    public String solution(String new_id) {
        // 1단계 : 대문자 소문자로 치환
        new_id = new_id.toLowerCase();
        
        // 2단계 : 소문자, 숫자, 빼기, 밑줄 마침표를 제외한 모든 문자제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");
        
        // 3단계 new_id에서 마침표가 2번이상 연속된 부분 하나의 마침표로 치환
        new_id = new_id.replaceAll("\\.{2,}", ".");
        
        // 4단계 마침표가 처음이나 끝에 위치한다면 제거
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        
        // 5단계 빈문자열이라면 new_id에 "a"를 대입
        if(new_id.isEmpty())
            new_id="a";
        
        // 6단계 new_id의 길이가 16자 이상이면 new_id의 첫 15개의 문자를 제외한 나머지 문자 모두 제거(마지막에 마침표도 제거)
        if(new_id.length() >= 16){
            new_id = new_id.substring(0,15);
        }
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        
        //7단계 new_id의 길이가 2자 이하라면 new_id의 마지막 문자를 new_id의 길이가 3이 될때까지 반복해서 끝에 붙이기
        if(new_id.length() < 3){
            StringBuilder sb = new StringBuilder(new_id);
            while(sb.length() < 3){
                sb.append(sb.charAt(sb.length()-1));
            }
            new_id = sb.toString();
        }
        
        return new_id;
    }
}