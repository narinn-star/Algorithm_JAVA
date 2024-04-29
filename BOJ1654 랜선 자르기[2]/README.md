# [1654] 랜선 자르기

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

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] ys = new int[K];

        long low = 1, high = 0;

        for(int i = 0; i < K; i++){
            ys[i] = Integer.parseInt(br.readLine());
            if(high < ys[i]) high = ys[i];
        }

        high++;

        while(low < high){
            long mid = (low + high) / 2;
            long cnt = 0;

            for(int i = 0; i < K; i++){
                cnt += (ys[i] / mid);
            }

            if(cnt >= N) low = mid + 1;
            else high = mid;
        }

        System.out.println(low - 1);
    }
}
```

## 문제풀이

어제 풀었던 나무 자르기와 다르지 않은 문제다. 

이 문제를 풀면서 맞닥뜨린 문제 두가지

1. 어떻게 이 문제가 이분탐색인 것을 알 수 있는가?
2. zerodivision 문제 해결

사실 이분탐색인 것은 이 문제가 이분탐색 문제인 것을 알고 풀어서 접근할 수 있었지만, 어떻게 알 수 있을지는 더 고민해봐야할 문제인 듯하다. 더 풀어보면 답이 나올까..

zerodivision 문제가 나무 자르기와 다른 점 한가지인데, 만약 N = 1, K = 1 그리고 영식이가 가진 랜선 하나의 길이가 1일 때 1 / 2 = 0이 되기 때문에 zerodivision 문제가 생기는데, 이는 최대값을 +1 해주는 것으로 해결할 수 있었다.
