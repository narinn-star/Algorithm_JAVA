# [20922] 겹치는 건 싫어

## 분류
> 두 포인터


## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] cnt = new int[100001];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;

        while(right < N){
            while(right < N && cnt[arr[right]] + 1 <= K) {
                cnt[arr[right]]++;
                right++;
            }
            max = Math.max(max, right - left);
            cnt[arr[left]]--;
            left++;
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
```

## 문제풀이

범위가 계속해서 변하기 때문에 슬라이딩 윈도우가 아닌 투 포인터로 풀어야 하는 문제다.

앞에서부터 시작해서 cnt 배열에 arr 배열의 값을 카운팅해주면서 left포인터 값과 right 포인터 값을 계속해서 더해주고 빼주는 것을 반복해야한다. 나는 while문 안에 또 while문을 넣을 생각을 못(?)해서 while문 안에 if-else문으로만 풀었는데 당연히 틀린 케이스가 있었다. 심지어 left = 0, right = 1으로 두고 시작해서 애초에 힘들게 풀으려 했었다.. 

다시 다 지우고 풀면서 오른쪽 값 카운팅을 올렸을 때 K가 넘지 않을 때 카운팅 후 한 칸 옮기는 작업을 해줬다. 이전에는 카운팅 값을 더했다가 뺐다가 .. 오히려 복잡하게 풀었어서 어디서 꼬였는지 알 수 도 없는 지경이었음.. 그리고 while문을 빠져나왔을 때는 카운팅 값이 K가 넘었다는 것이므로 그 때 left값을 빼주면 된다. left를 빼주기 전에 max값을 갱신해주면 된다.
