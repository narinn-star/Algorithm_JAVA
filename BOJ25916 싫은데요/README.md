# [25916] 싫은데요

## 분류
> 두 포인터

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ25916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, volume = 0;
        int max = Integer.MIN_VALUE;

        while(start < N){
            while(end < N && volume + arr[end] <= M){
                volume += arr[end];
                end++;
            }

            max = Math.max(max, volume);
            volume -= arr[start];
            start++;

        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
```

## 문제풀이

햄스터의 최대 부피를 사용해서 구멍을 막을 수 있는 부피를 구하는 문제다.

햄스터의 부피가 변할 수 있기 때문에 투 포인터로 풀었다.

맨 앞부터 end값을 증가시키면서 volume에 구멍 값을 더해준다. while 조건문에서 먼저 volume이 넘지 않는지 확인해준 후에 넘지 않는다면 volume에 더해주면 된다. 넘치게 되면 거기까지 막을 수 있기 때문에 최대 부피 값을 구해주고, start값을 증가해줘야한다. 증가 전에 arr[start]값을 volume에서 빼주기만 하면 된다.

투 포인터 문제들도 템플릿이 정해져있는 느낌이 샤악- 드는데,, 골드 문제 풀면 다르려나 이제 조금씩 기대가 되는 중 🫠

