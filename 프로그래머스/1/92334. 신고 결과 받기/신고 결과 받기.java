import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> idIndex = new HashMap<>();
        HashMap<String, Integer> reportCount = new HashMap<>();
        HashMap<String, HashSet<String>> reports = new HashMap<>();

        // 사용자 ID별 인덱스 초기화
        for (int i = 0; i < id_list.length; i++) {
            idIndex.put(id_list[i], i);
            reports.put(id_list[i], new HashSet<>());
        }

        // 중복 제거와 신고 횟수 계산
        for (String rep : report) {
            String[] detail = rep.split(" ");
            String reporter = detail[0];
            String reported = detail[1];

            // 중복 신고 방지 및 신고 횟수 증가
            if (reports.get(reporter).add(reported)) {
                reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);
            }
        }

        // 결과 계산
        for (String user : id_list) {
            if (reportCount.getOrDefault(user, 0) >= k) {
                for (String reporter : id_list) {
                    if (reports.get(reporter).contains(user)) {
                        answer[idIndex.get(reporter)]++;
                    }
                }
            }
        }

        return answer;
    }
}
