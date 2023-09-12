package ArrayAndStack;

class SortValuesChallenge {

    public static void main(String args[]) {

        Stack<Integer> stack = new Stack<Integer>(7);
        stack.push(2);
        stack.push(97);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(60);
        stack.push(23);
        sortStack(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    public static void sortStack(Stack<Integer> stack) {
        // Write -- Your -- Code
        int size = stack.getCurrentSize();
        int[] arr = new int[size];
        int i=0;
        while(!stack.isEmpty()){
            arr[i++] = stack.pop();
        }
        quickSrot(arr,0,size-1);
        for(int j=size-1;j>=0;j--){
            stack.push(arr[j]);
        }
    }

    public static void quickSrot(int[] arr,int start,int end){
        if(start >= end) return;
        int i=start;
        int j =end;
        int value  = arr[i];
        while(i<=j){
            if(arr[j]>= value){
                j--;
                continue;
            }
            if(arr[i] <= value){
                i++;
                continue;
            }
            changevalue(arr,i,j);
        }
        if(j==start-1){
            quickSrot(arr,start+1,end);
        }else if(i == end+1){
            changevalue(arr,start,end);
            quickSrot(arr,start,end-1);
        }else{
            changevalue(arr,start,j);
            quickSrot(arr,start,j-1);
            quickSrot(arr,j+1,end);
        }
    }
    public static void changevalue(int[] arr,int i,int j){
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
}