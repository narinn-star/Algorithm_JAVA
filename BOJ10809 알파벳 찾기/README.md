# [10809] 알파벳 찾기

## 분류
> 구현
>
> 문자열

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] res = new int[26];
		Arrays.fill(res, -1);
		
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			char alphabet = str.charAt(i);
			int a = alphabet - 'a';
			if(res[a] == -1)
				res[a] = i;
		}
		
		for(int i = 0; i < res.length; i++) {
			bw.write(res[i] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
```

## 문제풀이

알파벳 인덱스를 담을 배열을 먼저 -1로 초기화해준다. 

알파벳을 한 글자씩 char형에 담은 후에 아스키코드 값을 int형으로 담아준다. 만약 알파벳 인덱스 부분이 -1이라면 처음 등장한 알파벳을 배열에 인덱스값으로 넣어준다.

출력할 때에는 배열에 넣을 때 다 정리해주었기 때문에 반복문으로 바로 출력하면 된다.