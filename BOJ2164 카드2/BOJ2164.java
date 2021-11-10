import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while(true) {
			if(queue.size() == 1)
				break;
			queue.poll();	//버리기
			int move = queue.poll();  //옮길 수
			queue.add(move);		//옮기기
		}
		
		bw.write(queue.poll() + "");
		bw.flush();
		bw.close();
		br.close();
	}
}