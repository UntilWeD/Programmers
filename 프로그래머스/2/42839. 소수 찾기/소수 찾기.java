import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        String[] nums = numbers.split("");
        boolean[] visited = new boolean[9999999];
        List<String> list = new ArrayList<>();
        for(String num : nums)
            list.add(num);
        
        return search(list, "", visited);
    }
    
    public int search(List<String> list, String num, boolean[] visited){
        int sum = 0;
        if(!num.equals("") && isPrime(Integer.parseInt(num)) && !visited[Integer.parseInt(num)]){
            visited[Integer.parseInt(num)] = true;
            sum += 1;
        }
            
        for(int i=0; i<list.size(); i++){
            List<String> copiedList = new ArrayList<>(list);
            String temp = list.get(i);
            copiedList.remove(i);
            sum += search(copiedList, num+temp, visited);
        }
        
        
        return sum;
    }
    
    public boolean isPrime(int num){
        if(num <= 1) return false;
        if(num <= 3) return true;
        if(num % 2 == 0 || num % 3 == 0) return false;
        
        for(int i=5; i <= (int)Math.sqrt(num); i++){
            if(num % i == 0)
                return false;
        }
        
        return true;
    }
    
}