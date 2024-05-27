# [1713] 후보 추천하기

## 분류
> 구현
>
> 시뮬레이션

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Student {
    int num, time, cnt;
    boolean isPosted;
    public Student(int num, int time, int cnt, boolean isPosted) {
        this.num = num;
        this.cnt = cnt;
        this.time = time;
        this.isPosted = isPosted;
    }
}
public class BOJ1713 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Student students[] = new Student[101];
        ArrayList<Student> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int s = Integer.parseInt(st.nextToken()); // 학생 번호
            // 처음 추천 o
            if(students[s] == null) {
                students[s] = new Student(s, 0, 0, false);
            }
            // 게시되어 있음
            if(students[s].isPosted){
                students[s].cnt++;
            }
            // 게시되어 있지 않음
            else {
                if(list.size() == N){
                    Collections.sort(list, new Comparator<Student>() {
                        public int compare(Student o1, Student o2){
                            if(o1.cnt == o2.cnt){
                                return o1.time - o2.time;
                            }
                            return o1.cnt - o2.cnt;
                        }
                    });
                    list.get(0).isPosted = false;
                    list.remove(0);
                }
                students[s].cnt = 1;
                students[s].time = i;
                students[s].isPosted = true;
                list.add(students[s]);
            }
        }

        Collections.sort(list, (o1, o2) -> o1.num - o2.num);
        for(Student i : list){
            System.out.print(i.num + " ");
        }
    }
}

```

## 문제풀이

진짜 구현/시뮬레이션 부분이 약하다고 느낀 문제였다.

괜히 어렵게 풀으려 해서 그런 것인지, 아니면 진짜 그런 것 없이 너무 약한 것인지 모르겠다😢
하나씩 조건문만 잘 나누고 값들은 생각없이 객체로 관리해주면 너무너무 쉬운 문제였음.. 

학생 번호를 받자마자 바로 로직을 수행하면 된다.

처음 추천받는 학생이라면 객체를 만들어 학생 번호를 인덱스로 한 배열에 넣는다.
만약 게시되어 있었다면 cnt값만 올려주고, 게시되어 있지 않다면 뺄 친구를 찾아야한다. 사진틀이 꽉 차있을 땐 정렬을 해주는데, 이때 정렬은 cnt 기준으로 하되 동일한 cnt값이 여러개라면 time을 기준으로 정렬한다. 정렬 후에 맨 앞에 있는 값은 뺌과 동시에 isPosted도 false로 바꿔준다.

꺼낸 후에 입력받았던 학생을 이제 게시하면 된다.

마지막 출력은 num 기준으로 정렬해서 출력하면 끝 !
