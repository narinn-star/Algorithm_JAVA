import java.util.*;
public class Pro귤_고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> hMap = new HashMap<>();

        for (int i = 0, n = tangerine.length; i < n; i++) {
            hMap.put(tangerine[i], hMap.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> arr = new ArrayList<>();
        for (Integer val : hMap.values()) {
            arr.add(val);
        }

        Collections.sort(arr, Collections.reverseOrder());
        for (Integer a : arr) {
            answer++;
            k -= a;
            if (k <= 0) break;
        }

        return answer;
    }
}
