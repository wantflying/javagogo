package gcDemo;

public class CanReliveObj {
    public static CanReliveObj obj;
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调⽤当前类的finalize⽅法");
        obj = this;
    }
    public static void main(String[] args) {
        try {
            obj = new CanReliveObj();
            obj = null;
            System.gc();
            System.out.println("第1次 gc");
            //因为 finalizer线程优先级很低，暂停2s，以等待它
            Thread.sleep(2000);
            if(obj == null){
                System.out.println("obj is dead");
            }else {
                System.out.println("obj is still alive");
            }
            System.out.println("第2次 gc");
            //下⾯这段代码与上⾯完全相同，但是这次却⾃救失败了
            obj = null;
            System.gc();
            //因为 finalizer线程优先级很低，暂停2s，以等待它
            Thread.sleep(2000);
            if(obj == null){
                System.out.println("obj is dead");
            }else {
                System.out.println("obj is still alive");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
