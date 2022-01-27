import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] point1 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		st = new StringTokenizer(br.readLine(), " ");
		int[] point2 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		st = new StringTokenizer(br.readLine(), " ");
		int[] point3 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		
		int x, y;
		
		if(point1[0] == point2[0])
			x = point3[0];
		else if(point1[0] == point3[0])
			x = point2[0];
		else 
			x = point1[0];
		
		if(point1[1] == point2[1])
			y = point3[1];
		else if(point1[1] == point3[1])
			y = point2[1];
		else
			y = point1[1];
		
		System.out.println(x + " " + y);
		br.close();
	}
}