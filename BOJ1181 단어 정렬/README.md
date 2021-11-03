# [1181] 단어 정렬

## 분류
> 정렬

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		
		for(int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length())
					return s1.compareTo(s2);
				else
					return s1.length() - s2.length();
			}
		});
		
		bw.write(str[0] + "\n");
		for(int i = 1; i <N; i++) {
			if(!str[i].equals(str[i-1]))
				bw.write(str[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
```

## 문제풀이

Arrays.sort를 이용한 정렬 문제이다. 단순 정렬만 시키면 영문자 순으로 정렬이 된다. 문제에서 원하는 것은 **"1. 길이가 짧은 것부터 2. 길이가 같으면 사전 순으로"** 이다. 

배열을 내가 원하는 규칙으로 정렬하고 싶으면 Arrays.sort의 Comparator를 오버라이딩하면 된다. String 배열을 사용하기 때문에 Comparator\<String>()으로 객체를 생성하면 되고 그 안에서 compare 메소드를 오버라이딩 한다. 

리턴 타입이 int인 이유는 **"양의 정수, 음의 정수, 0"** 이렇게 세가지 리턴 값이 있기 때문이다. 양수일 때에는 위치를 바꿔주고, 0이나 음의 정수인 경우에는 위치가 바뀌지 않는다. 

먼저 compare 메소드에서 s1과 s2의 길이를 비교한다. 길이가 같으면 사전순으로 정렬해야하기 때문에 compareTo 메소드를 사용한다. compareTo메소드는 아스키코드 값으로 비교하여 int형으로 리턴하며 이를 오름차순으로 정렬한다. 길이가 같지 않으면 그냥 짧은 것부터 정렬하면 되기 때문에 두 문자열의 길이 차를 리턴하면 된다. 

마지막에 출력할 때에는 같은 문자는 빼고 출력하기 때문에 이전 문자와 다를 경우에만 출력하도록 한다. 