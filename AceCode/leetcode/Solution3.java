package leetcode;

import java.util.HashSet;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 0) return 0;
        int j = 1;
        int i=0;
        int maxSize = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while (i < s.length() && j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                maxSize = Math.max(maxSize,set.size());
            }else {
                set.remove(s.charAt(i));
                i++;
            }
        }



        return maxSize;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("saaabbcccdd"));
    }
}
