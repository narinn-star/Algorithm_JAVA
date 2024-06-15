# [1806] 부분합

## 분류
> 누적 합
>
> 두 포인터

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0;
        int min = Integer.MAX_VALUE;

        while(start <= end && end <= N){
            if(sum < S){
                sum += arr[end++];
            } else if(sum >= S){
                min = Math.min(min, end - start);
                sum -= arr[start++];
            }
        }
        if(min == Integer.MAX_VALUE) bw.write("0" + "\n");
        else bw.write(min + "\n");

        bw.flush();
        bw.close();
    }
}

```

## 문제풀이

골드 문제인데도 실버 문제들보다 비교적 더 간단하게 풀이할 수 있었다.

sum에 합을 계속 더해주면서 넘을 때와 넘지 않을 때 두가지로만 나눠서 계산했다. sum이 S보다 작을 때는 arr값을 더해주고 end값을 증가시킨다. sum이 S보다 같거나 클 때는 최소길이 값을 갱신한 후에 sum 값에 더해져있던 맨 앞 값을 빼고 start를 증가시킨다.
