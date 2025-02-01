import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        String binary = Integer.toString(n, k);
        String[] arr = binary.split("0");
        
        List<Long> list = new ArrayList<>();
        for(String str : arr){
            if(str.equals(""))
                continue;
             long num = Long.parseLong(str);
            // 소수 찾는 알고리즘
            if(isPrime(num)){
                list.add(num);
            }
        }
        
        
        return list.size();
    }
    
    private boolean isPrime(long n){
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        
        for(long i = 3; i <= Math.sqrt(n); i += 2) {
            if(n % i == 0) return false;
        }
        return true;
    }
}