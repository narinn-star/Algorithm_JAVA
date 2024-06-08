# [11728] 배열 합치기

## 분류
> 정렬
> 
> 두 포인터

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrA = new int[N];
        int[] arrB = new int[M];
        int[] arrRes = new int[N + M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arrA.length; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arrB.length; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int idxA = 0, idxB = 0, idx = 0;
        while(true){
            if(idxA > N - 1 || idxB > M - 1) break;

            if(arrA[idxA] < arrB[idxB]){
                arrRes[idx++] = arrA[idxA++];
            } else{
                arrRes[idx++] = arrB[idxB++];
            }
        }

        if(idxA >= N){
            for(int i = idxB; i < M; i++){
                arrRes[idx++] = arrB[i];
            }

        } else if(idxB >= M){
            for(int i = idxA; i < N; i++){
                arrRes[idx++] = arrA[i];
            }
        }

        for(int i = 0; i < arrRes.length; i++){
            bw.write(arrRes[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
```

## 문제풀이

leetCode에서 풀어본 문제였다. 
[Merge Two Sorted Lists](https://github.com/narinn-star/Algorithm_JAVA/tree/master/LEET21%20Merge%20Two%20Sorted%20Lists)

릿코드에서는 ListNode라는 클래스가 Definition으로 주어져서 그 Definition에 맞춰 작성해야 했다면, 백준에서는 그냥 배열로 풀 수 있었다.

문제에는 명시되어 있지 않지만, 입력되는 각 배열의 값들은 일단 오름차순으로 입력되는 듯 했다. 그래서 각 배열에 인덱스를 정해두고 옮겨가는 방법을 선택했다.
각 배열의 값을 비교해서 작은 값을 찾으면 출력 배열에 넣어두고 그 값을 가지고 있던 인덱스를 옮긴다. 두 인덱스 중 하나라도 각 배열의 크기를 넘기면 while문을 나오게 되고, 남은 값들을 출력 배열에 그대로 옮겨 담는다.

처음에는 남은 값들을 옮겨 담는 부분도 while문 안에 넣어두고 continue처리를 해주었는데 시간초과가 났다. 아마도 이 때문이 아니라 출력문이 버퍼가 아닌 Sysout이었기 때문인 것 같은데, 고치는 김에 밖으로 빼는 게 좋을 것 같아서 빼줬다.

출력할 때도 이제 버퍼를 계속 사용해야겠다..
