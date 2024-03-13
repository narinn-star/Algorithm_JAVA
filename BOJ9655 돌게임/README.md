# [9655] 돌게임

## 분류
> 수학
>
> 다이나믹 프로그래밍
>
> 게임 이론

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N % 2 == 0){
            System.out.println("CY");
        }else {
            System.out.println("SK");
        }
    }
}
```

## 문제풀이

분명히 DP 문제라고 해서 선택한 건데.. 이왜진

DP 푸는 것처럼 규칙 찾으려고 하나씩 적다보니 20까지 적었는데, 아무리 생각해봐도 이건 짝수면 무조건 창영이, 홀수면 상근이가 이기는 게임이다.

더 작성할 풀이가 없다....
다른 분의 풀이를 찾아보니 억지로(?) dp 배열을 만들어서 1000까지 넣어두고 인덱스가 짝수일 때, 홀수일 때 두가지 경우로 나눠 출력했던데 잘 모르겠다. 이거나 그거나..
