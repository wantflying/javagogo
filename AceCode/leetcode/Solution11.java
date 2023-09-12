package leetcode;

public class Solution11 {
    public int maxArea(int[] height) {
        int i =0 ;
        int j = height.length-1;
        int max = 0;
        int preLeftValue = 0;
        int preRightValue = 0;
        while (i<j){
            if( height[i] <= height[j]){
                if(height[i]>preLeftValue){
                    max = Math.max(max,(j-i)*height[i] );
                    preLeftValue = height[i];
                }
                i++;
            }else {
                if(height[j]>preRightValue){
                    max = Math.max(max,(j-i)*height[j] );
                    preRightValue = height[j];
                }
                j--;
            }
        }
        return max;
    }
}
