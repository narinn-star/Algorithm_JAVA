import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			System.out.println(point(x1, y1, r1, x2, y2, r2));
		}
	}
	
	public static int point(int x1, int y1, int r1, int x2, int y2, int r2) {
		
		int dis = (int)(Math.pow(x2- x1, 2) + Math.pow(y2-y1, 2));
		
		if(x1 == x2 && y1 == y2 && r1 == r2)	//두 원이 완전 똑같을 때(접점 무한개)
			return -1;
		
		else if(dis > Math.pow(r1 + r2, 2))		//중점간 거리 > 두 원 반지름 합 (아예 안만남, 접점 0개)
			return 0;
		
		else if(dis < Math.pow(r2 - r1, 2))		//중점간 거리 < 두 원 반지름 차 (한 원 안에 다른 원이 있음, 접점 0개)
			return 0;
		
		else if(dis == Math.pow(r2 - r1, 2))	//중점간 거리 == 두 원 반지름 차 (내접할 때 _ 딱 맞물림, 접점 1개)
			return 1;
		
		else if(dis == Math.pow(r1 + r2, 2))	//중점간 거리 == 두 원 반지름 합 (외접할 때 _ 딱 맞물림, 접점 1개)
			return 1;
		
		else
			return 2;
	}
}