public class Main {
/*
当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：


	若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
	或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。


也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。

返回 A 的最大湍流子数组的长度。



示例 1：

输入：[9,4,2,10,7,8,8,1,9]
输出：5
解释：(A[1] > A[2] < A[3] > A[4] < A[5])


示例 2：

输入：[4,8,12,16]
输出：2


示例 3：

输入：[100]
输出：1




提示：


	1 <= A.length <= 40000
	0 <= A[i] <= 10^9

 */
    /**
     * 978. 最长湍流子数组
     * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
     *
     *
     * 	若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
     * 	或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
     *
     *
     * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
     *
     * 返回 A 的最大湍流子数组的长度。
     *
     * @param arr
     * @return
     */
    public static int maxTurbulenceSize(int[] arr) {
        int res = 0 ;
        int j = 0,temp,start;
        int len = arr.length;
        int[] bi = new int[len-1];
        //获取所有数字的比较符号
        for(int k = 0;k < len-1;k++){
            //0表示大于，1表示小于，2等于
            if(arr[k]>arr[k+1]){
                bi[k]=0;
            }
            else if(arr[k]<arr[k+1]){
                bi[k]=1;
            }
            else{
                bi[k]=2;
            }
        }

        //当只有一个数时，直接返回1
        if(len == 1){
            return 1;
        }
        if(len == 2 && arr[0]==arr[1]){
            return 1;
        }
        else if(len == 2 && arr[0]!=arr[1]){
            return 2;
        }
        //找出最大翻转比较符号长度
        for(int i = 0;i<len - 2;i++){
            //temp计每一个连续翻转串长度-1
            temp=0;
            start=i;
            j=start+1;
            while(start!=len-2){
                //翻转次数
                if(bi[start]!=2 && bi[j]!=2 && bi[start]!=bi[j]){
                    temp++;
                    start++;
                    j++;
                }
                else{
                    //处理连续两个2的情况
                    if(bi[start]==2 && bi[j]==2){
                        temp=-1;
                    }
                    if(res<temp+2){
                        res=temp+2;
                    }
                    break;
                }

                if(start==len-2 && bi[start]!=2){
                    if(res<temp+2){
                        res=temp+2;
                    }
                    break;
                }
            }

        }



        return res;
    }

    public static void main(String[] args) {
        int[] test = {100,100,100};
        int res = maxTurbulenceSize(test);
        System.out.println(res);
    }
}
