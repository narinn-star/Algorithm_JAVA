# [1764] 듣보잡

## 분류
> 자료 구조
>
> 문자열
>
> 정렬
>
> 해시를 사용한 집합과 맵

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			if(set.contains(name)) {
				list.add(name);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(String s : list) {
			System.out.println(s);
		}
		br.close();
	}
}
```

## 문제풀이

단순 for문 만으로는 시간 초과 때문에 풀리지 않았다. 

**HashSet**은 중복되는 요소를 허용하지 않는다는 특징을 가지고 있어 이를 이용해야한다. 사용 방법은 ArrayList<>와 비슷하며, 크게 어렵지는 않다. 

HashSet을 알고 있었다고 이 문제를 바로 HashSet을 적용해 풀 수 있었을지에 대한 생각이 들긴 한다만.. 우선 한 가지를 더 알아 간다는 마음으로 받아들이기로 했다. 

로직은 set에 들어 있으면 새로운 ArrayList에 추가하는 단순한 방법으로 작성했다.

아래는 시간 초과로 틀렸던 코드.

```java
public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] n = new String[N];
		String[] m = new String[M];
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			n[i] = br.readLine();
		}
		for(int i = 0; i < M; i++) {
			m[i] = br.readLine();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(n[i].equals(m[j])) {
					cnt++;
					list.add(n[i]);
				}
			}
		}
		Collections.sort(list);
		System.out.println(cnt);
		
		for(String s : list) {
			System.out.println(s);
		}	
	}
```

