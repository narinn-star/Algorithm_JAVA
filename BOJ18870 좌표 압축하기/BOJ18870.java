import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sortedArr = arr.clone();

        Arrays.sort(sortedArr);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int i = 0; i < N; i++){
            if(!map.containsKey(sortedArr[i])){
                map.put(sortedArr[i], rank);
                rank++;
            }
        }

        for(int i = 0; i < N; i++){
            bw.write(map.get(arr[i]) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
