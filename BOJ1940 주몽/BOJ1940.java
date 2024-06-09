import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        int cnt = 0;
//
//        for(int i = 0; i < arr.length - 1; i++){
//            for(int j = i + 1; j < arr.length; j++){
//                if(arr[i] + arr[j] == M){
//                    cnt++;
//                }
//            }
//        }
//
//        bw.write(cnt + " \n");
        Arrays.sort(arr);

        int cnt = 0, idx1 = 0, idx2 = N -1;

        while(idx1 < idx2){
            if(arr[idx1] + arr[idx2] < M) idx1++;
            else if(arr[idx1] + arr[idx2] > M) idx2--;
            else {
                cnt++;
                idx2--;
                idx1++;
            }
        }

        bw.write(cnt + " \n");
        bw.flush();
        bw.close();
    }
}
