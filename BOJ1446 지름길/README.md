# [1446] 지름길

## 분류
> 다이나믹 프로그래밍
> 
> 그래프 이론
> 
> 데이크스트라
> 
> 최단 경로

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1446 {
    static class Drive {
        int start;
        int end;
        int shortcut;

        Drive(int start, int end, int shortcut) {
            this.start = start;
            this.end = end;
            this.shortcut = shortcut;
        }
    }

    private static List<Drive> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int shortcut = Integer.parseInt(st.nextToken());

            if (end - start <= shortcut || end > D) continue;
            list.add(new Drive(start, end, shortcut));
        }

        Collections.sort(list, (l1, l2) ->
                l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        int now = 0;
        int size = 0;
        int[] distance = new int[10001];
        Arrays.fill(distance, (int) 10001);
        distance[0] = 0;

        while (now < D) {
            if (size < list.size()) {
                Drive drive = list.get(size);
                if (drive.start == now) {
                    distance[drive.end] = Math.min(distance[drive.end], distance[now] + drive.shortcut);
                    size++;
                } else {
                    distance[now + 1] = Math.min(distance[now] + 1, distance[now + 1]);
                    now++;
                }
            } else {
                distance[now + 1] = Math.min(distance[now] + 1, distance[now + 1]);
                now++;
            }
        }
        System.out.println(distance[D]);
    }
}
```

## 문제풀이

문제를 다 풀고 보니 크게 어렵지 않았던 문제같긴 한데, 푸는데는 쪼금 걸렸다. 
1km마다 기록해줘야겠다는 생각이 늦게서야 들었기 때문.. 

애초에 지름길이 될 수 없는 값들은 입력받을 때부터 걸러서 리스트에 넣지 않았다.

리스트에 있는 값들을 먼저 기록해주기 위해 여기서는 size를 따로 만들어줬다. 먼저 list에 있는 값, 즉 입력받은 지름길을 먼저 다 기록해두고 나머지 값들은 +1씩 하면서 작은 값만 갱신해줬다. dp느낌인가..? 
처음엔 for 반복문으로 해주려했는데, 그럼 now 인덱스가 리스트 값들을 꺼낼때도 +1이 되어서 그냥 while문으로 바꿨다. 훨씬 간결하고 좋은듯..

정렬은 예제 3번 보고 나서야 했음.. 
