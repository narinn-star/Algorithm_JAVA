# [Programmers 게임 맵 최단거리] 

## 분류
> 깊이/너비 우선 탐색(DFS/BFS)

## 코드
```java
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

```

## 문제풀이

정말 쉬운 문제라 생각하고 셀렉 한건데, 해시맵까지 접근하는데도 정말 오래걸렸다. 너무 잘 쉬었나.. 아무튼 해시맵으로 카운팅을 해주고, 카운팅해준 값들을 다시 내림차순으로 정렬하는 과정이 필요해서 리스트에 다시 넣은 후에 내림차순으로 정렬해줬다.

어차피 다른 종류의 수를 '최소화'해야 하기 때문에 내림차순으로 정렬되어 있는 리스트에서 하나씩 꺼내서 빼준다. 빼주고 난 값이 0보다 작으면 이미 k개를 다 뽑아냈기 때문에 멈추면 된다. 

일주일 넘도록 투 포인터랑 슬라이딩 윈도우를 풀었더니, 생각의 흐름이 멈춘 느낌이다.. 이제 거의 모든 유형을 다 봐가는 것 같으니까 랜덤으로 풀면서 부족한 부분을 채워가야겠다.
