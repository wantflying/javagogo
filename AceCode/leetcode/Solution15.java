package leetcode;

import java.util.*;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  lists = new ArrayList<>();
        if(nums.length<3) return lists;

        Arrays.sort(nums);
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i : nums) {
            if(!set.containsKey(i)){
                set.put(i,1);
            }else {
                Integer integer = set.get(i);
                integer++;
                set.put(i,integer);
            }
        }
        for (int i = 0; i<= nums.length-3 &&nums[i]<=0; i++) {
            if(i >0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i]==0){
                if(i+2 <=nums.length-1 && nums[i+1] == 0 && nums[i+2] ==0 ){
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(0);
                    arrayList.add(0);
                    arrayList.add(0);
                    lists.add(arrayList);
                }
                break;
            }
            int j = nums.length-1;
            while (nums[j] >0){
                if(j<nums.length-1 && nums[j] == nums[j+1]){
                    j--;
                    continue;
                }
                int third = -(nums[i] + nums[j]);
                if(third >nums[j] ){
                    break;
                }else if(third <nums[i]){
                    j--;
                    continue;
                }
                if (set.containsKey(third)){
                    if(third == nums[i]){
                        if(set.get(third)==1){
                            j--;
                            continue;
                        }
                    }else if(third == nums[j]){
                        if(set.get(third)==1){
                            j--;
                            continue;
                        }
                    }
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i] );
                    arrayList.add(nums[j] );
                    arrayList.add(third);
                    lists.add(arrayList);
                }
                j--;
            }

        }
        return lists;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] a = {-4,-2,-1};
        System.out.println(solution15.threeSum(a));
    }
}
