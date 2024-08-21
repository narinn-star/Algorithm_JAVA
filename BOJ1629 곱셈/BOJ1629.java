import java.io.*;
import java.util.StringTokenizer;

public class BOJ1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(solution(A, B, C));

    }
    static long solution(long A, long B, long C){
        if(B == 1) return A % C;

        long res = solution(A, B / 2, C);

        if(B % 2 == 1){
            return (res * res % C) * A % C;
        }
        return res  * res % C;
    }
}
