# [15686] 치킨 배달

## 분류
> 구현
> 
> 브루트포스 알고리즘
> 
> 백트래킹

## 코드
```java
import java.awt.Point;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15686 {
    //    static class Point {
//        int x, y;
//        public Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }
    static int N, M, min;
    static boolean[] visited;
    static List<Point> chickenMap, houseMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chickenMap = new ArrayList<>();
        houseMap = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 2) chickenMap.add(new Point(i, j));
                else if (tmp == 1) houseMap.add(new Point(i, j));
            }
        }
        visited = new boolean[chickenMap.size()];

        min = Integer.MAX_VALUE;

        dfs(0, 0);

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int a, int cnt) {
        if (cnt == M) {
            int citySum = 0;
            for (int i = 0; i < houseMap.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for (int j = 0; j < chickenMap.size(); j++) {
                    if (visited[j]) {
                        int distance = Math.abs(houseMap.get(i).x - chickenMap.get(j).x) + Math.abs(houseMap.get(i).y - chickenMap.get(j).y);
                        sum = Math.min(sum, distance);
                    }
                }
                citySum += sum;
            }

            min = Math.min(min, citySum);
            return;
        }

        for (int i = a; i < chickenMap.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
```

## 문제풀이

배열 하나로 해결되지 않으면 리스트로 받자. 치킨집과 집의 위치를 모두 리스트에 넣어두고, visited는 치킨집 갯수만큼 선언했다. 그리고 어떤 곳을 방문하는지와 depth역할을 할 cnt값도 0으로 넣어줬다. cnt값이 M 즉, 치킨집 갯수와 같아질 때 모든 곳을 탐색하면서 최솟값을 계속 갱신해준다. dfs 내부에 for문에서 방문처리를 해주면서 재귀호출을 하기 때문에 모든 곳을 M개씩 다 탐색할 수 있다.  


처음에 이차원 배열로 for문을 무자비하게 돌아버려서 그런지 당연하게도 시간초과가 나왔다. 32만번 정도는 괜찮지 않아 ? 난 이거랑 1초의 차이를 모르겠다 이말씀이야 ,, ㅠㅠ 무튼 그래도 해결 방법을 알아서 리스트로 바로 바꾸긴 했는데, 그러다 보니 이중 반복문 다 지우고 내부가 간결해지긴 해서 다 갈아엎어버렸다.  
오늘 깨달은 건 백트래킹도 결국 템플릿이 거의 정해져있구나 였다.  
dfs() 내에서 반복문에 들어가면 해줄 건 방문 여부 또는 재귀호출이 다였다. 중요한건 매개변수를 어떤 것을 넣어 줄 것이냐에 따라 달라지는 것이지만..! 나머지는 제한 값에 다다랐을 때 문제에 맞게 계산만 해주면 된다.  
이 문제에서는 합계를 구해야하는 게 다양해서 변수명도 아주 중요했다.
