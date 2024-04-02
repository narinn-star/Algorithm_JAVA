# [1927] 최소 힙

## 분류
> 자료 구조
> 
> 우선순위 큐

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input > 0){
                pQueue.add(input);
            }else {
                if(!pQueue.isEmpty()){
                    System.out.println(pQueue.poll());
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}
```

## 문제풀이

정답 비율이 왜 이렇게 낮은 것이죠..?

1. priorityQueue에 입력값을 넣는다.
1-1. 입력값이 0이라면 넣지 않는다.
2. 큐가 비어있지 않다면 바로 값을 꺼내 출력하고
3. 큐가 비어있다면 0을 출력한다.

priorityQueue는 낮은 수부터 꺼내는 것이 default이기 때문에 reverse를 해줄필요가 없다.
