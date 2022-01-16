# [10757] 큰 수 A+B

## 분류
> 수학
>
> 구현
>
> 사칙연산
>
> 임의 정밀도 / 큰 수 연산

## 코드
```java
import java.math.BigInteger;
import java.util.Scanner;

public class BOJ10757 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger A = new BigInteger(sc.next());
		BigInteger B = new BigInteger(sc.next());
		
		A = A.add(B);
		System.out.println(A.toString());
		sc.close();
	}
}
```

## 문제풀이

다른 방법도 있는데 자바에 있는 클래스를 사용해서 풀었다. 물론 이 클래스의 존재는 구글링을 통해 알아내긴 했지만, 기본적으로 짜여져 있는 툴을 사용하는 것도, 알아가는 것도 하나의 공부방법이라 생각한다. 

Long까지밖에 생각 못했는데, 찾아보니 예제에 나온 두 수 (9223372036854775807 9223372036854775808)가 Long을 넘는 수인데다, 두 수를 더했을땐 당연히 Long을 넘기 때문에 덧셈도 불가능하고 출력도 불가능했다. 다른 수식 필요없이 BigInteger 클래스를 이용하여 A와 B를 입력받고 두 수를 더하여 '문자열'으로 출력하면 된다.

BigInteger클래스에 관한 내용은 아래를 참고하면 된다.

[BigInteger 참고](https://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html)