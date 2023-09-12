package leetcode;

import java.util.HashMap;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])){
                result[0] = hashMap.get(nums[i]);
                result[1] = i;
                return result;
            }else {
                hashMap.put(target-nums[i],i);
            }
        }
        return result;
    }
}
