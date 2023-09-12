package ArrayAndStack;

public class MinStack {


    int maxSize;
    private Stack<Integer> originStack;
    private  Stack<Integer> minStack;
    //constructor
    public MinStack(int maxSize) {
        // Write -- Your -- Code
        this.maxSize = maxSize;
        originStack = new Stack(maxSize);
        minStack = new Stack(maxSize);
    }
    //removes and returns value from stack
    public Integer pop(){
        // Write -- Your -- Code
        Integer pop = originStack.pop();
        if(minStack.top() == pop){
            return minStack.pop();

        }else {
            Stack<Integer> temp  = new Stack(maxSize);
            while (minStack.top() != pop && !minStack.isEmpty()){
                temp.push(minStack.pop());
            }
            minStack.pop();
            while (!temp.isEmpty()){
                minStack.push(temp.pop());
            }
        }
        return pop;
    }
    //pushes value into the stack
    public void push(Integer value){
        // Write -- Your -- Code
        originStack.push(value);
        if(minStack.isEmpty()) {
            minStack.push(value);
        }else {
            if(minStack.top() >= value){
                minStack.push(value);
                return;
            }
            Stack<Integer> temp  = new Stack(maxSize);
            while (!minStack.isEmpty() && minStack.top() < value ){
                temp.push(minStack.pop());
            }
            minStack.push(value);
            while (!temp.isEmpty()){
                minStack.push(temp.pop());
            }
        }
    }
    //returns minimum value in O(1)
    public int min(){
        // Write -- Your -- Code
        return minStack.top();
    }
}