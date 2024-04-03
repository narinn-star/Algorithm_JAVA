# [11279] 최대 힙

## 분류
> 자료 구조
>
> 우선순위 큐

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input > 0){
                pQueue.add(input);
            }else {
                if(pQueue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pQueue.poll());
                }
            }
        }
    }
}

```

## 문제풀이

[1927 최소 힙](https://github.com/narinn-star/Algorithm_JAVA/tree/master/BOJ1927%20%EC%B5%9C%EC%86%8C%20%ED%9E%99)

다른 점은 뒤집어주는 것 뿐..

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
