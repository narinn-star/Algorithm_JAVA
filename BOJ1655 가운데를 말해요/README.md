# [1655] 랜선 자르기

## 분류
> 자료 구조
>
> 우선순위 큐

## 코드
```java
import java.io.*;
import java.util.*;

public class BOJ1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            bw.write(br.readLine());
            bw.flush();
            bw.close();
            return;
        }

        PriorityQueue<Integer> pQueue1 = new PriorityQueue<>(Collections.reverseOrder()); // 큰거부터
        PriorityQueue<Integer> pQueue2 = new PriorityQueue<>(); // 작은거부터

        for(int i = 0; i < N; i++){
            int inputNum = Integer.parseInt(br.readLine());

            if(pQueue1.size() == pQueue2.size()){
                pQueue1.add(inputNum);

                if(!pQueue2.isEmpty() && pQueue1.peek() > pQueue2.peek()){
                    pQueue2.add(pQueue1.poll());
                    pQueue1.add(pQueue2.poll());
                }
            }else {
                pQueue2.add(inputNum);

                if(pQueue1.peek() > pQueue2.peek()){
                    pQueue2.add(pQueue1.poll());
                    pQueue1.add(pQueue2.poll());
                }
            }
            bw.write(pQueue1.peek() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
```

## 문제풀이

리스트에 담아서 len/2로 가운데 값을 찾는 것은 사실 우선순위 큐의 필요성이 없어지기 때문에 시도하지 않았다. 당연히 시간초과가 날 것 같기도 하고.

우선순위 큐 문제인걸 알고 풀었으니 일단 우선순위 큐를 선언하고 곰곰히 생각해보긴 했는데, peek하고 나서 그 값들을 기억하는 것에는 한계가 있다고 느꼈다. 친구의 도움으로 2개의 큐를 선언해서 사용하는 아이디어를 얻어서 하나는 오름차순, 그리고 다른 하나는 내림차순으로 정렬하는 방법으로 풀고자 했다.

첫번째 시도는 예제를 예로 들면
1.
queue1 : 1
queue2 : 5

2.
queue1 : 1 2
queue2 : 5

3.
queue1 : 1 2
queue2 : 5 10 

...

queue2.peek()을 했을 때 input값이 더 크면 queue2에, input값이 더 작으면 queue1에 넣는 방식을 하고자 했다.
하지만 반례 5 10 15 20 11 12 11 4  14 11 로 살펴보면, 모두 다 무너지는 것을 알 수 있었음..

그래서 넣을 때마다 값을 비교해주는 방식을 선택했다.
그 기준을 size로 정했고, size가 같을 때는 왼쪽에, size가 다를 때는 오른쪽에 넣고 동일하게 비교한 후 알맞은 자리를 찾아준다. 
양쪽에 사이즈도 잘 맞아 들어가고, 중간값도 잘 찾아짐..!!

어려워요 골드2 ㅠㅠ!!
