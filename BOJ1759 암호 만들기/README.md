# [1759] 암호 만들기

## 분류
> 수학
>
> 브루트포스 알고리즘
>
> 조합론
> 
> 백트래킹

## 코드
```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    static int L, C;
    static char[] alpha, resCode;
    static boolean[] check;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[C];
        resCode = new char[L];
        check = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            alpha[i] = Character.valueOf(st.nextToken().charAt(0));
        }

        Arrays.sort(alpha);

        dfs(0, 0);

        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int start)throws IOException{
        if(depth == L){
            if(checkAlpha()){
                for(char c : resCode) bw.write(c + "");
                bw.write("\n");
            }
            return;
        }

        for(int i = start; i < C; i++){
                resCode[depth] = alpha[i];
                dfs(depth + 1, i + 1);
        }
    }

    static boolean checkAlpha(){
        int consonantsCnt = 0;
        int vowelCnt = 0;

        for(char c : resCode) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowelCnt++;
            else consonantsCnt++;
        }

        if(vowelCnt >= 1 && consonantsCnt >= 2) return true;
        else return false;
    }
}

```

## 문제풀이

N-Queen은 2차원 배열이기도 하고 퀸 이동 가능 여부 체크도 너무 어려웠는데 암호 만들기는 진짜 쉽게 풀었다.  
기본적으로 오름차순이 되어야하는 것과 모음 1개, 자음 2개 이상만 되면 암호 가능성이 있는 것으로 본다. 오름차순이라는 것은 우선 입력받은 알파벳을 오름차순으로 해두고 중첩 반복문에서 내부 반복문이 i + 1부터 시작하도록 하면 된다. 당연히 방문 여부는 필요가 없다. 첫번째가 다 돌면 오름차순이므로 첫번째 문자로 돌아와서는 안되기 때문이다. 

처음 제출했을 때, depth == L과 checkAlpha()를 같은 조건식 내부에 두어서 런타임 에러가 났다. depth는 L과 일치해서 내부로 들어가서 끝내야하는데, checkAlpha가 false로 나오는 경우에는 아예 리턴되지 않아 런타임 에러가 났던 것 같다.

