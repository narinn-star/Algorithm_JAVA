# [1620] 나는야 포켓몬 마스터 이다솜

## 분류
> 자료 구조
>
> 해시를 사용한 집합과 맵

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] name = new String[N + 1];
		
		HashMap<String, Integer> list = new HashMap<>(N + 1);
		for(int i = 1; i <= N; i++) {
			name[i] = br.readLine();
			list.put(name[i], i);
		}
		
		for(int i = 0; i < M; i++) {
			String input = br.readLine();
			try {
				double num = Double.parseDouble(input);
				System.out.println(name[Integer.parseInt(input)]);
			}catch(NumberFormatException e) {
				System.out.println(list.get(input));
			}
		}
	}
}
```

## 문제풀이

HashMap으로 Key, Value 특징을 이용해서 풀었다. 처음에는 Key를 integer로, Value는 String으로 선언했는데 Value값으로 Key를 찾는 함수는 없는 것 같아서 Key를 String, Value를 Integer형으로 선언했다. 그리고 Key값은 따로 배열을 하나 더 만들어 Value값과 index값이 동일하게 한 값을 집어 넣었다.

그리고 M개의 문제가 주어질 때 각각 정수인지 문자열인지 판단하기 위해 try-catch문을 사용했다. Double형으로 변환했을 때 문제가 없으면 해당 정수를 인덱스로 가진 name배열의 값을 출력한다. 만약 catch문으로 넘어가게 되면 포켓몬 이름이 키값인 것을 찾아 get함수로 Value값을 출력한다.