# [1072] 게임

## 분류
> 수학
>
> 이분 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long Z = 100 * Y / X;

        if(Z==100 || Z == 99){
            System.out.println(-1);
            return;
        }

        int low = 0, high = (int)1e9;

        while(low < high){
            int mid = (low + high) / 2;
            long newZ = 100 * (Y + mid) / (X + mid);

            if(Z < newZ){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        System.out.println(high);
    }
}
```

## 문제풀이

최대값을 어떤걸로 설정해야할지 그리고 -1이 나와야할 조건 두가지가 가장 어려웠다.

최댓값은 문제에서 제시한 최댓값인 10억으로 설정해주었고, 이분탐색으로 풀었다.

-1이 될 조건은 승률이 100일때만을 생각했는데, 99일때도 100이 될 수 없기 때문에 99와 100 두가지를 조건으로 넣어줘야한다. 소수점을 버려주기 때문이 아닐까.

어려워어려워😢
