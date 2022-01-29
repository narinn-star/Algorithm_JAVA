# [3053] 택시 기하학

## 분류
> 수학
>
> 기하학
>

## 코드
```java
import java.util.Scanner;

public class BOJ3053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double R = sc.nextDouble();
		
		System.out.println(R * R * Math.PI);
		System.out.println(2 * R * R);
		
		sc.close();
	}
}
```

## 문제풀이

택시 기하학? 이는 맨해튼 거리를 말한다. 맨해튼 거리의 원은 문제에서와 같이 유클리드 기하학에서의 원과는 조금 다르다. 우리가 알고있는 유클리드 기하학에서의 원은 𝜋𝑟²이라는 공식을 이용해 원의 넓이를 구할 수 있다.

맨해튼 거리에서 원은 좌표의 축으로 45도 기울어진 정사각형이다. (출처 : 위키백과)

◇ 이 모양이 되는 것. 각 변의 길이가 √2r이면, 넓이는 2r²이라는 공식이 나오게 된다. 

이를 바탕으로 유클리드 기하학에서의 원의 넓이와 택시 기하학(맨해튼 거리)에서의 원의 넓이를 출력하면 된다.

"맨해튼 거리"에 대해 알아볼 수 있는 문제.

