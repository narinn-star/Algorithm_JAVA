import java.io.*;
import java.util.*;

public class BOJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> clothesSet = new HashMap<>();

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();

                if(clothesSet.containsKey(key)){
                    clothesSet.put(key, clothesSet.get(key) + 1);
                }else {
                    clothesSet.put(key, 1);
                }
            }

            int res = 1;

            for(int val : clothesSet.values()){
                res *= (val + 1);
            }

            bw.write(res - 1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
