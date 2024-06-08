import java.io.*;
import java.util.StringTokenizer;

public class BOJ11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrA = new int[N];
        int[] arrB = new int[M];
        int[] arrRes = new int[N + M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arrA.length; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arrB.length; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int idxA = 0, idxB = 0, idx = 0;
        while(true){
            if(idxA > N - 1 || idxB > M - 1) break;

            if(arrA[idxA] < arrB[idxB]){
                arrRes[idx++] = arrA[idxA++];
            } else{
                arrRes[idx++] = arrB[idxB++];
            }
        }

        if(idxA >= N){
            for(int i = idxB; i < M; i++){
                arrRes[idx++] = arrB[i];
            }

        } else if(idxB >= M){
            for(int i = idxA; i < N; i++){
                arrRes[idx++] = arrA[i];
            }
        }

        for(int i = 0; i < arrRes.length; i++){
            bw.write(arrRes[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
