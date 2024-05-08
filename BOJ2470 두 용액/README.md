# [2470] 두 용액

## 분류
> 정렬
> 
> 이분 탐색
>
> 두 포인터

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] liquid = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        int left = 0;
        int right = liquid.length - 1;

        long diff = Long.MAX_VALUE;

        while(left < right){
            long sum = liquid[left] + liquid[right];
            if(Math.abs(sum) < diff){
                diff = Math.abs(sum);
                sb.setLength(0);
                sb.append(liquid[left]).append(" ").append(liquid[right]);
            }
            if(sum >= 0) right--;
            else left++;
        }

        System.out.print(sb);
    }

}
```

## 문제풀이

[2467용액](https://github.com/narinn-star/Algorithm_JAVA/tree/master/BOJ2467%20%EC%9A%A9%EC%95%A1)
문제와 동일하나, 정렬만 추가된 문제다.

이분탐색으로 풀어보려 했지만 실패함 .. 

다른 분 코드를 참고해봤는데, 투 포인터가 더 적합해 보이기도 했고 이분탐색으로 풀어도 기본적인 로직 자체는 투포인터에서 가져오는 것 같았다. 
