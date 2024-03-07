# [1436] 영화감독 숌

## 분류
> 브루트포스 알고리즘

## 코드
```java
import java.io.IOException;
import java.util.Scanner;

public class BOJ1436 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int a = 666;
        int cnt = 1;

        while (cnt < N) {
            a++;
            if (String.valueOf(a).contains("666")) cnt++;
        }
        System.out.println(a);

        sc.close();
    }
}

```

## 문제풀이

666, 1666, 2666 ... 30666까지 작성했다.. 도저히 아닌 것 같아 이전에 풀었던 풀이를 열어봤는데, 접근법이 완전 달라서 당황했다. 

아쉬운 점은 그 당시에도 접근 방법이 달라 검색을 했던 것이다..

1, 2, 3, 이렇게 붙여가는 게 아니라, 666에서 1씩 더하면서 666이 들어있을 때 카운팅을 해주는 것이다. 규칙을 따로 찾는 게 아니다. 어차피 1씩 더하는거고, 그 와중에 666이 들어있으면 카운팅을 하는 것이기 때문에 잘못 계산될 일도 없다.

카운팅된 값과 입력값이 같을 때의 666이 들어간 숫자를 출력하는 것이기 때문에 while문의 조건식을 cnt가 N보다 작을 때라 해두었다.
