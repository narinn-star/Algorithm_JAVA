# [11650] 좌표 정렬하기

## 분류
> 정렬

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11650 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][]arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
				arr[i][0] = Integer.parseInt(str[0]);
				arr[i][1] = Integer.parseInt(str[1]);
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}
			else
				return Integer.compare(o1[0], o2[0]);
		});
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
```

## 문제풀이

Arrays.sort를 이용해 2차원 배열을 정렬하면 되는 문제이다.

Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0])); 는 0번째 값을 기준으로 비교하는 것을 의미한다. 우리는 0번째 값이 같을 때 1번째 값도 비교해주어야 하기 때문에 그에 맞게 정렬을 해주면 된다. 0번째 값이 같을 때는 1번째 값을 비교해서 정렬하고, 0번째 값이 다를 때는 그냥 0번째끼리만 비교하면 된다.