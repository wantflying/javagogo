package Hashtable;

import java.util.HashSet;

//Hash Set  =>  HashSet<Integer> hSet = new HashSet<>();
//HashMap   =>  HashMap<Integer,String> hMap = new HashMap<>();
//HashTable =>  Hashtable<Integer,String> hTable = new Hashtable<>();
//Hash Set Functions => {add(), remove(), contains()}
//Hash Map and Table Functions => {put(key,value), get(key), remove(key), containsKey(key), containsValue(value)}
class CheckSubset {
    public static boolean isSubset(int[] arr1, int[] arr2) {
        // write your code here
        if(arr2.length > arr1.length) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if(!set.contains(arr2[i])){
                return false;
            }
        }

        return true;
    }
}