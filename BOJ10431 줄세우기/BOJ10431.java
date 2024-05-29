import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++){
            st = new StringTokenizer(br.readLine());
            //int[] height = new int[21];
            int max = -1;
            int cnt = 0;
            int num = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);

            for(int j = 1; j <= 20; j++){
                int h = Integer.parseInt(st.nextToken());

                if(max < h) { // 맨 뒤에 세우기
                    max = h;
                    list.add(j, h);
                }
                else { // 자기 자리 찾아가기
                    for(int k = 1; k <= j; k++){
                        if(list.get(k) > h){
                            list.add(k, h);
                            cnt += list.size() - k  - 1;
                            break;
                        }
                    }
                }
            }
            System.out.println(i + " " + cnt);
        }
    }
}
