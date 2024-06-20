# [12891] DNA 비밀번호

## 분류
> 문자열
>
> 슬라이딩 윈도우

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ12891 {
    private static int[] minChar, tmpMinChar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] dna = new char[S];
        String str = br.readLine();
        for(int i = 0; i < S; i++){
            dna[i] = str.charAt(i);
        }

        minChar = new int[4]; // { A, C, G, T }
        tmpMinChar = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0, n = minChar.length; i < n; i++){
            minChar[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for(int i = 0; i < P; i++){
            if(dna[i] == 'A') tmpMinChar[0]++;
            else if(dna[i] == 'C') tmpMinChar[1]++;
            else if(dna[i] == 'G') tmpMinChar[2]++;
            else if(dna[i] == 'T') tmpMinChar[3]++;
        }

        if(checkDna()) cnt++;

        for(int i = P; i < S; i++){
            int idx = i - P;
            if(dna[idx] == 'A') tmpMinChar[0] --;
            else if(dna[idx] == 'C') tmpMinChar[1]--;
            else if(dna[idx] == 'G') tmpMinChar[2]--;
            else if(dna[idx] == 'T') tmpMinChar[3]--;

            if(dna[i] == 'A') tmpMinChar[0]++;
            else if(dna[i] == 'C') tmpMinChar[1]++;
            else if(dna[i] == 'G') tmpMinChar[2]++;
            else if(dna[i] == 'T') tmpMinChar[3]++;

            if (checkDna()) cnt++;
        }

        System.out.println(cnt);

    }
    private static boolean checkDna(){
        for(int i = 0; i < 4; i++){
            if(tmpMinChar[i] < minChar[i]) return false;
        }
        return true;
    }
}
```

## 문제풀이

P개로 범위가 정해져있는 문제로, 슬라이딩 윈도우 방식으로 풀면 된다.

주어지는 문자열 내에, 주어지는 A, C, G, T 최소 갯수만 넘기면 비밀번호로 사용할 수 있다. 
비교할 원본 ACGT 갯수 배열과 특정 범위별 ACGT 갯수 배열 두개가 필요하다. 원본 배열은 입력받을 때 초기화해두고, 문자열의 문자 하나씩 확인할 때마다 tmpMinChar 배열에 증감을 해줬다. 처음 P개는 tmpMinChar에 +만 해주고 그 다음부터는 앞 단계에서 +해줬던 문자를 -해주는 단계를 추가한다.

진짜 어렵지 않은 문제였는데, 문자열이 정말 약하구나를 또 다시 느꼈던 문제였다.
그리고 되도록이면 슬라이딩 윈도우와 투 포인터 문제에서는 중첩 반복문 보다 한번에 끝내는 방법으로 하는 게 좋겟따..🫠
