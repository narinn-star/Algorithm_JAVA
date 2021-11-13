# [2751] 수 정렬하기 2

## 분류
> 정렬

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(br.readLine())) ;
		}
		
		Collections.sort(arr);
		
		for(int val : arr) {
			bw.write(val + "\n"); 
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
```

## 문제풀이

Arrays.sort로 정렬했는데 시간초과가 났다.

Arrays.sort는 시간 복잡도가 O(n^2)이고, Collections.sort()는 O(n) ~ O(nlogn)이다. Collections.sort()는 ArrayList, LinkedList등 list 계열의 자료구조를 사용해 정렬해야한다.

입력받은 수를 순서대로 add를 사용하여 ArrayList에 넣어주고, 정렬해준 뒤 하나씩 출력하면 된다.