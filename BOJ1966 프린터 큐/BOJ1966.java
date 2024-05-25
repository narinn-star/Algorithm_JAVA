import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Printer {
    int imp, idx; // 중요도, 인덱스

    public Printer(int imp, int idx) {
        this.imp = imp;
        this.idx = idx;
    }
}
public class BOJ1966 {
    private static int N, M;
    private static LinkedList<Printer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                queue.add(new Printer(Integer.parseInt(st.nextToken()), i));
            }

            System.out.println(printDocs());
        }
    }
    private static int printDocs(){
        int cnt = 0;

        while(!queue.isEmpty()){
            Printer currentDoc = queue.poll();
            boolean check = true;

            for(int i = 0; i < queue.size(); i++){
                if(currentDoc.imp < queue.get(i).imp){
                    queue.offer(currentDoc);

                    for(int j = 0; j < i; j++){
                        queue.offer(queue.poll());
                    }
                    check = false;
                    break;
                }
            }

            if(!check) continue;

            cnt++;

            if(currentDoc.idx == M) break;
        }

        return cnt;
    }

}
