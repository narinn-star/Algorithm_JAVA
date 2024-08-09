# [13913] 숨바꼭질 4

## 분류
> 그래프 이론
> 
> 그래프 탐색
>
> 너비 우선 탐색


## 코드
```java
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ13913 {
    static int N, K;
    static int[] visited;
    static int[] before;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K) {
            System.out.print(0 + "\n" + N);
            return;
        }

        visited = new int[100001];
        before = new int[100001];

        bfs();

        Stack<Integer> stack = new Stack<>();

        int tmp = K;
        while (tmp != N) {
            stack.push(tmp);
            tmp = before[tmp];
        }
        stack.push(N);

        while(!stack.isEmpty()) sb.append(stack.pop()).append(' ');

        bw.write(sb + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[N] = 0;
        queue.add(N);

        while (!queue.isEmpty()) {
            int q = queue.poll();

            if (visited[K] != 0) {
                sb.append(visited[K]).append('\n');
                break;
            }

            if (q - 1 >= 0 && visited[q - 1] == 0) {
                visited[q - 1] = visited[q] + 1;
                queue.add(q - 1);
                before[q - 1] = q;
            }
            if (q + 1 < visited.length && visited[q + 1] == 0) {
                visited[q + 1] = visited[q] + 1;
                queue.add(q + 1);
                before[q + 1] = q;
            }
            if (q * 2 < visited.length && visited[q * 2] == 0) {
                visited[q * 2] = visited[q] + 1;
                queue.add(q * 2);
                before[q * 2] = q;
            }

        }
    }
}
```

## 문제풀이

마지막 숨바꼭질 문제!

4번을 풀면서 완벽하게 이해해버린..? 하지만 갯수 세었던 문제는 사실 잘 모르겠긴 하다.. 😅  
경로를 구했기 때문에 최단시간도 구한거라 생각해서 정말 쉽게 생각했는데, 다시 코드를 하나씩 작성하다보니 필요없는 경로들까지 모두 저장되어있어서 다 출력할 수 없었다. 그래서 생각한 첫번째 방법은 경로를 계속해서 가지고 옮겨다니는 방법이었다. visited를 int가 아닌 List형으로 해서 내부에 계속 경로를 가지고 가다가 K를 만나면 다 출력하는.. 그런 방식을 생각했는데 너무 복잡하고 너무 헤비해져서 버렸음..  

그리고 나서 생각한 방법이 어디서 왔는지만 계속 저장해두면 되돌아가면서 출력할 수 있겠구나를 깨닫고 before라는 배열에 어디서 출발해서 현재에 온 것인지 저장을 해줬다. 설명을 하자면 아래와 같음

예제 1번의 답인 5 10 9 18 17이 나오려면 before[17]에 18이 들어있으면 되고, before[18]에 9가, before[9]에 10이, before[10]에는 5가 들어있으면 된다. 5는 이전 값이 없으니까 N을 그대로 넣어주면 된다.  
접근하는 방식이 되돌아가는 것이기 때문에 따로 출력해줄 방법이 없어서.. Stack을 사용했다. StringBuilder에 reverse() 메서드는 문자열로 인식해서 통째로 뒤집어버려서.. 17이 71로 출력되는 오류가 있어 Stack을 선택했다.  

숨바꼭질 끗 ~
