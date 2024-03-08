# [2775] 부녀회장이 될테야

## 분류
> 수학
> 
> 구현
> 
> 다이나믹 프로그래밍
## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int array[][] = new int[15][15];

        for (int i = 0; i < 15; i++) {
            array[0][i] = i; // 0층 i호
            array[i][1] = 1; // i층 1호
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                array[i][j] = array[i][j - 1] + array[i - 1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(array[k][n]);
        }
    }
}

```

## 문제풀이

1. 어떤 규칙이 있는가
2. k층 n호는 어떻게 구하는가

제한으로 주어진 조건을 활용했다.
어차피 14층에 14호까지밖에 없기 때문에 과감하게 array[14][14]를 다 구했다.

0층 i호는 모두 i, i층 1호는 모두 1로 초기화해두고 시작한다.

1. 어떤 규칙이 있는지는 2층까지만 적어봐도 쉽게 알 수 있다.

2층 1호 : 1 | 2층 2호 : 4 | 2층 3호 10
1층 1호 : 1 | 1층 2호 : 3 | 1층 3호 6
0층 1호 : 1 | 0층 2호 : 2 | 0층 3호 3

2. 그래서 k층 n호는 어떻게 구하는가?
1층 2호 = 1층 1호 + 0층 2호, 
2층 3호 = 2층 2호 + 1층 3호
...

즉, array[k][n] = array[k][n-1] + array[k-1][n]인 것을 알 수 있다.

미리 다 구해두고 k, n을 입력받아 바로 출력해주었다.
