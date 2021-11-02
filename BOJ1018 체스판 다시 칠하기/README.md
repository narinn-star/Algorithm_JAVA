# [2475] 검증수

## 분류
> 브루트포스 알고리즘

## 코드
```java
import java.util.Scanner;

public class BOJ1018 {
	static char[][] chess;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 0;
		int res = 64;
		
		chess = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			for(int j = 0; j < m; j++) {
				chess[i][j] = str.charAt(j);
			}
		}
		for(int i = 0; i < n-7; i++){
			for(int j = 0; j < m - 7; j++) {
				cnt = find(i, j);
				if(res > cnt)
					res = cnt;
			}
		}
		System.out.println(res);
	}
	
	public static int find(int a, int b) {
		int cnt1 = 0;
		int cnt2 = 0;
		String[] board1 = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW"};
		String[] board2 = {"BWBWBWBW","WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW","WBWBWBWB"};
		
		for(int i = a; i < a+8; i++) {
			for(int j = b; j < b+8; j++) {
				if(chess[i][j] != board1[i - a].charAt(j-b))
					cnt1++;
				if(chess[i][j] != board2[i - a].charAt(j-b))
					cnt2++;
			}
		}
		return Math.min(cnt1, cnt2);
	}
}
```

## 문제풀이

체스판의 종류는 (0, 0) 자리의 색깔이 White이냐 Black이냐에 따라 딱 두가지로만 나뉜다. 체스판은 8X8이기 때문에 체스판 두개를 미리 만들어 두고 비교하는 식으로 풀었다. 

 n과 m이 얼마이든 -7부터 8개씩 잘라서 체스판을 확인할 것이기 때문에 아무 문제가 없다. 반복문을 실행하면서 바로 find 함수를 호출한다. 함수에서는 기존에 만들어 둔 체스판과 비교하여 틀린 부분은 cnt를 증가시키고 그 중에서 min을 구해 return한다. 

return해온 cnt값과 res값 (64)와  비교하여 작은 수를 출력하면 된다. res값이 64인 이유는 최대 cnt값이 8x8 의 64만큼 나올 수 있기 때문이다.