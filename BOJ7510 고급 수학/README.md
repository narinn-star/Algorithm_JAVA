# [7510] 고급 수학

## 분류
> 수학
>
> 기하학
>
> 피타고라스 정리

## 코드
```java
import java.util.Arrays;
import java.util.Scanner;

public class BOJ7510 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] length = new int[3];
		
		for(int i = 1; i <= n; i++) {
			String res = "no";
			for(int j = 0; j < 3; j++) {
				length[j] = sc.nextInt();				
			}
			Arrays.sort(length);
			if(length[2]*length[2] == length[0]*length[0] + length[1]*length[1])
				res = "yes";
			System.out.println("Scenario #" + i +":");
			System.out.println(res);
			System.out.println();
		}
		sc.close();
	}
}
```

## 문제풀이

피타고라스 정리 문제. 빗변 제곱은 나머지 두 변길이의 제곱을 합한것과 같다는 피타고라스 정리를 이용하여 간단하게 풀 수 있는 문제이다. 하지만 어떤 것이 빗변인지 알 수 없기 때문에 배열에 입력받아 정렬을 해주었다. 빗변은 가장 긴 변이기 때문에 length[2]에 담긴것이 무조건 빗변이 된다. 

출력문은 예시에서 보이는것과 같이만 출력해주면 된다.