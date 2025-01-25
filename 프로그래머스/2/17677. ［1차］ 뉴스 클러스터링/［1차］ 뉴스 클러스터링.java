import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1= str1.toUpperCase();
        str2= str2.toUpperCase();
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        for(int i=0; i<str1.length()-1; i++){
            if(Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i+1))){
                list1.add("" + str1.charAt(i) + str1.charAt(i+1));
            }
        }
        for(int i=0; i<str2.length()-1; i++){
            if(Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i+1))){
                list2.add("" + str2.charAt(i) + str2.charAt(i+1));
            }
        }
        
        int intersection = 0;
        List<String> list3 = new ArrayList<>(list2);
        // 교집합 구하기
        for(String str : list1){
            if(list3.contains(str)){
                list3.remove(str);
                intersection++;
            }
        }
        // 합집합 구하기
        int union = list3.size()+list1.size();
    

        return union == 0 ? 65536 : (int)(65536* ((double)intersection/union));
    }
}