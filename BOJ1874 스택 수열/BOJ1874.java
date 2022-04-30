import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int a = 0, pop;
		arr[a] = Integer.parseInt(br.readLine());
		for(int i = 1; i <= arr[0]; i++) {
			stack.push(i);
			sb.append("+").append("\n");
		}
		pop = stack.pop();
		sb.append("-").append("\n");
		a++;		
		while(a < n) {
			arr[a] = Integer.parseInt(br.readLine());
			if(arr[a] == pop - 1) {
				pop = stack.pop();
				sb.append("-").append("\n");
				a++;
			}
			else {
				for(int i = pop + 1; i <= arr[a]; i++) {
					stack.push(i);
					sb.append("+").append("\n");
				}
				pop = stack.pop();
				sb.append("-").append("\n");
				a++;
			}
		}
		System.out.println(sb);
	}
}