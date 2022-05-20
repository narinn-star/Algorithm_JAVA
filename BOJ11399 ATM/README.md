# [11399] ATM

## 분류
> 그리디 알고리즘
>
> 정렬

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] line = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(line);
		
		int sum = 0, tmp = 0;
		
		for(int i = 0; i < N; i++) {
			sum += tmp + line[i];
			tmp += line[i];
		}
		System.out.println(sum);
	}
}
```

## 문제풀이

문제를 잘 읽어보면, 오름차순으로 정렬해서 작은 것부터 하나씩 쌓아주면 된다는 것을 쉽게 알 수 있다. 그 대신, 그냥 쌓는 것이 아니라 이전에 쌓여있는 것에 또 다시 쌓아야 한다.

앞 사람이 1분을  사용하고, 그 뒷 사람이 2분을 사용한다면 두 번째 사람이 사용을 끝내는 시간은 총 3분이다. 그 다음 사람이 4분을 사용한다면 3 + 4로 7분이 되고, 또 다음 사람이 3분을 사용하면 7 + 3 = 10분이 되는 것이다.