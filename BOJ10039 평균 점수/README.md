# [10039] 평균 점수

## 분류
> 수학
>
> 사칙연산

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10039 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] score = new int[5];
		int sum = 0;
		
		for (int i = 0; i < 5; i++) {
			score[i] = Integer.parseInt(br.readLine());
			if(score[i] < 40)
				score[i] = 40;
			sum += score[i];
		}
		System.out.println(sum / 5);
	}
}
```

## 문제풀이

하나씩 부숴가는 문제들 중 하나.. 평균을 내는 문제인데, 40점 미만인 학생들의 점수는 그냥 40점으로 퉁치는 문제. 그냥 반복문 안에 조건문을 추가하는 것을 연습하는 문제인것같다.