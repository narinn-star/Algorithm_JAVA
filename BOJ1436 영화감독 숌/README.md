# [1436] 영화감독 숌

## 분류
> 브루트포스 알고리즘

## 코드
```java
import java.util.Scanner;

public class BOJ1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a = 666;
		int cnt = 1;
		
		while(cnt != N) {
			a++;
			
			if(String.valueOf(a).contains("666"))
				cnt++;
		}
		System.out.println(a);
		sc.close();
	}
}
```

## 문제풀이

![image-20211104122350568](C:\Users\skfls\AppData\Roaming\Typora\typora-user-images\image-20211104122350568.png)

처음엔 이렇게 규칙을 찾았다. xx6660이 될 때와 xx6669에서 다음수로 넘어갈 때 규칙만 바꾸어주면 될거라 생각했는데, 자릿수를 하나씩 찾는게 너무 어렵다는 생각이 들었다. int형이 아닌 문자열로 입력을 받아야하는 것인지 궁금하기도 하고, 어떻게 잘라야하는지 감이 안와서 검색을 했다.

좋은 메소드가 있어서 금방 풀었다. contains()메소드는 해당 문자열 안에 검사하려는 문자열이 포함되어 있는지 검사하고 true 또는 false를 반환한다.

666이 들어있는지 검사하는 것이므로, 계속 1씩 증가시키면서 666이 들어있으면 cnt를 증가시킨 후, N과 cnt가 같아질 때 더하고 있었던 a를 출력 하면 된다.

검색하면서도 뭐 다른 방법이 있겠나 싶었는데, 새로운 메소드를 또 하나 배워가게 되어 다행인 것 같다.