# [17611] 직각다각형

## 분류
> 정렬
>
> 누적 합
>
> 스위핑

## 코드
```java
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17611 {
    static int[] sumX = new int[1000001];
    static int[] sumY = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken()) + 500000;
        int y = Integer.parseInt(st.nextToken()) + 500000;

        int startX = x;
        int startY = y;

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken()) + 500000;
            int curY = Integer.parseInt(st.nextToken()) + 500000;

            if(x == curX){
                calcY(y, curY);
            }else if(y == curY){
                calcX(x, curX);
            }

            x = curX;
            y = curY;
        }

        if(x == startX)
            calcY(y, startY);
        else
            calcX(x, startX);

        int max = 0;

        for(int i = 0; i < 1000001; i++){
            max = Math.max(max, Math.max(sumX[i], sumY[i]));
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    static void calcX(int x, int curX){
        if(x > curX){
            for(int i = curX; i < x; i++){
                sumX[i]++;
            }
        }else {
            for(int i = x; i < curX; i++){
                sumX[i]++;
            }
        }
    }
    static void calcY(int y, int curY){
        if(y > curY){
            for(int i = curY; i < y; i++){
                sumY[i]++;
            }
        }else {
            for(int i = y; i < curY; i++){
                sumY[i]++;
            }
        }
    }
}
```

## 문제풀이

처음엔 x,y 각각의 증가/감소 부분을 쌓아주려고 했는데 생각보다 너무 복잡해서 친구의 머리를 조금 빌렸다. 수직 선분이면 x, 수평선분이면 y를 구간별로 값을 쌓아줬다. 음수 부분은 어떻게 처리해야할 지 모르겠어서, 그냥 50만을 냅다 더해버렸다. (이것도 친구가 알랴줌)  

증감량으로 풀어도 충분히 될 것 같긴 하다. 다만, 증가량을 계속해서 갱신해줘야하기도 하고, 그러면 max값들도 계속해서 갱신해야하고.. 굳이 그럴바엔 이게 더 최적화된 게 아닌가 싶은😅  


구름에서 본 문제인데, 너무 어려워서 검색해보다가 백준에도 있는 걸 발견했다. 문제가 완-저니 똑같았음.. 예제랑 그림까지 그냥 복붙이었슴.. 근데 구름에는 난이도 1이었는데 여긴 골드2네 ..? 머.. 어찌저찌 풀긴 했다.
