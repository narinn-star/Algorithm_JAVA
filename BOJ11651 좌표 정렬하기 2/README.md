# [11651] 좌표 정렬하기 2

## 분류
> 정렬

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
				arr[i][0] = Integer.parseInt(str[0]);
				arr[i][1] = Integer.parseInt(str[1]);
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[1] == o2[1])
				return Integer.compare(o1[0], o2[0]);
			else
				return Integer.compare(o1[1], o2[1]);
		});
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		br.close();
	}
}
```

## 문제풀이

Arrays.sort를 이용해 2차원 배열을 정렬하는 문제이다. 보통 x좌표가 증가하는 순으로 정렬을 했다면, 이 문제에서는 Comparator인터페이스를 구현하여 y좌표가 증가하는 순으로 정렬하는 것이다. 

만약 y좌표가 같으면 x좌표가 증가하는 순서로 정렬한다. 

o1[1] == o2[1]이 y좌표가 같을 때를 나타내는 조건문이고, compare(o1[0], o2[0])은 x좌표끼리 비교하여 정렬하는 것이다. y좌표가 다를 때는 그대로 y좌표끼리 비교해서 정렬하면 된다.