package ArrayAndStack;

import java.util.HashMap;

class CheckFirstUnique1
{
    public static void main(String[] args) {
        int[] arr  = {4,4,4,1,2};
        System.out.println(findFirstUnique(arr));
    }

    public static int findFirstUnique(int[] arr)
    {
        int result = 0;
        int[] temarr =new  int[arr.length];
        // write your code here
        for(int i=0;i<arr.length;i++){
            temarr[i] = arr[i];
        }
        quickSort(temarr,0,temarr.length-1);
        HashMap<Integer,Integer> uniqueKey =  new HashMap<>();
        int i=0,j=1;
        while(i<temarr.length && j<=temarr.length){
            if(i == temarr.length-1){
                uniqueKey.put(temarr[i],0);
                break;
            }
            if(j == temarr.length && j-i>1){
                break;
            }
            if(temarr[i] == temarr[j]){
                j++;
            }else if (j-i>1){
                i=j;
                j++;
            }else{
                uniqueKey.put(temarr[i],0);
                i=j;
                j++;
            }
        }
        if(uniqueKey.size() == 0) return result;
        for(int ii=0;ii<arr.length;ii++){
            if(uniqueKey.containsKey(arr[ii])){
                return arr[ii];
            }
        }
        return result;
    }

    public static void quickSort(int[] arr,int start,int end){
        if(start>= end) return;
        int i= start;
        int j=end;
        int value = arr[start];
        while(i<=j){
            if(arr[j]>=value){
                j--;
                continue;
            }
            if(arr[i] <=value){
                i++;
                continue;
            }
            changeValue(arr,i,j);
        }
        if(j== start-1){
            quickSort(arr,start+1,end);
        }else if(i == end+1){
            changeValue(arr,start,end);
            quickSort(arr,start,end-1);
        }else{
            changeValue(arr,start,j);
            quickSort(arr,start,j-1);
            quickSort(arr,j+1,end);
        }

    }
    public static void changeValue(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp; }
}