# [14888] 연산자 끼워넣기

## 분류
> 수학
>
> 브루트포스 알고리즘

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x = 0, y = 0;

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if ((a * i) + (b * j) == c && (d * i) + (e * j) == f) {
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(x + " " + y);

    }
}


```

## 문제풀이
그냥 -999부터 999까지 전체 탐색(브루트포스)하며 해당하는 i와 j가 같으면 x, y에 담아 출력하기만 하면 된다.

