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
