package ArrayAndStack;

import java.util.Arrays;

class FindBinChallenge {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findBin(5)));
    }
    public static String[] findBin(int number) {
        String[] result = new String[number];
        Queue<String> queue = new Queue<String>(number + 1);

        queue.enqueue("1");

        for (int i = 0; i < number; i++) {
            result[i] = queue.dequeue();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            queue.enqueue(s1);
            queue.enqueue(s2);
        }

        return result;
    }
}