package ArrayAndStack;

class CheckMaxMin {
    public static void main(String[] args) {
        int[] arr =  {1,2,3,4,5,6,7};
        maxMin(arr);
    }
    public static void maxMin(int[] arr) {
        quickSort(arr,0,arr.length-1);
        int[] result = new int[arr.length];
        int i=0;
        int j= arr.length-1;
        int k=0;
        while(i<=j){
            if(i==j){
                result[k] = arr[i];
                break;
            }
            result[k] = arr[j];
            result[k+1] = arr[i];
            i++;
            j--;
            k+=2;
        }
        arr = result;
        // Write - Your - Code
    }

    public static void quickSort(int[] arr,int start,int end){
        if(start >= end) return;
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
        if(j == start -1){
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
        arr[j] = temp;
    }
}