# [2869] 달팽이는 올라가고 싶다

## 분류
> 수학

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int res = (V - B) / (A - B);

		if ((V - B) % (A - B) != 0)
			res++;

		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
```

## 문제풀이

while 반복문으로 나무 막대에서 A를 빼고 B를 더하는 계산을 하면 시간초과로 떠 한번에 계산하는 계산식으로 바꾸어 풀었다.

전체 나무 막대 길이에서 밤에 미끄러지는 B미터를 빼주고 (B는 음수일 것이므로 나무 막대 길이는 V 이상이 됨) 하루에 오를 수 있는 길이로 나누어준다.(A - B)

만약 이 계산 후에 나머지가 있다면 낮에 A미터 올라갔을 때 모두 오를 수 있다는 뜻이므로 출력값에 1을 더해준다.