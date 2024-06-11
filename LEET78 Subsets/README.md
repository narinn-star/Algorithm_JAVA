# [Leetcode 78] Subsets

## 분류
> Array
> 
> Backtracking
> 
> Bit Manipulation

## 코드
```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, res, 0, new ArrayList<>());

        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, int idx, List<Integer> tmpList){
        if(nums.length == idx){
            res.add(new ArrayList<>(tmpList));
            return;
        }

        backtrack(nums, res, idx + 1, tmpList);
        tmpList.add(nums[idx]);

        backtrack(nums, res, idx + 1, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }
}
```

## 문제풀이

'선택하느냐 하지 않느냐'가 가장 적합한 설명인 듯하다.
[1, 2, 3]을 예시로 보면, 
1을 선택하느냐 하지 않느냐, 2를 선택하느냐 하지 않느냐, 3을 선택하느냐 하지 않느냐 

이렇게 총 2^3 = 8가지가 나오게 되는 것.

트리를 그려보면 조금 더 이해하기 쉽다. dfs방식으로 하면서 다시 돌아오는 것만 넣어주면 되는 가장 베이직한 백트래킹 문제다.

List로 구현되어 있기 때문에 idx를 가지고 넣고 빼는 것만 반복해주면 된다.
