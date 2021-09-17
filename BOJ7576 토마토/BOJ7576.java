import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ7576 {
	static int M,N, cnt = 0;
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Point p = new Point(0 ,0);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tomato[i][j] == 1) {
					p.x = i;
					p.y = j;
					queue.add(p);
				}
			}
		}
		bw.write(bfs(p) + "\n");
		
		br.close();
		bw.flush();
		br.close();
		
	}
	
	static int bfs(Point p) {
		visited[p.x][p.y] = true;
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			for(int i = 0; i < 4; i++) {
				int X = point.x + x[i];
				int Y = point.y + y[i];
				if(X >= 0 && Y >= 0 && X < M && Y < N) {
					if(!visited[X][Y]) {
						visited[X][Y] = true;
						cnt++;
						queue.add(new Point(X, Y));
					}
				}
			}
		}	
		return cnt;
	}
}