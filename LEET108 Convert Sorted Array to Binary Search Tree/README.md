# [Leetcode 108] Convert Sorted Array to Binary Search Tree

## 분류
> Array
> 
> Divide and Conquer
> 
> Tree
> 
> Binary Search Tree
> 
> Binary Tree

## 코드
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums, 0, nums.length-1);
    }

    private TreeNode makeTree(int[] nums, int start, int end){
        if(start > end) return null;
        
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = makeTree(nums, start, mid - 1);
        root.right = makeTree(nums, mid + 1, end);

        return root;
    }
}
```

## 문제풀이

오름차순으로 주어진 입력값을 이분트리로 나타내는 문제다.

루트값만 잘 잡아주면 그 다음은 정점을 루트로 해서 재귀호출을 하면 된다.

각 루트 값은 가운데 값으로, 첫번째 값과 끝 값을 더한 것을 반으로 나누면 된다.
start값이 end값보다 커지면 null을 반환하고, 그 다음에 오른쪽 정점들도 같은 과정으로 탐색한다.
