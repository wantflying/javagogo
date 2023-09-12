package leetcode;

public class Solution42 {
    // [0,1,0,2,1,0,1,3,2,1,2,1]
    public int trap(int[] height) {
        int maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i]>maxHeight) maxHeight=height[i];
        }
        //从前向后找
        int i1 =0; int j1=-1;
        int size =0;
        int currentSize = 0;
        while (height[i1] < maxHeight){
            if(height[i1] <= height[i1+1]){
                i1++;
            }else {
                //找到凹槽 查看凹槽深度
                if(j1 == -1) j1 = i1+1;
                if( height[j1] < height[i1]){
                    currentSize = currentSize - height[j1];
                    j1++;
                }else {
                    currentSize += (j1 - i1-1) * height[i1];
                    size += currentSize;
                    currentSize = 0;
                    i1 = j1;
                    j1=-1;
                }
            }
        }
        //从向后前找
        int i2 =height.length-1; int j2=-1;
        while (height[i2] < maxHeight){
            if(height[i2] <= height[i2-1]){
                i2--;
            }else {
                //找到凹槽 查看凹槽深度
                if(j2 == -1) j2 = i2-1;
                if( height[j2] < height[i2]){
                    currentSize = currentSize - height[j2];
                    j2--;
                }else {
                    currentSize += (i2 - j2-1) * height[i2];
                    size += currentSize;
                    currentSize = 0;
                    i2 = j2;
                    j2=-1;
                }
            }
        }
        //取中间
        if(i1 == i2 || i2 -i1 == 1) return size;
        int midSize =(i2-i1-1)*maxHeight;
        for(int k=i1+1;k<i2;k++){
            midSize -= height[k];
        }
        return size+midSize;
    }

    public static void main(String[] args) {
        int[] test  = {1,0,2,0,4};
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.trap(test));
    }
}
