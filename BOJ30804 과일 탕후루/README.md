# [30804] 과일 탕후루

## 분류
> 구현
> 
> 브루트포스 알고리즘
> 
> 두 포인터

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] tang = new int[N];
        int[] num = new int[10];
        int kind = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            tang[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int cnt = 0, max = 0;

        while(right < N) {
            if(num[tang[right]] == 0){
                kind++;
            }

            cnt++;
            num[tang[right]]++;

            if(kind > 2){
                if(--num[tang[left]] == 0){
                    kind--;
                }
                cnt--;
                left++;
            }

            max = Math.max(max, cnt);
            right++;

        }

        bw.write(max + "");
        bw.flush();
        bw.close();

    }
}
```

## 문제풀이

처음엔 투포인터는 생각도 못하고, 앞/뒤로 과일을 뺄 수 있다고 하니 덱만 생각했다. Map으로 카운팅을 해주고 앞뒤로 빼면서 종류가 두 개 이하가 됐을 때 과일 갯수를 세어 준다거나 하는 방식을 생각했다. 하지만 앞에서 먼저 빼줄지, 뒤에서 먼저 빼줄지 명확하게 정할 근거가 없어서 바로 다 날려버렸다.  

이외엔 덱으로 접근할 수 있는 방법이 떠오르지 않았다. 심지어 문제에서 몇 번만에 원하는 탕후루를 만들 수 있는가가 아니라, 2종류일 때 최대 갯수를 묻는 것이므로 사실 앞뒤가 문제가 아니고 어디에 가장 연속적으로 많이 꽂혀있는가가 포인트다. 그래서 앞뒤를 빼주는게 아니라, 투 포인터로 kind가 2개 이하면서 cnt가 가장 큰 값을 구했다. 뭔가 코드가 직관적이지 않아서 별로긴한데,, 이게 최선이었다.😓 과일 종류도 있고, 갯수도 세어야 하고, 최댓값도 찾아야하고, left,right값도 계속 바꿔줘야하고.. 이미 있는 과일인지 아닌지도 세어줘야해서 생각할 가짓수가 많아서 정답비율이 조금 낮지 않았나 생각이 들었다.  
