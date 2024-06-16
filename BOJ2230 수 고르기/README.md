# [2231] 부분합

## 분류
> 브루트포스 알고리즘

## 코드
```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;

        while(start < N && end < N){
            if(arr[end] - arr[start] < M){
                end++;
            }else{
                min = Math.min(min, arr[end] - arr[start]);
                start++;
            }
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}

```

## 문제풀이

수열에서 두 수의 차가 M이 넘을 때, 그 차가 가장 작은 것을 찾는 문제다.

정렬되지 않은 값들로 뒤죽박죽 찾아도 별 상관은 없겠지만 정렬되어 있으면 end값과 start값 조정이 조금 더 직관적이라, 정렬을 해준 후에 수를 선택했다. (지금 보니 end는 start + 1부터 시작해도 될 것 같다.) arr[end]와 arr[start]의 값의 차가 M이 넘지 않는다면 end값을 증가시켜 다시 비교해주고 M 이상이라면 문제에서 요구하는 최솟값의 경우가 있기 때문에 min값을 갱신해준 다음 start값을 증가시킨다. 

❗️while 조건문 범위를 잘 체크하자 ,,

