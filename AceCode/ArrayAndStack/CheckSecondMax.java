package ArrayAndStack;

class CheckSecondMax {
    public static void main(String[] args) {
        int[] arr  = {4,4,4,1,2};
        System.out.println(findSecondMaximum(arr));
    }
    public static int findSecondMaximum(int[] arr)
    {
        if(arr.length<=1){
            return -1;
        }
        // Write - Your - Codi
        qucikSort(arr,0,arr.length-1);
        for(int i=arr.length-1;i>1;i--){
            if(arr[i] != arr[i-1]){
                return arr[i-1];
            }
        }
        return -1;
    }

    public static void qucikSort(int[] arr,int start,int end){
        if(start >= end){
            return;
        }
        int value = arr[start];
        int i= start;
        int j= end;
        while(i<=j){
            if(arr[j] >= value){
                j--;
                continue;
            }
            if(arr[i] <= value){
                i++;
                continue;
            }
            changeValue(arr,i,j);
        }
        if(j==start-1){
            qucikSort(arr,start+1,end);
        }else if(i == end+1){
            changeValue(arr,start,end);
            qucikSort(arr,start,end-1);
        }else{
            changeValue(arr,start,j);
            qucikSort(arr,start,j-1);
            qucikSort(arr,j+1,end);
        }
    }

    public static void changeValue(int[] arr,int i,int j){
        int temp =arr[j];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}