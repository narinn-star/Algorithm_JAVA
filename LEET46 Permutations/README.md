# [Leetcode 46] Permutations

## 분류
> Array
> 
> Backtracking

## 코드
```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        permutation(nums, resList, new ArrayList<>(), visited);
        return resList;
    }

    private void permutation(int[] nums, List<List<Integer>> res, List<Integer> current, boolean[] visited){
        if(current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                current.add(nums[i]);
                permutation(nums, res, current, visited);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}
```

## 문제풀이

첫번째 백트래킹 문제다.

숫자를 가지고 만들 수 있는 모든 순열을 출력하는 문제로, 가장 대표적인 문제다. 
visited boolean 배열으로 갔던 곳을 체크하고 다시 가야할 곳을 false로 돌려놓는 것을 반복하면서 사이에 재귀 함수를 호출해줬다. 그렇게 하면 [1,2,3], [1,3,2] ... 이렇게 되는데 1 -> 3으로 갈 수 있는 이유는 함수를 되돌아와서 진행할 반복문의 i가 2이므로, false로 풀려있는 3이 들어가게 되는 것이다. 
이 재귀와 true/false를 반복하면 모든 순열이 출력된다.
