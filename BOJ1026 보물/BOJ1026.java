import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A.length; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B.length; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 0; i < B.length; i++){
            b.add(B[i]);
        }

        int res = 0;
        for(int i = 0; i < N; i++){
            int max = Collections.max(b);
            res += (A[i] * max);
            b.remove(Integer.valueOf(max));
        }

        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
