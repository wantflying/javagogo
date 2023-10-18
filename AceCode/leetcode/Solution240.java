package leetcode;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        int i = 0;
        int j =length-1;
        while (i <= j){
            int mid = (i+j)/2;
            if(matrix[mid][mid] == target) return true;
            if(matrix[mid][mid] > target){
                j = mid-1;
            }else {
                i = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] test = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24}};
        Solution240 solution240 = new Solution240();
        System.out.println(solution240.searchMatrix(test,-1));
    }
}
