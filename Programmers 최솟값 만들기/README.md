# [Programmers 최솟값 만들기]

## 분류
> 연습문제

## 코드
```java
import java.util.Arrays;
import java.util.Comparator;

public class Pro최솟값_만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Integer[] tmpB = new Integer[B.length];

        for(int i = 0; i < tmpB.length; i++){
            tmpB[i] = new Integer(B[i]);
        }

        Arrays.sort(A);
        Arrays.sort(tmpB, Comparator.reverseOrder());

        for(int i = 0; i < A.length; i++){
            answer += A[i] * tmpB[i];
        }

        return answer;
    }
}
```

## 문제풀이

Arrays.sort()나 Collections.sort()에서 Comparator를 사용할 때는 int[]는 안되고 Integer[]만 되는 걸 알았다.. 그냥 B[B.length - i - 1]을 해줘도 되긴 한데, new Integer()으로 int -> Integer를 해줄 수 있는 방법이 있어서 해봤삼.. !
