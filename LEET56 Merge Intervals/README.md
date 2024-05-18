# [Leetcode 56] Merge Intervals

## 분류
> Array
> 
> Sorting

## 코드
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> { return o1[0] - o2[0]; });

        for(int i = 0; i < intervals.length; i++){
            int start = intervals[i][0], end = intervals[i][1];
            while(i < intervals.length - 1 && intervals[i + 1][0] <= end){
                end = Math.max(end, intervals[i+1][1]);
                i++;
            }
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(start);
            tmpList.add(end);
            resList.add(tmpList);
        }

        int[][] result = new int[resList.size()][2];
        for(int i = 0; i < resList.size(); i++){
            result[i][0] = resList.get(i).get(0);
            result[i][1] = resList.get(i).get(1);
        }

        return result;
    }
}
```

## 문제풀이

겹치는 구간이 있으면 merge를 해주는 문제다. 
앞에서 미리 오름차순으로 해뒀기 때문에, end값만 비교해주면 된다. 현재 end값이 다음 start값보다 같거나 작을 때 병합을 해줘야하므로, 이에 맞게 반복문을 실행해 다음 end값과 비교해서 갱신해주고 인덱스도 다음번으로 넘겨주는것을 반복한다. 이렇게 하면 [i][0]이 start인, 병합된 구간 하나가 완성되고 이를 tmpList에 넣는 것을 반복해줬다.

사실 이런 문제는 문제 풀이는 빨리 끝나는데, 배열에 다시 담아주는 과정이 오래걸린다. List<List<Integer>>형식을 선택했고, 마지막엔 다시 한 번 이차원배열에 옮겨주는 작업을 해줬는데, 이게 최선일까🙄
List<int[]>에 해줘도 마지막에 return 할 때는 이차원배열로 바꿔서 해줘야하는게 맞는 듯하다. 
