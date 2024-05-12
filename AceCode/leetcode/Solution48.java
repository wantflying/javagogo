package leetcode;

import java.util.Arrays;

public class Solution48 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int j = 0; j <(length/2); j++) {
            changeValue(matrix,j);
         }
    }

    /**
     * 交换值
     *
     * @param matrix
     * @param j
     */
    private void changeValue(int[][] matrix, int j) {
        int startPoint=j;
        int endPoint = matrix.length - startPoint-1;
        for (int i = startPoint; i <endPoint; i++) {
            changeFirstValue(matrix,startPoint,i,i,endPoint);
            changeFirstValue(matrix,startPoint,i,endPoint,endPoint-(i-startPoint));
            changeFirstValue(matrix,startPoint,i,endPoint-i+startPoint,startPoint);

        }
    }

    private void changeFirstValue(int[][] matrix, int i, int startPoint, int endPoint, int i1) {
        int temp = matrix[i][startPoint];
        matrix[i][startPoint] = matrix[endPoint][i1];
        matrix[endPoint][i1] = temp;
    }

    public static void main(String[] args) {
//        int[][] test  = {{1,2}, {4,5}};
//        int[][] test  = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] test  = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        Solution48 solution48 = new Solution48();
        solution48.rotate(test);
        System.out.println(Arrays.deepToString(test));

    }
}
