# [1300] K번째 수

## 분류
> 이분 탐색
>
> 매개 변수 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int min = 0, max = k;
        int res = 0;

        while(min <= max) {
            int mid = (min + max) / 2;
            int cnt = 0;

            for(int i = 1; i <= N; i++){
                cnt += Math.min(N, mid / i);
            }

            if(cnt < k) {
                min = mid + 1;
            }else {
                max = mid - 1;
                res = mid;
            }
        }
        System.out.println(res);
    }
}
```

## 문제풀이

첫번째 골드1문제 너무 어려웠다 😰

'갯수'로 접근하는 방법은 다른 코드를 참고했다. 

Math.min(N, mid / i)는 그 갯수를 구하는 방법인데, 구구단을 참고하면 쉽다.

1단 : 1, 2, 3, 4, 5, 6 ...
2단 : 2, 4, 6, 8, 10 ...
3단 : 3, 6, 9, 12, 15 ...

만약 4보다 작거나 같은 수의 갯수를 구하려면 i단에서는 4 / i로 구할 수 있다. 

만약 이렇게 구해진 cnt가 k보다 작으면 시작 범위를 키워주고, k보다 크다면 끝 범위를 줄여가며 구해주면 된다.
