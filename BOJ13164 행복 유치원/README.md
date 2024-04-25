# [13164] 행복 유치원

## 분류
> 그리디 알고리즘
>
> 정렬

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] children = new int[N];
        Integer[] diff = new Integer[N - 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            children[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(children);

        for(int i = 0; i < N - 1; i++){
            diff[i] = Math.abs(children[i] - children[i + 1]);
        }

        Arrays.sort(diff);

        int cost = 0;
        for(int i = 0; i < diff.length - K + 1; i++){
            cost += diff[i];
        }
        System.out.println(cost);
    }
}
```

## 문제풀이

[센서](https://github.com/narinn-star/Algorithm_JAVA/tree/master/BOJ2212%20%EC%84%BC%EC%84%9C) 문제와 동일하다. 풀이도 똑-같으므로 자세한 풀이는 생략하겠다. 

센서 문제는 문제 이해를 위해서 구글링을 하다가 풀이법도 알게되어서, 복습 차원에서 비슷한 문제가 있다고 해서 한 번 더 풀어보았다.
