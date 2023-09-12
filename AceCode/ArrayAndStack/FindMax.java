package ArrayAndStack;

class FindMax {
    public static void main(String[] args) {
        int[] arr = {5, 1, -4, 2, 3};
        System.out.println(findMaxSumSubArray(arr));;
    }
    public static int findMaxSumSubArray(int[] arr) {
        // Write - Your - Codie
        if(arr.length == 0)
            return 0;
        return maxValue(arr,arr.length-1);
    }
    public static int maxValue(int[] arr,int n){
        if(n == 0){
            return arr[0];
        }
        //if(n == 1){
        //     return Math.max(Math.max(arr[0],arr[1]),arr[0]+arr[1]);
        //    }
        return Math.max(Math.max(maxValue(arr,n-1),arr[n]),maxValue(arr,n-1)+arr[n]);
    }
}