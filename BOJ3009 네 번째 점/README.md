# [3009] 소트인사이드

## 분류
> 구현
>
> 기하학

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] point1 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		st = new StringTokenizer(br.readLine(), " ");
		int[] point2 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		st = new StringTokenizer(br.readLine(), " ");
		int[] point3 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		
		int x, y;
		
		if(point1[0] == point2[0])
			x = point3[0];
		else if(point1[0] == point3[0])
			x = point2[0];
		else 
			x = point1[0];
		
		if(point1[1] == point2[1])
			y = point3[1];
		else if(point1[1] == point3[1])
			y = point2[1];
		else
			y = point1[1];
		
		System.out.println(x + " " + y);
		br.close();
	}
}
```

## 문제풀이

직사각형을 만드는 것이므로, 각 좌표의 짝을 찾아주고, 짝이 없는 것을 x, y 좌표에 할당해주면 끝나는 문제.