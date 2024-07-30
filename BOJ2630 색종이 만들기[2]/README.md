# [2630] 색종이 만들기

## 분류
> 분할 정복
>
> 재귀

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ2630 {
    static int white = 0, blue = 0;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        newPaper(0, 0, N);

        bw.write(white + "\n" + blue);
        bw.flush();
        bw.close();
        br.close();
    }

    static void newPaper(int x, int y, int size){
        if(check(x, y, size)){
            if(paper[x][y] == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        newPaper(x, y, newSize);
        newPaper(x, y + newSize, newSize);
        newPaper(x + newSize, y, newSize);
        newPaper(x + newSize, y + newSize, newSize);
    }

    static boolean check(int x, int y, int size){
        int color = paper[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(paper[i][j] != color) return false;
            }
        }

        return true;
    }
}
```

## 문제풀이

어제 풀었던 Z 문제와 거의 동일하다. 점점 사이즈를 줄여가면서 줄였을 때 원하는 탐색을 하면 된다. 단, 이 문제는 무조건 1이 나올 때까지 가는 건 아니고, 분할했을 때 색종이 하나를 만들 수 있으면 카운팅 해주고 그 다음 분할된 종이로 넘어가면 된다.  

Z문제 풀 떄는 정말정말 너무 어려웠는데, 하나 풀어봤다고 이렇게 쉬울 일인가 싶다...
