import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input > 0){
                pQueue.add(input);
            }else {
                if(pQueue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pQueue.poll());
                }
            }
        }
    }
}
