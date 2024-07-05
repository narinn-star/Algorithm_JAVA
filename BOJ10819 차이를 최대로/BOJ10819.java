import java.io.*;
import java.util.StringTokenizer;

public class BOJ10819 {
    static int N, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        max = 0;
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0);

        bw.write(max + "\n");
        bw.flush();
        bw.close();

    }
    static void backtrack(int a){

        if(a == arr.length - 1){
            int sum = 0;
            for(int i = 0; i < arr.length - 1; i++){
                sum += Math.abs(arr[i] - arr[i + 1]);
            }

            if(sum > max) {
                max = sum;
            }
        } else {
            for(int i = a; i < arr.length; i++){
                swap(a, i);
                backtrack(a + 1);
                swap(a, i);
            }
        }
    }

    static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
