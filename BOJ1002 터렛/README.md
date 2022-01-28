# [1002] 터렛

## 분류
> 수학
>
> 기하학

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
            
			System.out.println(point(x1, y1, r1, x2, y2, r2));
		}
	}
	
	public static int point(int x1, int y1, int r1, int x2, int y2, int r2) {
		
		int dis = (int)(Math.pow(x2- x1, 2) + Math.pow(y2-y1, 2));
		
		if(x1 == x2 && y1 == y2 && r1 == r2)	
            //두 원이 완전 똑같을 때(접점 무한개)
			return -1;
		
		else if(dis > Math.pow(r1 + r2, 2))		
            //중점간 거리 > 두 원 반지름 합 (아예 안만남, 접점 0개)
			return 0;
		
		else if(dis < Math.pow(r2 - r1, 2))		
            //중점간 거리 < 두 원 반지름 차 (한 원 안에 다른 원이 있음, 접점 0개)
			return 0;
		
		else if(dis == Math.pow(r2 - r1, 2))	
            //중점간 거리 == 두 원 반지름 차 (내접할 때 _ 딱 맞물림, 접점 1개)
			return 1;
		
		else if(dis == Math.pow(r1 + r2, 2))	
            //중점간 거리 == 두 원 반지름 합 (외접할 때 _ 딱 맞물림, 접점 1개)
			return 1;
		
		else
			return 2;
	}
}
```

## 문제풀이

문제 이해하는데 어려움이 있었다. 일단 터렛이 뭔지도 모르겠고, 류재명(적)이 위치할 수 있는 곳의 조건?들이 조규현과 백승환이 계산한 거리와 어떤 관련이 있는지도 이해가 안가서 검색을 했더니 그냥 두 원 접점 구하는 문제였다.. 가끔 이런 문제를 보면 (아직 내가 이해도가 부족하다는 것이겠지만..) 코드를 작성하는 것보다 문제이해가 어려우면 어떻게 풀으라는 건지 모르겠다는 생각도 든다..

아무튼, 접점을 구하는 문제이므로, 하나씩 따져보면 된다. 접점은 총 4가지가 나올 수 있다.(0, 1, 2, 무한개)

2개가 나올 수 있는 경우는 너무 많기때문에 우선 다른 것부터 구해보자.

+ 무한개가 되려면

1) 완전히 겹치는 수밖에 없다. 그러므로 두 원의 중심과 반지름이 완전히 같아야 한다.

+ 접점이 0개가 되려면 

2-1) 아예 따로 원이 그려지는 경우. 반지름의 <b>합</b>보다 두 원의 중심간 거리제곱이 <b>더 커야</b>한다.

2-2) 하나의 원 안에 다른 원이 그려지는 경우. 반지름의 <b>차</b>보다 두 원의 중심간 거리제곱이 <b>더 작아야</b>한다.

+ 접점이 1개가 되려면

3-1) 내접하는 경우. 반지름의 <b>차</b>와 두 원의 중심간 거리제곱이 <b>같아야</b>한다.

3-2) 외접하는 경우. 반지름의 <b>합</b>과 두 원의 중심간 거리제곱이 <b>같아야</b>한다.

+ 접점이 2개가 되는 방법은 위의 다섯가지 빼고 모두 해당되기 때문에 else문에 넣어주면 된다.

내접하는 경우가 조금 까다롭긴 했지만, 그림 그려보면 모두 당연한 얘기들..

풀고 나서도 여전히 터렛이 뭔지는 모르겠다 