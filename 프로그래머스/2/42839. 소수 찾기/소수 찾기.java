import java.util.*;

class Solution {
    public int solution(String numbers) {
        String[] nums = numbers.split("");
        boolean[] used = new boolean[nums.length];
        Set<Integer> visited = new HashSet<>(); // 방문 여부 체크 및 중복 방지

        search(nums, used, "", visited);
        return visited.size();
    }

    public void search(String[] nums, boolean[] used, String current, Set<Integer> visited) {
        if (!current.equals("")) {
            int number = Integer.parseInt(current);
            if (!visited.contains(number) && isPrime(number)) {
                visited.add(number);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                search(nums, used, current + nums[i], visited);
                used[i] = false; // 백트래킹
            }
        }
    }

    public boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true; // 2와 3은 소수
        if (num % 2 == 0 || num % 3 == 0) return false; // 2와 3으로 나누어떨어지면 소수 아님

        // 6의 배수 ± 1 확인
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}

