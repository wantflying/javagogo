package ArrayAndStack;

class CheckBalancedChallenge {
    public static void main(String[] args) {
        System.out.println(isBalanced("{}{}{}"));
    }
    public static boolean isBalanced(String exp) {
        // Write -- Your -- Codie
        char[] arrExp = exp.toCharArray();
        Stack<Character> stackExp = new Stack(arrExp.length);
        for(int i=0;i<arrExp.length;i++){
            char c = arrExp[i];
            if( c == '{' || c == '(' || c == '['){
                stackExp.push(c);
            }else{
                if(stackExp.isEmpty()) return false;
                char top = stackExp.pop();
                if(top != c) return false;
            }
        }
        if(stackExp.isEmpty()) return true;
        return false;
    }
}