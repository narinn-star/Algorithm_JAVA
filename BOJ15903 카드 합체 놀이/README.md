# [15903] 카드 합체 놀이

## 분류
> 자료 구조
> 
> 그리디 알고리즘
> 
> 우선순위 큐

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long res = 0;

        PriorityQueue<Long> pQueue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            pQueue.add(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < m; i++){
            long a = pQueue.poll();
            long b = pQueue.poll();
            pQueue.add(a + b);
            pQueue.add(a + b);
        }

        while(!pQueue.isEmpty()){
            res += pQueue.poll();
        }

        System.out.println(res);
    }
}

```

## 문제풀이

크게 어렵지 않았던 문제였지만 항상 놓치는 전제조건때문에 실패가 한 번 떴다..

int 범위를 넘어버리는 것 때문에 long으로 자료형을 고쳐주고 성공함..

문제는 작은 것 두개를 더하면 최소값이 자동으로 만들어지기 때문에 오름차순 디폴트값 그대로 사용했다!

