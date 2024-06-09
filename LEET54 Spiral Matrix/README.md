# [Leetcode 54] Spiral Matrix

## 분류
> Array
> 
> Matrix
> 
> Simulation

## 코드
```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> matrixList = new ArrayList<>();

        int sum = matrix[0].length * matrix.length;
        int len = matrix[0].length;
        int idx = 0, cnt = 0;

        while(cnt < sum){
            //오른쪽
            for(int i = idx; i < len; i++){
                if(matrix[idx][i] != 101){
                    matrixList.add(matrix[idx][i]);
                    matrix[idx][i] = 101;
                    cnt++;
                }
            }

            //아래
            for(int i = idx; i < matrix.length; i++){
                if(matrix[i][len - 1 - idx] != 101){
                    matrixList.add(matrix[i][len - 1 - idx]);
                    matrix[i][len - 1 - idx] = 101;
                    cnt++;
                }
            }

            //왼쪽
            for(int i = len - 1; i >= idx; i--){
                if(matrix[matrix.length - 1 - idx][i] != 101){
                    matrixList.add(matrix[matrix.length - 1 - idx][i]);
                    matrix[matrix.length - 1 - idx][i] = 101;
                    cnt++;
                }
            }
            
            //위
            for(int i = matrix.length - 1; i >= idx; i--){
                if(matrix[i][idx] != 101){
                    matrixList.add(matrix[i][idx]);
                    matrix[i][idx] = 101;
                    cnt++;
                }
            }

            idx++;
        }

        return matrixList;

    }
}
```

## 문제풀이

백준에서 비슷한 문제를 풀어본 적이 있어서 쉽게 풀었다. Medium까지는 아니라고 생각한 첫 문제..

그냥 오른쪽, 아래, 왼쪽, 위 네 방향 모두 적절한 인덱스값으로 뱅글뱅글 돌기만 하면 된다. matrix 배열에 들어가는 값이 -100부터 100까지여서, 따로 visited를 만들지 않고 101을 넣어줘서 방문 여부를 한 번에 체크해줬다. 한 방향을 실행할 때마다 cnt를 증가시켜 총 배열 개수 (n x m)보다 작을 때만 뱅글뱅글 돌도록 했다.
