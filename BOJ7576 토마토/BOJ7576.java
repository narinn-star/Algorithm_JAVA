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