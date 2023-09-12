package leetcode;

import java.util.Arrays;

public class Solution45 {

    //备忘录模式
    public static int jump1(int[] nums) {
        int[] moveTime = new int[nums.length];
        for (int i = 0; i < moveTime.length; i++) {
            moveTime[i] = Integer.MAX_VALUE;
        }
        moveTime[0] = 0;

        for (int i = 0; i < nums.length-1; i++) {
            int value = nums[i];
            //不可达节点
            if(value == 0) continue;
            for (int i1 = i+1; i1-i <= value && i1< nums.length; i1++) {
                moveTime[i1] = Math.min(moveTime[i1], moveTime[i]+1);
            }
        }

        return moveTime[nums.length-1];
    }

    public static void main(String[] args) {
        int[] arr  = {2,3,1,1,4};
        System.out.println(jump1(arr));
    }
}
