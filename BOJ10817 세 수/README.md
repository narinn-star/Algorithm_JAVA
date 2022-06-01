# [10817] 세 수

## 분류
> 구현

## 코드
```java
import java.util.Arrays;
import java.util.Scanner;

public class BOJ10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		
		for(int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.println(arr[1]);
		
		sc.close();
	}
}
```

## 문제풀이

아마 예전이었으면 그냥 if문으로 해결하지 않았을까 ..? 그냥 직접 정렬을 했을 수도 있고.

시간으로 봐도 Arrays.sort가 느린 것은 아니기에, BufferedReader이랑 같이 썼으면 시간을 제일 줄일 수 있을 것 같다.

