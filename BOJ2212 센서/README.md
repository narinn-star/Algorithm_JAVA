# [2212] 센서

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
import java.util.StringTokenizer;

public class BOJ2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensor = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sensor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensor);

        int[] dist = new int[N - 1];
        for(int i = 0; i < N - 1; i++){
            dist[i] = Math.abs(sensor[i] - sensor[i + 1]);
        }
        Arrays.sort(dist);

        int sum = 0;
        for(int i = 0; i < dist.length - K + 1; i++){
            sum += dist[i];
        }

        System.out.println(sum);
    }
}
```

## 문제풀이

문제 이해가 너무너무너무 어려웠다.. 국어를 못하는 건가 싶을 정도였다. 

N개의 센서와 K개의 기지국이 있을 때 K개의 기지국이 담당하는 범위의 합이 최소여야 한다는 뜻이다.
즉, 5개의 센서와 2개의 기지국이 있을 때 두개의 기지국이 각각 담당하는 범위들이 작아야 그 합도 작아진다는 것이다.

예제 1번으로 설명하자면 6개의 센서와 2개의 기지국이라면 두 덩이로 나누어 기지국이 각각 담당해야 한다는 것인데, 1개/5개 2개/4개 .. 어떻게 나누어질지는 범위가 작은 것들 두개로 묶어야 각각 담당하는 범위가 작아진다는 뜻이다. 그렇게 하려면 우선 각 센서별 거리가 먼 것끼리는 한 기지국이 담당하게 될 수록 손해이므로 범위가 작은 순으로 나열해서 나눠야한다. 

1. 6개의 센서가 직선 상에 있다고 했으니, 우선 정렬을 해준다.
2. 정렬된 센서들의 각 거리를 구해준다.
3. 그 거리들은 다시 정렬을 해준다.
4. 기지국의 갯수에 따라서 알맞게 잘라 더해준다.

4번이 조금 설명이 애매한데, 센서들의 거리는 2개의 센서의 거리이므로, 만약 예제 1번의 각 센서 거리 배열이 [0, 1, 2, 2, 3]인 것을 예로 들면 가장 거리가 먼 3은 제외해야 하는 것이다. 즉, 1, 3 / 6, 6, 7, 9 이렇게 나누어야 하는데, 3 ~ 6의 거리가 가장 큰 것을 알 수 있고, 이를 제외하면 최소 합이 나온다. 

다른 설명들에서는 내림차순으로 정렬하고 K-1 ~ 마지막 까지의 합을 출력하면 된다고 하는데, 그게 그것임.. 나는 내가 이해한 대로 코드를 구현하려 이렇게 작성했지만 그게 그것임..!!! 

오랜만에 문제 자체 이해가 오래걸렸던 문제였다..
