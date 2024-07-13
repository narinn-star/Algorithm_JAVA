import java.io.*;
import java.util.StringTokenizer;

public class BOJ30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] shirt = new int[6];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++){
            shirt[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i = 0; i < 6; i++){
            cnt += shirt[i] / T;
            if(shirt[i] % T != 0){
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(N / P + " " + N % P);
    }
}
