# [2110] 공유기 설치

## 분류
> 이분 탐색
>
> 매개 변수 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] home = new int[N];

        for(int i = 0; i < N; i++){
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int min = 1, max = home[N - 1] - home[0];
        int dist = 0;

        while(min <= max){
            int mid = (min + max) / 2;
            int wifi = 0;
            int cnt = 1 ;
            
            for(int i = 1; i < N; i++){
                if(home[i] - home[wifi] >= mid) {
                    cnt++;
                    wifi = i;
                }
            }

            if(cnt >= C) {
                dist = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(dist);
    }
}
```

## 문제풀이

문제 이해가 너무 어려웠다.. 국어가 안되는 것인지 문제가 이상한 것인지 문제가 이상하게 쓰여져있는 건지 잘 모르겠지만.. 다른 분들이 문제 이해하는 것을 써둔걸 많이 참고해서 풀었다.
순차탐색으로 풀어도 되지만, 좌표가 10억까지 나올 수 있기 때문에 시간을 고려해 이분탐색으로 푸는 것이 맞다고 판단했다.

이 문제에서 포인트는 공유기간 '거리'를 중점으로 구하는 것이다. 그래서 min값도 거리의 최솟값, max도 거리의 최댓값으로 두고 풀어야한다. 결국 구하고자하는 것이 최소 거리의 최댓값이기 때문이다.

1 2 4 8 9를 예시로 들면, min = 1, max = 9이며 mid 는 4가 된다.
4일 때는 1에 설치, 8에 설치 총 2개를 설치할 수 있지만 공유기는 3개를 설치해야하기 때문에 거리를 늘려 더 많은 공유기를 설치할 수 있도록 하는 것이다.
만약 거리를 늘렸을 때 공유기를 문제에서 제시한 것 보다 많이 설치되었다면 거리를 줄이면서 반복하면 된다.

