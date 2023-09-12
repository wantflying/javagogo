package Hashtable;

import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

//Hash Set  =>  HashSet<Integer> hSet = new HashSet<>();
//HashMap   =>  HashMap<Integer,String> hMap = new HashMap<>();
//HashTable =>  Hashtable<Integer,String> hTable = new Hashtable<>();
//Hash Set Functions => {add(), remove(), contains()}
//Hash Map and Table Functions => {put(key,value), get(key), remove(key), containsKey(key), containsValue(value)}
class CheckPath {

    public static String tracePath(Map<String,String> map) {

        String result = "";
        HashSet<String> set = new HashSet<>();
        map.forEach((k,v) ->{
            set.add(v);
        });
        AtomicReference<String> first = null;
        map.forEach((k,v) ->{
            if(!set.contains(k)){
                first.set(k);
            }
        });
        // Write - Your - Code
        return result;
    }
}