package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            quickSort(chars,0,chars.length-1);
            String value = Arrays.toString(chars);
            if(hashMap.containsKey(value)){
                List<String> strings = hashMap.get(value);
                strings.add(strs[i]);
//                hashMap.put(value,strings);
            }else {
                List<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                hashMap.put(value,strings);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : hashMap.keySet()){
            result.add(hashMap.get(key));
        }
        return result;
    }

    public static void quickSort(char[] chars, int start, int end) {
        if(start >= end) return;
        int i = start;
        int j = end;
        char value = chars[i];
        while (i<=j){
            if(chars[j] >= value){
                j--;
                continue;
            }
            if(chars[i]<=value){
                i++;
                continue;
            }
            changeValue(chars,i,j);
        }
        if(j == start-1){
            quickSort(chars,start+1,end);
        }else if(i == end+1){
            changeValue(chars,start,end);
            quickSort(chars,start,end-1);
        }else {
            changeValue(chars,start,j);
            quickSort(chars,start,j-1);
            quickSort(chars,j+1,end);
        }

    }

    public  static void changeValue(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
//        String[] strings = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        String[] strings = {"duh","ill"};
        Solution49 solution49 = new Solution49();
        System.out.println(solution49.groupAnagrams(strings));
    }
}
