# [2448] 별 찍기 - 11

## 분류
> 재귀

## 코드
```java
import java.io.*;
import java.util.Arrays;

public class BOJ2448 {
    static char[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        stars = new char[N][N * 2 - 1];
        for(int i = 0 ; i < N; i++){
            Arrays.fill(stars[i], ' ');
        }

        star(0, N - 1, N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N * 2 - 1; j++){
                bw.write(stars[i][j] + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
    static void star(int x, int y, int N){
        if(N == 3){
            stars[x][y] = '*';
            stars[x + 1][y - 1] = stars[x + 1][y + 1] = '*';
            stars[x + 2][y - 2] = stars[x + 2][y - 1] = stars[x + 2][y] = stars[x + 2][y + 1] = stars[x + 2][y + 2] = '*';
        }else {
            int newN = N / 2;
            star(x, y, newN);
            star(x + newN, y - newN, newN);
            star(x + newN, y + newN, newN);
        }
    }
}
```

## 문제풀이

도저히 어떻게 풀어야할 지 모르겠어서 고민만 2-30분을 했다.😓 처음엔 이중 반복문으로 별을 다 찍어주려고 했는데, 사실 그건 빈칸이 너무 힘들어서 바로 그만두고, 빈칸을 모두 다채워둔 후에 별 자리만 찍어주는 방법을 선택했다.  

사실 작은 것부터 찍어나가는 것은 정말 말도 안되는 거기도 하고, 재귀를 하면 N을 작게 만들어 가는 게 훨씬 낫다. 그래서 가장 작은 숫자인 3이 되었을 때 별을 먼저 찍어줬다. 좌표를 활용하면 규칙성이 있어서 바로 찍어줄 수 있다. 나머지는 3이 아닐 때, 즉 3보다 큰 수일 때 3으로 줄여나가는 과정을 작성해야한다.  

왼쪽 오른쪽 아래 삼각형을 찍는다는 생각으로 재귀를 만든 건 아닌데, 하나씩 해보다가 얼결에 돼버렸다..😅
