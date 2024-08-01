# [18110] solved.ac

## 분류
> 수학
>
> 구현
> 
> 정렬

## 코드
```java
import java.io.*;
import java.util.Arrays;

public class BOJ18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int except = (int)Math.round(N * 0.15);
        int all = N - (except * 2);
        double sum = 0;
        for(int i = except; i < N - except; i++){
            sum += arr[i];
        }

        bw.write(Math.round(sum / all) +"");
        bw.flush();
        bw.close();
        br.close();
    }
}
```

## 문제풀이

정답률이 낮아서 걱정아닌 걱정을 했는데,, 왜 정답률이 낮은지 신기했던,, 😅

절삭 평균에 대해서도 잘 설명되어 있어서 Math.round()함수 만으로도 충분히 해결할 수 있는 간단한 수학문제다.  
다만, sum을 double로 해야 전체로 나누었을 때 값이 소수점이 나와 round를 했을 때 반올림이 가능하다. 그것만 빼면 하나도 어려울 게 없는 문제였슴니다 ~
