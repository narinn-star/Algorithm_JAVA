# [Leetcode 1046] Last Stone Weight

## 분류
> Array
> 
> Heap (Priority Queue)

## 코드
```java
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0, len = stones.length; i < len; i++){
            pq.add(stones[i]);
        }

        while(!pq.isEmpty()){
            if(pq.size() == 1) return pq.poll();

            int y = pq.poll();
            int x = pq.poll();

            if(x == y) continue; // destroyed
            else {
                pq.add(y - x);
            }
        }

        return 0;
    }
}
```

## 문제풀이

우선순위 큐 문제인지는 몰랐다.. 우선순위 큐를 안쓰면 계속 Arrays.sort()를 해줘야해서, 우선순위 큐가 맞는 것 같다.

우선 모두 넣어두고 나서 두개를 빼는데 먼저 뺀 값이 더 크기 때문에 y, 그 다음은 x 로 해두고 x == y일 땐 그냥 뺀 상태, x != y 일땐 y - x를 새로 넣어준다. 우선순위 큐의 크기가 1일 때는 두개를 못빼기도 하고, 1개가 남았을 때 남은 걸 빼준다.

while문을 빠져나왔다는 것은 큐가 비어있다는 뜻이므로, 0을 리턴해주면 된다.
