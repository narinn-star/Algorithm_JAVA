# [17219] 비밀번호 찾기

## 분류
> 자료 구조
>
> 해시를 사용한 집합과 맵

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ17219 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> password = new HashMap<>(N);
		
		for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				password.put(str[0], str[1]);
		}
		
		for(int i = 0; i < M; i++) {
			bw.write(password.get(br.readLine()) + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
```

## 문제풀이

HashMap으로 간단하게 풀 수 있는 문제.

아직도 StringTokenizer는 왜 터지는 지 이해가 잘 안가지만 그냥 split() 함수를 이용해서 적절히 잘라 작성했다. 

특별히 어려운 부분은 없으니 자세한 해설은 생략..!

