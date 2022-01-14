# [10250] ACM 호텔

## 분류
> 수학
>
> 구현
>
> 사칙연산

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String[] data = br.readLine().split(" ");
			int H = Integer.parseInt(data[0]);
			int W = Integer.parseInt(data[1]);
			int N = Integer.parseInt(data[2]);
			
			int tmp = N % H;
			int result = 0;

			if(tmp == 0)
				result = (H * 100) + (N / H);
			else {
				result = ((tmp) * 100) + (N / H) + 1;
			}
			
			System.out.println(result);			
		}
		br.close();
	}
}
```

## 문제풀이

문제는 아주 길고, 왠지 배열을 선언해야할 것 같지만 수학적인 사고만으로 그냥 풀 수 있는 문제였다. 문제를 읽고 이해해보면 W는 사실 필요도 없다는 걸 알 수 있다.

우선 H, W, N을 차례로 입력받고 반복되는 연산 N % H의 값을 담는 변수와 결과를 출력할 변수 하나를 선언한다. 만약 나머지가 0일 경우, 즉 H = 8, N = 8일 경우에는 무조건 층수는 8층이므로 (H * 100)을, 그리고 거리는 높이에서 N을 나눈 몫이다. (H = 8, N = 8 -> 801호, H = 8, N = 16 -> 802호)

나머지가 0이 아닐 경우는 아주 조금 식이 달라진다. 즉 H = 8, N = 10일 경우에는 층수가 2로, tmp값과 일치함을 알 수 있다. 그래서 tmp * 100을 층수로 지정하면 된다. 거리는 높이에서 N을 나눈 몫에 1을 더한 값이다. 그 이유는 당연한 것이지만 나머지가 0이 나오는 H = 8, N = 7인 경우는 1호를, 나머지가 1이 나오는 H = 8, N = 9인 경우는 2호를 배정받아야하기 때문이다.

간단한 수학문제이기 때문에 수학적인 설명에 집중하는것이 나을 것 같다.