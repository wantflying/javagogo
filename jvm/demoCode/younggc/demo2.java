package younggc;

/**
 * 模拟年轻代对象进入老年代：1.动态年龄判断 2.大对象直接进入 3.达到存活年龄15
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -
 * XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -
 * XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * 新生代10MB  老年代10MB
 */
public class demo2 {
    public static void main(String[] args) {
        //1.动态年龄判断
        //E区为8M
/*        byte[] bytes = new byte[2*1024 * 1024];
        bytes = new byte[2*1024*1024];
        bytes = new byte[2*1024*1024];
        bytes = null;
        byte[] bytes1 = new byte[1024 * 128];
        //此时E区不足2MB,出发ygc
        byte[] bytes2 = new byte[1024 * 1024*2];

        byte[] bytes4 = new byte[1024 * 1024*3];
        bytes4 = null;
        //此时E区已经不足1MB，再放1MB就会触发Gc,同时from区域已经超过50%,根据动态年龄判断要进入老年代
        byte[] bytes5 = new byte[1024 * 1024*1];*/


        //2.大对象直接进入老年代
//        byte[] bytes = new byte[9*1024*1024];

        //3.动态年龄判断
//        byte[] bytes = new byte[0*1024];
/*        for (int i = 0; i < 10; i++) {
            byte[] bytes1 = new byte[5*1024*1024];
            bytes1=null;
            byte[] bytes2 = new byte[5*1024*1024];
            bytes2 = null;

        }*/
    }
}
