# [11000] 강의실 배정

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

class Lecture {
    int start;
    int end;

    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class BOJ11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, (lec1, lec2) -> lec1.start == lec2.start ? lec1.end - lec2.end : lec1.start - lec2.start);

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pQueue.add(lectures[i].end);

            if (pQueue.peek() <= lectures[i].start) {
                pQueue.poll();
            }
        }

        System.out.println(pQueue.size());
    }
}
```

## 문제풀이

Comparator 오버라이딩 대신 람다 함수를 사용해봤다. 꽤 편한 정도가 아니라 너무 편한데욤.. 😅 
시작시간을 기준으로 오름차순으로 정렬해주었다. 빠른 수업 먼저 시작해야하기 때문이다. 

그리고 해당 수업의 끝나는 시간과 다른 수업의 시작시간을 비교하여 최소 강의실을 구해야하기 때문에, 끝나는 시간을 우선순위 큐에 넣어줬다. (빨리 끝나는, 즉 가장 작은 숫자 , 수업 뒤에 바로 다른 수업이 붙어야 강의실이 최소가 되기 때문) 처음엔 flag를 사용해서 끝나는 시간(숫쟈)보다 큰 수를 가진 시작 시간이 없으면 false, 있다면 true로 해두고 false라면 카운팅을 해주는 방법으로 했는데, 시간 초과로 아웃.. 

한참 고민하다 결국 다른 사람 풀이를 봤다.

거의 다했는디.. ㅠㅠ 반복문 하나 안에서 다 해결 가능한 거였슴.
반복문 들어가서 큐에 넣어주고, 뽑자마자 lectures[i].start와 비교해 크거나 같은 시작 시간이 있으면 큐에서 빼준다. 이를 반복하다보면 마지막에 큐에 남아있는 수만큼이 강의실 수가 된다.
뽑히지 않은 값들끼리 비교해서 작은 수가 나올테니.. 

조금 더 시간을 가지고 고민했으면 풀 수 있었을까 했지만 사실 큐 사이즈를 출력하는 방식은 생각지도 못했다..

어려워요😭
