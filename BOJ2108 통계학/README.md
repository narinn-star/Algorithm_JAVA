# [2108] 통계학

## 분류
> 구현
>
> 정렬

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ2108 {
	static int N;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(nums);
		bw.write(mean() + "\n");
		bw.write(median() + "\n");
		bw.write(mode() + "\n");
		bw.write(range() + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	static public int mean() {
		double sum = 0;
		double res = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		res = Math.round(sum / nums.length);

		return (int) Math.ceil(res);
	}

	static public int median() {
		return nums[nums.length / 2];
	}

	static public int mode() {
		int[] cnt = new int[8001];
		ArrayList<Integer> list = new ArrayList<>();
		int max = Integer.MIN_VALUE; // 최빈값 찾기위한 비교 변수
		for (int x : nums) {
			if (x < 0) { // 음수의 경우 4000을 더해서 해당 인덱스 증가
				cnt[Math.abs(x) + 4000]++;
			} else // 나머지는 인덱스만 증가
				cnt[x]++;
		}

		int idx = 0;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] != 0 && cnt[i] > max) {
				max = cnt[i];
				idx = i;
			}
		}

		for (int i = 0; i < cnt.length; i++) {
			int x = i;
			if (cnt[i] == max) { // 카운트 배열의 값들과 최빈값 일치하면
				if (i > 4000) { // 4000이상은 음수를 바꿔준것이니 다시 원래 숫자로 바꾸기
					x -= 4000;
					x *= -1;
					list.add(x); // 리스트에 추가
				} else
					list.add(i); // 나머지는 그냥 i값 추가
			}
		}
		Collections.sort(list); // 추가된 최빈값들이 다수 존재하면 오름차순

		if (list.size() > 1)
			return list.get(1);
		else
			return list.get(0);
	}

	static public int range() {
		return nums[nums.length - 1] - nums[0];
	}
}
```

## 문제풀이

카운팅 정렬로는 푸는데에 어려움이 있어서 구글링을 통해 최빈값을 구했다. 

1. 산술평균

   입력받은 모든 수를 합해 N으로 나누고 소수점 첫째 자리에서 반올림한 값을 출력하면 된다. 천장함수 Math.ceil()를 사용한다. (*반대로 바닥함수는 Math.floor())

2. 중앙값

   이미 Main에서 오름차순 정렬을 해두었기 때문에 전체 배열 크기 / 2 에 위치한 값을 출력하면 된다.

3. 최빈값

   이 문제에서 가장 까다로운 부분이다. 각 값의 빈도수를 cnt 배열로 세어주어야 하는데 음수 인덱스를 가진 배열은 없기 때문에 -4000 부터 +4000까지를 모두 담을 수 있는 배열을 생성한다. 최빈값을 찾기 위한 비교변수로 max를 MIN_VALUE로 초기화하여 선언한다.

   우선 cnt 배열에 음수일때와 양수일때를 나누어 인덱스 값을 증가시켜주는데, cnt를 증가시킬 때 4000을 더한 인덱스의 값을 증가시킨다. 나머지는 그냥 증가시키면 된다. (음수가 앞쪽으로 오게 하려면 그냥 절대값을 취하지 않고 바로 4000을 더하되, 양수일 때 4000을 더하면 되겠다. 이는 이후에 x-=4000도 이에 맞게 수정하면 될 것 같다.)

   그 다음으로는 카운트 배열에서 최빈값을 찾는 차례이다. 반복문을 통해 모두 검사하는데, cnt값이 0이거나 max보다 작지 않으면 계속해서 최빈값을 찾아주며 max를 초기화해주면 된다.

   카운트 배열의 최댓값(최빈값)을 찾았으면 그에 해당하는 수를 출력하면 되는데, 찾기 위해서는 음수와 양수를 나누었던 것을 다시 돌려놓으면 된다. 반복문을 실행하면서 cnt값과 max가 일일치할 때 4000보다 크면 음수였다는 것이므로 다시 4000을 빼주고, -1을 곱하여 음수로 만들어준 후, ArrayList에 추가한다. 4000보다 같거나 작은 것은 양수였으므로 그대로 리스트에 추가한다.

   추가된 최빈값들이 여러개 있으면 오름차순으로 정렬하여 준다. 

   마지막으로 출력할 때는 최빈값 중 같은 것이 있을 때는 두번째로 작은 값을 출력해야하므로 조건문으로 나누어 최빈값을 알맞게 반환하면 된다.

4. 범위

   이 또한 오름차순 정렬을 해둔 배열의 가장 마지막 값에서 첫번째 값을 빼면 범위가 나온다.



//최빈값때문에 하루종일 고민했던 문제