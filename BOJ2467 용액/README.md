# [2467] 용액

## 분류
> 이분 탐색
>
> 두 포인터

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467 {
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

이분 탐색 문제인데, 이분 탐색으로는 어떻게 접근해야할 지 몰라 투 포인터로 풀어보았다.
투 포인터도 처음 시도해본 건데, 손으로 로직을 작성해보니 왼쪽, 오른쪽에서 하나씩 땡겨오면 좋을 것 같다는 생각을 하고서 투 포인터라는 것을 알았다.

헷갈렸던 점은 sum을 미리 Math.abs()를 해주는가였다. 계속 sum에 절댓값을 담아두어서 오른쪽 왼쪽 값을 땡겨오는 데 오류가 생겼다. 

StringBuilder를 쓴 이유는 변수를 두 개 만들고 갱신하는 것 대신을 선택했는데, 초기화할 때 setLength(0)을 사용하는 것을 처음 알게 되었슴! 
