# [1789] 수들의 합

## 분류
> 수학
>
> 그리디 알고리즘

## 코드
```java
import java.util.Scanner;

public class BOJ1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long sum = 0;
        int cnt = 0;

        if(N == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (sum > N) break;
            sum += i;
            cnt++;
        }

        System.out.println(cnt - 1);
    }
}
```

## 문제풀이

N이 될때까지 계속 1부터 차례로 더해주는것이 빈 값이 없기 때문에 갯수가 최대가 될 수 있다.
단, N이 넘는 순간 틀리기 때문에 cnt값과 반복문 탈출만 잘 해주면 어렵지 않게 풀어낼 수 있다.
1을 저렇게 따로 조건을 걸어두는 것이 맞는지 모르겠지만...😅 어차피 1일때는 1이 고정이니까 그냥 저렇게 해뒀다.
