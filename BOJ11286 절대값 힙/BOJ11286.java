import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)){
                    return Math.abs(o1) - Math.abs(o2);
                }else if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }else {
                    return -1;
                }
            }
        });

        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(pQueue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pQueue.poll());
                }
            }else {
                pQueue.add(input);
            }
        }
    }
}
