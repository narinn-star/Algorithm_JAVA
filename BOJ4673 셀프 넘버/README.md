# [4673] 셀프 넘버

## 분류
> 수학
>
> 구현
>
> 브루트포스 알고리즘

## 코드
```java
public class BOJ4673 {
	public static void main(String[] args) {
		boolean[] number = new boolean[10001];
		
		for(int i = 1; i < 10001; i++) {
			int n = div(i);
			
			if(n < 10001)
				number[n] = true;
		}
		
		for(int i = 1; i < 10001; i++) {
			if(number[i] == false)
				System.out.println(i);
		}
	}
	
	public static int div(int n) {
		int sum = n;
		
		while(n != 0) {
			sum = sum + (n % 10);		//첫째자리수 뽑고
			n = n / 10;					//첫째자리수 없애기
		}
		return sum;
	}
}
```

## 문제풀이

별다른 입력 없이 바로 계산해서 출력을 하는 문제이다.

지난번에 한 번 시도 했는데, 갑자기 자릿수를 하나씩 끊는게 기억이 안나서.. 다른 문제로 기억을 더듬어보기로 하고 미뤄두었던게 기억이 난다. 그냥 10으로 나눈 나머지를 담아두면 되는 건뎅ㅋㅋ

아무튼 한자릿수씩 끊어서 생성자를 만들어준다.(sum) 이 수를 리턴하면 모든 생성자가 true로 초기화된다. (boolean 배열을 처음에 선언하면 모두 false로 초기화되어있음!) 반복문에서 false인 배열을 모두 출력해주면, 셀프 넘버가 출력된다.