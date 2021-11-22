# [10989] 수 정렬하기 3

## 분류
> 정렬

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BOJ10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(list);
		
		for(int i = 0; i < N; i++) {
			sb.append(list[i]).append('\n');
		}
		
		System.out.println(sb);
		br.close();		
	}
}
```

## 문제풀이

수 정렬하기 2 풀었을 때에는 Arrays.sort로 정렬했을 때 시간초과가 났다. 그저 Arrays.sort가 Collections.sort보다 시간 복잡도가 더 크다고 하고 넘어갔는데 이 문제는 시간보다 메모리가 더 중요한 문제라 그런지, Collections.sort를 썼을 때는 시간 초과가 아닌 메모리 초과가 나왔다.

문제를 다시 보니 수 정렬하기 2 문제는 시간 제한이 2초이고 이 문제는 시간 제한이 5초라 시간 복잡도보다 메모리 제한에 더 신경써야했던 것 같다.

+) StringBuilder를 처음 사용해봤는데 따로 사용법이 복잡한 것은 아니고, 계속 쌓아주다가 마지막에 쌓아 둔 것을 한번에 출력하는 방법이다. 아직 왜인지는 모르겠으나 BufferedReader 사용은 필수인데 BufferedWriter는 사용하는 사람이 드문 것 같다. 이 부분은 곧 공부해 봐야 할 것 같다.