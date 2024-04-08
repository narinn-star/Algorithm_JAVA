# [13904] 과제

## 분류
> 자료 구조
> 
> 그리디 알고리즘
>
> 정렬
> 
> 우선순위 큐

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13904 {
    static class Task {
        int deadline;
        int point;

        Task(int deadline, int point) {
            this.deadline = deadline;
            this.point = point;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Task> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            list.add(new Task(deadline, point));
        }

        Collections.sort(list, (ol, o2) -> ol.deadline - o2.deadline);

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i = 0; i < list.size(); i++){
            pQueue.add(list.get(i).point);
            if(pQueue.size() > list.get(i).deadline){
                pQueue.poll();
            }
        }

        int res = 0;
        while(!pQueue.isEmpty()){
            res += pQueue.poll();
        }

        System.out.println(res);
    }
}
```

## 문제풀이

❗️꼭 다시 풀어보기

