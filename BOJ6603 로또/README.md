# [6603] 로또

## 분류
> 수학
> 
> 조합론
> 
> 백트래킹
> 
> 재귀

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ6603 {
    static int k;
    static int[] lotto, result;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            lotto = new int[k];
            result = new int[6];

            for (int i = 0; i < k; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);

            bw.write("\n");
            bw.flush();
        }
        bw.close();
    }

    static void dfs(int depth, int start) throws IOException {
        if (depth == 6) {
            for (int r : result) bw.write(r + " ");
            bw.write("\n");
            return;
        }

        for (int i = start; i < lotto.length; i++) {
            result[depth] = lotto[i];
            dfs(depth + 1, i + 1);
        }
    }
}
```

## 문제풀이

N과 M 문제 2번이랑 다를 게 없었다. 오름차순으로 줘서 배열을 정렬해줄 필요도 없었고, 시작점이랑 depth만 가지고 재귀호출하면 쉽게 풀 수 있는 문제였다.  

while문에서 bufferedWriter를 사용할 때, 내부에서 flush를 해주고 while문 밖에서 close를 해줘야하는 걸 알았다.
