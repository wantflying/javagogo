package ArrayAndStack;

class ReverseKChallenge {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);

        reverseK(queue,5);

        System.out.print("ArrayAndStack.Queue: ");
        while(!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
    public static <V> void reverseK(Queue<V> queue, int k) {
        // Write -- Your -- Code
        int size = queue.getCurrentSize();
        Stack<V> kvalue = new Stack(k);
        for(int i=0;i<k;i++){
            kvalue.push(queue.dequeue());
        }
        Queue<V> newQueue = new Queue(size);
        for(int i=0;i<k;i++){
            newQueue.enqueue(kvalue.pop());
        }
        for(int i=k;i<size;i++){
            newQueue.enqueue(queue.dequeue());
        }
        queue = new Queue(size);
        for(int i=0;i<size;i++){
            queue.enqueue(newQueue.dequeue());
        }

    }
}