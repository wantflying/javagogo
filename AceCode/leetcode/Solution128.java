package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num,false);
        }
        int max = 0;
        Iterator<Integer> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();
            Boolean isVisit = hashMap.get(key);
            if(!isVisit){
                int distance =1;
                int i = key-1;
                int j = key+1;
                while (hashMap.containsKey(i)){
                    hashMap.put(i,true);
                    distance++;
                    i--;
                }
                while (hashMap.containsKey(j)){
                    hashMap.put(j,true);
                    distance++;
                    j++;
                }
                max = Math.max(max,distance);
            }
        }
        return max;
    }
}
