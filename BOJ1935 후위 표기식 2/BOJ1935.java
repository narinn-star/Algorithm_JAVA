import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		double[] arr = new double[N];
		Stack<Double> stack = new Stack<>();
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		double res = 0;
		for(int i = 0; i < str.length(); i++) {
			if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				stack.push(arr[str.charAt(i) - 'A']);
			}
			else {
				if(!stack.isEmpty()) {
					double fir = stack.pop();
					double sec = stack.pop();
					
					switch(str.charAt(i)) {
					case '+':
						res = sec + fir;
						stack.push(res);
						continue;
					case '-':
						res = sec - fir;
						stack.push(res);
						continue;
					case '*':
						res = sec * fir;
						stack.push(res);
						continue;
					case '/':
						res = sec / fir;
						stack.push(res);
						continue;
					}
				}
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}