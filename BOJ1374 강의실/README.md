# [1374] 강의실

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
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1374 {
    public static class Lecture {
        int number;
        int start;
        int end;
        Lecture(int number, int start, int end){
            this.number = number;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(number, start, end);
        }

        Arrays.sort(lectures, (lec1, lec2) -> lec1.start == lec2.start ? lec1.end - lec2.end : lec1.start - lec2.start);

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            pQueue.add(lectures[i].end);

            if(lectures[i].start >= pQueue.peek()) pQueue.poll();
        }
        System.out.println(pQueue.size());
    }
}

```

## 문제풀이

[강의실 배정](https://github.com/narinn-star/Algorithm_JAVA/tree/master/BOJ11000%20%EA%B0%95%EC%9D%98%EC%8B%A4%20%EB%B0%B0%EC%A0%95) 문제랑 똑-같다..

한참 고민하다가 풀었던지라 머리에 박혀있어서 바로 풀어내긴 했다. 풀이도 저거랑 똑같음 ㅠㅠ
강의 번호는 의미가 없는 거라.. 사실 객체에 넣지 않아도 된다.
