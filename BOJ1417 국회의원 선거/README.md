# [1417] 국회의원 선거

## 분류
> 구현
>
> 자료 구조
> 
> 그리디 알고리즘
> 
> 시뮬레이션
> 
> 우선순위 큐

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int firstCan = Integer.parseInt(br.readLine());
        int cnt = 0;

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N - 1; i++) {
            pQueue.add(Integer.parseInt(br.readLine()));
        }

        while (!pQueue.isEmpty() && pQueue.peek() >= firstCan) {
            cnt++;
            firstCan++;
            pQueue.add(pQueue.poll() - 1);
        }

        System.out.println(cnt);
    }
}
```

## 문제풀이

첫 우선순위 큐 문제!

우선순위 큐는 일반적인 큐와 달리 우선순위를 지정해서 뽑아낼 수 있는 자료구조다. 
PriorityQueue<Integer> = queue = new PriorityQueue<>();와 같이 생성할 수 있다.

디폴트는 우선순위가 낮은 순이고, 높은 순으로 하려면 Collections.reverseOrder()을 통해 뒤집어줄 수 있다. 추가로, 우선순위를 다르게 지정하고 싶다면 override를 통해 작성할 수 있다.

이 문제는 다솜이를 기준으로, 큰 값을 꺼내어 비교 후 다시 삽입하는 것을 반복하는 문제다.
다솜이보다 크다면 다솜이를 + 1, 해당 값은 - 1하여 다시 큐에 넣어주고 다솜이보다 작다면 다솜이가 당선되는 순이기 때문에 while문을 탈출한다.

실버5라 그런가... 일단 처음 푸는 유형이라 재밌기도 했고 푸는데도 어려움은 없었다. 
