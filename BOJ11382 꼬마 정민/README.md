# [11382] 꼬마 정민

## 분류
> 수학
>
> 구현
>
> 사칙연산

## 코드
```java
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class BOJ11382 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BigInteger A = new BigInteger(sc.next());
        BigInteger B = new BigInteger(sc.next());
        BigInteger C = new BigInteger(sc.next());

        System.out.println(A.add(B).add(C));
    }
}
```

## 문제풀이

입출력에 하나가 새로 떠서 풀었는데.. 
아무생각 없이 int로 입력받았다가 런타임 에러가 떴다.

아무리 쉬운 문제라도 입출력 조건을 꼼꼼히 보자!
