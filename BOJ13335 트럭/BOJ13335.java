import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int l = Integer.parseInt(st.nextToken()); // 최대 하중
        int sum = 0; // 트럭 무게 합
        int cnt = 0; // 시간

        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            truck.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < w; i++){
            bridge.add(0);
        }

        while(!bridge.isEmpty()){
            sum -= bridge.poll();
            if(!truck.isEmpty()){
                if(truck.peek() + sum <= l){
                    sum += truck.peek();
                    bridge.add(truck.poll());
                }else bridge.add(0);
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
