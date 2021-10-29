# [1085] 직사각형에서 탈출

## 분류
> 수학
>
> 기하학

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		
		int min = 1001;
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		int w = Integer.parseInt(str[2]);
		int h = Integer.parseInt(str[3]);
		
		min = Math.min(min, Math.abs(x-w));
		min = Math.min(min, Math.abs(y-0));
		min = Math.min(min, Math.abs(y-h));
		min = Math.min(min, Math.abs(x-0));
	
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
```

## 문제풀이

현재 위치에서 최대로 갈 수 있는 위치까지의 거리를 모두 min에 각각 담아 비교한 후에 바로 min으로 설정해두면 된다. 마지막에는 min을 출력한다.