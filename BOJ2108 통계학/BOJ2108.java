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
		
		return (int)Math.ceil(res);
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