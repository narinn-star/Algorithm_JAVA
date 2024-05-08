# [Leetcode 543] Diameter of Binary Tree

## 분류
> Tree
> 
> Depth-First Search
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
    // 트리의 지름 = 트리에서 두 노드 간의 가장 긴 경로의 길이
    private static int cnt;
    public int diameterOfBinaryTree(TreeNode root) {
        cnt = 0;
        treeDepth(root);
        return cnt;
    }
    private static int treeDepth(TreeNode root){
        if(root == null) return 0;

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        cnt = Math.max(cnt, left + right);

        return 1 + Math.max(left, right);
    }
}
```

## 문제풀이

트리의 지름이 무슨말인지 몰랐는데, 각 노드간 거리 중 가장 긴 거리를 뜻하는 것이라고 한다.
즉, [1,2,3,4,5]가 주어졌다면 4와 3의 거리가 3, 5와 3의 거리가 3이므로 이 트리의 지름은 3인 것이다.

왼쪽 노드의 깊이와 오른쪽 노드의 깊이를 더해주면 지름 값이 나오는 것을 알 수 있었고, 104번 문제와 비슷하게 풀었다. 다만 private static int cnt = 0;으로 미리 초기화해두는 것과 public int diameterOfBinaryTree에서 0으로 초기화하는 것이 다른 이유를 모르겠음....
