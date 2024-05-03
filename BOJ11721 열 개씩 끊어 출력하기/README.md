# [11721] 열 개씩 끊어 출력하기

## 분류
> 구현
>
> 문자열

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = br.readLine();

        for (int i = 0; i < inputStr.length(); ++i) {
            System.out.print(inputStr.charAt(i));
            if (i % 10 == 9) {
                System.out.println();
            }
        }
    }
}
```

## 문제풀이

풀이 생략
