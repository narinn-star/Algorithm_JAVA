# [11558] The Game of Death

## 분류
> 그래프 이론
>
> 그래프 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11558 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N+1];
			boolean[] visited = new boolean[N+1];
			
			int flag = -1;

			int cnt = 0, tmp = 1;
			
			for(int j = 1; j <= N; j++) {
				arr[j] = Integer.parseInt(br.readLine());
			}
			
			while(!visited[tmp]) {
				visited[tmp] = true;
				
				if(tmp == N) {
					flag = 1;
					break;
				}			
				tmp = arr[tmp];
				cnt++;
			}
	         System.out.println(flag == 1?cnt:0);
	      }
		br.close();
	}

}
```

## 문제풀이

dfs로 풀려다가 그렇게까지 안해도 될 것 같아서 while문 내에서 해결했다. visited는 그 다음 순서의 사람으로 넘어가기 위함, 그리고 1 -> 2, 2 -> 1일 떄 바로 while문을 종료하기 위해 방문확인을 하는 용도이다. 

예제로 살펴보면 

1. tmp = 2, cnt = 1
2. tmp = 3, cnt = 2
3. tmp = 4, cnt = 3
4. tmp = 5, cnt = 4
5. tmp = 6, cnt = 5
6. tmp = 7, cnt = 6

인데, tmp가 N인 7되는 순간 cnt값이 최소가 되기 때문에 반복문을 종료하면 된다. 출력문에서 구분해주기 위해 -1이 담겨있던 flag 변수를 1로 초기화해주고 종료한다. tmp가 N이 되기 전까지는 그 다음 사람의 순서로 넘기고, cnt값을 증가시킨다.

출력할때는 flag가 1일때(tmp == N이어서 cnt값을 찾은 경우) cnt를 출력하고, 그렇지 못한 경우에 0을 출력한다.

이문제 진짜 .. 왜 System으로 출력하면 정답인데 버퍼로 출력하면 틀렸다고 하는지 알수가 없다...