# [2750] 수 정렬하기

## 분류
> 구현
>
> 정렬

## 코드
```java
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
		sc.close();
	}
}
```

## 문제풀이

Arrays.sort()를 사용하는 문제. 

간단하게 풀 수 있는 문제이므로 자세한 설명은 생략─