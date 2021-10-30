# [4153] 직각삼각형

## 분류
> 수학
>
> 기하학

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c = Integer.parseInt(str[2]);
			if (a == 0 && b == 0 && c == 0) {
				break;
			} 
			else {
				if (a * a + b * b == c * c) {
					System.out.println("right");
				} 
				else if (a * a + c * c == b * b) {
					System.out.println("right");
				} 
				else if (b * b + c * c == a * a) {
					System.out.println("right");
				} 
				else {
					System.out.println("wrong");
				}
			}
		}
		br.close();
	}
}
```

## 문제풀이

직각삼각형의 조건 **"a^2 + b^2 = c^2"**만 생각하면 된다. 

딱 하나 주의할 점은 a, b, c 중 어느 것이 빗변이 될 지 모르기 때문에 조건문을 세개 모두 적는 것이다. 종료문은 모두 0일때로 해주고, while문으로 반복문을 실행하면 된다.

