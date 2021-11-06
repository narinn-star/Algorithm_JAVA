# [10814] 나이순 정렬

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

public class BOJ10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[][] str = new String[N][2];
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			str[i][0] = s[0];
			str[i][1] = s[1];
		}
		
		Arrays.sort(str, new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				return (Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]));
			}
		});
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				bw.write(str[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
```

## 문제풀이

정렬문제. 나이와 이름 두가지를 받아서 나이순대로 정렬해주는 문제이다. 

당연히 2차원 배열로 나이와 이름을 받아 각각 저장하고 나이만 int형으로 바꾸어 비교해주면 된다.

나이순으로 정렬을 해주기 위해 Comparator 메소드를 오버라이딩해준다. 나이끼리 비교해서 양수일 경우 자리를 바꾸도록 return에 s1[0] - s2[1]을 해준다.

Comparator 메소드를 오버라이딩 해주는 것과 어떤식으로 비교해야할지는 감이 잡히지만 아직 음의 정수, 0, 양의 정수를 비교해 반환해주는 원리는 한번에 떠오르지 않았던 것 같다.