# [21921] 블로그

## 분류
> 누적 합
> 
> 슬라이딩 윈도우


## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ansCnt = 1, sum = 0;

        for(int i = 0; i < X; i++){
            sum += arr[i];
        }
        int max = sum;

        for(int i = X; i < N; i++){
            sum = sum - arr[i - X] + arr[i];

            if(max == sum){
                ansCnt++;
            }else if(max < sum){
                max = sum;
                ansCnt = 1;
            }
        }

        if (max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(ansCnt);
        }
    }
}
```

## 문제풀이

범위가 정해져 있기 때문에 슬라이딩 윈도우로 풀었다.
3번이나 틀렸는데 그 이유는 다음과 같다..

1. 첫번째 범위의 값을 구해두지 않고
2. 빼주고 더해주는 연산이 없었고
3. max != sum일 때 무조건 ansCnt를 1로 바꾸고 max도 sum으로 초기화해줬다.

이것빼면 위의 로직이 됨..
