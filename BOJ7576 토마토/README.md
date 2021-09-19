# [7576] 토마토

## 분류
> 그래프 이론
>
> 그래프 탐색
>
> 너비 우선 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ7576 {
	static int M, N, max = 0;
	static int[][] tomato;
	static boolean[][] visited;
	
	static int[] x = { 0, 0, -1, 1 };
	static int[] y = { -1, 1, 0, 0 };
	
	static Queue<Point> queue = new LinkedList<>();
	
	static class Point {
		int x, y;	
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tomato = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(tomato[i][j] == 1) {
					visited[i][j] = true;
					queue.add(new Point(i, j));
				}
				else if(tomato[i][j] == -1)
					visited[i][j] = true;
			}
		}
		bfs();
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					System.out.println(-1);
					return;
				}
				if(max < tomato[i][j])
					max = tomato[i][j];
			}
		}
		System.out.println(max-1);
		br.close();		
	}
	
	static void bfs() {	
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int X = point.x + x[i];
				int Y = point.y + y[i];
				
				if(X >= 0 && Y >= 0 && X < M && Y < N) {
					if(!visited[X][Y]) {
						tomato[X][Y] = tomato[point.x][point.y] + 1;
						visited[X][Y] = true;				
						queue.add(new Point(X, Y));
					}
				}
			}
		}	
	}
}
```

## 문제풀이

✔**주의 : 6행 4열이 아니라, 4행 6열**

토마토가 하루에 상하좌우로 한 개씩 익기 때문에 상하좌우 배열을 먼저 선언한 후에 시작한다. 

생각해야 할 조건은 토마토가 들어있지 않은 칸은 -1이기 때문에 상하좌우를 탐색할 때 토마토가 들어있는 칸과는 다르게 계산해야하는 것과 토마토가 여러곳에 들어있을 경우 서로 퍼져 만나는 지점이 생긴다는 것이다. 

하루에 상하좌우로 한 칸 씩 퍼지는 것이라면, 어디에서 몇 개의 토마토가 들어있던지, 마지막 토마토가 어떤 토마토 옆에서 익게되는지 상관 없이 최소 날짜가 나오게 된다. 단지 토마토가 없는 칸만 고려해주면 되는 것이다. 

처음 토마토 위치를 입력받을 때, 토마토가 있는 것(1)과 토마토가 없는 것(-1)을 미리 방문확인을 해두는 것이다. 토마토가 있는 경우의 좌표값은 Point 객체에 담아 큐 맨 끝에 넣어준다. 

bfs함수에서는 큐가 모두 빌 때까지 반복문을 실행한다. 가장 앞에 담긴 큐를 꺼내 (토마토가 담겨있는 좌표들 중 첫번째 좌표) 상하좌우를 탐색하여 창고 크기 내에서 익지 않은 토마토(visited == false)를 익히고(visited = true) 익는데 걸린 날짜를 하나씩 더해준다. 그리고 그 좌표는 다음 토마토를 익혀줄 토마토이기 때문에 큐의 맨 뒤에 넣어주면 된다.

마지막 출력할 때에는 익지 않은 토마토가 있는지 확인해야한다. 어차피 bfs함수에서 익힐 수 있는 토마토는 모두 익혔기 때문에 익지 않은 토마토는 토마토가 없는 칸에 막힌 토마토일수 밖에 없다. 간단하게 이중for문을 이용해 visited == false인 토마토가 있는지 확인하고, 있다면 -1을 출력하고 종료한다. 그렇지 않으면 하나씩 비교해 max에 최댓값을 저장한다.

출력할 때에는 max -1을 해주는데 그 이유는 가장 처음에 찾은 토마토 위치가 1인데, 그 토마토가 익은 일수는 빼고 계산해야하기 때문이다. 