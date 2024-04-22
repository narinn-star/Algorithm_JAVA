# [1715] 카드 정렬하기

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

public class BOJ1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((q1, q2) -> q1 - q2);

        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            priorityQueue.add(input);
        }

        int sum = 0;

        while(!priorityQueue.isEmpty()){
            if(priorityQueue.size() == 1){
                //sum = priorityQueue.poll();
                break;
            }else{
                int a = priorityQueue.poll();
                int b = priorityQueue.poll();
                sum += a + b;
                priorityQueue.add(a + b);
            }
        }

        System.out.println(sum);
    }
}
```

## 문제풀이

작은것부터 더하면 무조건 작은 값이 나오는 쉬운 문제다. 왜 골드4인지 잘 모르겠다.😅

더하기가 제일 어려운지 sum에 쌓아주는데 계속 원하는 값이 나오지 않았다. 문제는 큐에 1개 남아있을 경우였는데, 이 때 sum과 남은 하나를 더하면 너무 큰 값이 나오고 (틀린 값) 큐에 남은 값은 또 정답이 아니다. 디버깅을 돌려보니 당연히 마지막 값은 앞의 a + b를 해준 값을 넣은 것이기 때문에 필요없는 값이라, 아무 처리를 해주지 않아도 된다.
즉, while문의 조건식을 priorityQueue.size() != 1로 해두면 코드도 더 간결해지고 좋을 것 같다.
