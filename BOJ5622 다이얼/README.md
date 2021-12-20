# [5622] 다이얼

## 분류
> 구현

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5622 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sec = 0;
		String[] line = br.readLine().split("");
		
		for(int i = 0; i < line.length; i++) {
			switch(line[i]) {
			case "A":case "B":case "C": sec = sec + 3;
			break;
			case "D":case "E":case "F": sec = sec + 4;
			break;
			case "G":case "H":case "I": sec = sec + 5;
			break;
			case "J":case "K":case "L": sec = sec + 6;
			break;
			case "M":case "N":case "O": sec = sec + 7;
			break;
			case "P":case "Q":case "R":case "S": sec = sec + 8;
			break;
			case "T":case "U":case "V": sec = sec + 9;
			break;
			case "W":case "X":case "Y":case "Z": sec = sec + 10;
			break;				
			}
		}
		br.close();
		System.out.println(sec);
	}
}
```

## 문제풀이

간단한 다이얼 문제

숫자별로 몇 초씩 걸리는지 문제에서 이미 제시했기 때문에 한 글자씩 잘라 switch문에서 하나씩 나누어 sec 변수에 더해주었다.

너무 일일이 조건식을 달아주었나 싶었지만, if문으로 해도 어차피 3-4개씩 묶어 일일이 더해주는 건 똑같다고 생각해서 그냥 이대로 제출했다.

문제 안에 답이 다 있었던 쉬운 문제!