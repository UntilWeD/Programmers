import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        // 총 사용 가능한 곡괭이 수 계산
        int totalPicks = picks[0] + picks[1] + picks[2];
        // 실제로 캘 수 있는 광물 그룹 수 계산
        int maxGroups = Math.min((minerals.length + 4) / 5, totalPicks);
        
        // 5개씩 묶어서 피로도 계산
        List<int[]> bundles = new ArrayList<>();
        int count = 0;
        int[] bundle = new int[3];  // 0: diamond, 1: iron, 2: stone
        
        for(int i = 0; i < minerals.length && count < maxGroups * 5; i++) {
            String mineral = minerals[i];
            if(mineral.equals("diamond")) {
                bundle[0] += 1;
            } else if(mineral.equals("iron")) {
                bundle[1] += 1;
            } else {
                bundle[2] += 1;
            }
            
            count++;
            if(count % 5 == 0 || i == minerals.length - 1) {
                bundles.add(Arrays.copyOf(bundle, bundle.length));
                bundle = new int[3];  // 새로운 구간을 위해 초기화
                
                // 캐야 할 그룹 수에 도달하면 중단
                if(bundles.size() >= maxGroups) {
                    break;
                }
            }
        }
        
        // 각 묶음의 돌 곡괭이 피로도 기준으로 내림차순 정렬
        Collections.sort(bundles, (a, b) -> {
            int fatigueA = a[0] * 25 + a[1] * 5 + a[2] * 1;
            int fatigueB = b[0] * 25 + b[1] * 5 + b[2] * 1;
            return fatigueB - fatigueA;
        });
        
        // 정렬된 번들에 곡괭이 할당
        for (int[] bundleData : bundles) {
            // 다이아몬드 곡괭이 사용
            if (picks[0] > 0) {
                picks[0]--;
                answer += bundleData[0] * 1 + bundleData[1] * 1 + bundleData[2] * 1;
            }
            // 철 곡괭이 사용
            else if (picks[1] > 0) {
                picks[1]--;
                answer += bundleData[0] * 5 + bundleData[1] * 1 + bundleData[2] * 1;
            }
            // 돌 곡괭이 사용
            else if (picks[2] > 0) {
                picks[2]--;
                answer += bundleData[0] * 25 + bundleData[1] * 5 + bundleData[2] * 1;
            }
        }
        
        return answer;
    }
}