# [2754] 학점계산

## 분류
> 수학
>
> 구현
>
> 문자열

## 코드
```java
import java.util.Scanner;

public class BOJ2754 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String grade = sc.next();
		double score = 0;

		switch (grade.charAt(0)) {
		case 'A':
			score = 4;
			break;
		case 'B':
			score = 3;
			break;
		case 'C':
			score = 2;
			break;
		case 'D':
			score = 1;
			break;
		case 'F':
			score = 0;
		}
		if (grade.length() > 1) {
			switch (grade.charAt(1)) {
			case '+':
				score += 0.3;
				break;
			case '-':
				score -= 0.3;
				break;
			}
		}

		System.out.println(score);
		sc.close();
	}
}
```

## 문제풀이

처음엔 case문 안에 하나씩 다 집어넣으려다가 그건 너무 비효율적인것같아서 문자열을 두개로 쪼갰다. 물론 F일때는 두번째 문자가 없기때문에 그부분만 조건문을 넣어주면 간단한 문제이다.