import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18511 {
    private static int N, num, res, cnt = 0, now = 0;
    private static int[] K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        K = new int[num];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < num; i++) {
            K[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(K);
        findBig(0);
        System.out.println(res);
    }

    private static void findBig(int now){
        if(N < now) return;
        if(res < now) res = now;

        for(int i = 0; i < num; i++){
            findBig((now * 10) + K[i]);
        }
    }
}
