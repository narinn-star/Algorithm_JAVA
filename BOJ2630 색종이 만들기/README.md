# [2630] 색종이 만들기

## 분류
> 분할 정복
>
> 재귀

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
	public static int white = 0;
	public static int blue = 0;
	public static int[][] paper;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	public static void find(int row, int col, int size) {	
		if(check(row, col, size)) {
			if(paper[row][col] == 0)
				white++;
			else
				blue++;
			return;
		}
		
		int Size = size / 2;
		find(row, col, Size);
		find(row, col + Size, Size);
		find(row + Size, col, Size);
		find(row + Size, col + Size, Size);
	}
	public static boolean check(int row, int col, int size) {
		int color = paper[row][col];
		
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(paper[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}
```

## 문제풀이

처음 풀어보는 분할 정복 문제.

이런 모양의 문제를 보면 깊이/너비 탐색이 먼저 떠올라서, '분할 정복'을 떠올리기가 쉽지는 않았다. 사실 풀면서 알게되었다. 처음엔 2x1, 3x1 등 직사각형 크기의 색종이가 나오면 어떡하나, 했는데 당연히 1x1로 나눠지니까 전혀 고려대상이 아니다. 

재귀로 뜯어서 돌고 뜯어서 돌고 해야하니까, 처음엔 (0,0)부터 검사하면 된다. 사이즈는 자르면 또 바뀌고 또 자르면 바뀌니까 넣어주면서 재귀호출을 할 때 새로운 사이즈를 같이 넘겨주는 것. 체크해야할 것은 white인지 blue인지, 그리고 정사각형으로 잘 짤렸는지이다. 정사각형으로 잘 짤려야 white, blue 색종이를 증가시키기 때문에 check를 먼저 해준다. 시작점(row, col)부터 (row + size, col + size)까지 돌면서 같은 색인지 아닌지 판단하고, 다른 색이면 바로 탈출하고 같은 색이면 계속 진행하면 된다.

리턴값으로 체크가 완료되면 흰색/파란색 색종이를 증가시키고 사이즈를 반으로 자른 후에 잘린 4개를 모두 재귀호출하면 된다.