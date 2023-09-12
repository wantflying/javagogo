package leetcode;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        int i = -1;
        int j=0;
        while (i<nums.length && j<nums.length){
            //找到第一个0
            if(nums[j] != 0 && i == -1){
                j++;
                continue;
            }else if(i == -1) {
                i=j;
            }

            if(nums[j] ==0){
                j++;
            }else {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            }

        }
    }


}
