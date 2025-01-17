import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(n != 1){
            if((a % 2 == 1 && b == a+1) || (b % 2 == 1 && a == b+1)){
                answer++;
                break;
            }
            a = (int)Math.ceil(a/2.0);
            b = (int)Math.ceil(b/2.0);
            answer++;
            n=n/2;
        }

        return answer;
    }
}