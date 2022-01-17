# [11653] 소인수분해

## 분류
> 수학
>
> 정수론
>
> 소수 판정

## 코드
```java
import java.util.Scanner;

public class BOJ11653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for(int i = 2; i <= Math.sqrt(N); i++) {
			while(N % i == 0) {
				System.out.println(i);
				N /= i;
			}
		}
		if(N != 1)
			System.out.println(N);
		sc.close();
	}
}
```

## 문제풀이

간단하게 소수를 구해서 더이상 나누어지지 않을 때까지 나누는 것! 

1일때는 아무것도 출력하지 않는다고 했기때문에 2부터 루트N까지 반복하여 나누었을 때 0이 되면 출력하도록 하고, N은 i로 나눈 몫으로 계속해서 초기화시켜준다. 반복문이 끝나면, 1이 아닐때만 마지막에 저장된 N값까지 출력해주면 된다.