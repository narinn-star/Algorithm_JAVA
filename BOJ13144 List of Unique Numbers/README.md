# [13144] List of Unique Numbers

## 분류
> 두 포인터

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] cnt = new int[1000001];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1, right = 1;
        long ans = 0;

        while(left <= N){
            while(right <= N && cnt[arr[right]] == 0){
                cnt[arr[right]]++;
                right++;
            }
            ans += (right - left);
            cnt[arr[left++]]--;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();

    }
}
```

## 문제풀이

연속하는 수를 뽑았을 때 같은 숫자가 들어있지 않은 경우를 구하는 문제다.

처음에는 N의 개수에 따라 최대 값이 정해져있기 때문에 전체에서 같은 숫자가 들어있는 경우만 빼주려고 했는데, 이러나 저러나 .. 어차피 비슷할 것 같아서 늘 하던대로 left와 right 변수를 가지고 순서대로 탐색했다.

예제가 1부터 되어 있어서 배열도 1부터 넣었는데, 사실 의미 없다. 0부터 해도 상관 없음. 카운트 배열도 어차피 100001이 최대라서, 카운팅해주기 좋았다. 등장하면 하나씩 더해주고 만약 이미 0이 아니라면 (등장한 적 있다면) ans를 갱신해주고 이미 더해둔 값은 빼준다. 
