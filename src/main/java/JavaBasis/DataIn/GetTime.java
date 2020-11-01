package JavaBasis.DataIn;

import java.util.Scanner;

/**
 * @author xxx
 * @date 2020/10/31 18:08
 */
public class GetTime {
    /**在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
     * 现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
     * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
     * 提示：
     * 你可以假定时间序列数组的总长度不超过 10000。
     * 你可以假定提莫攻击时间序列中的数字和提莫攻击的中毒持续时间都是非负整数，并且不超过 10,000,000。*/
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sumTime = 0;
        for(int i = 1;i <= timeSeries.length;i++){
            if(i<timeSeries.length){
                int diff = timeSeries[i]-timeSeries[i-1];
                if(diff > duration){
                    sumTime += duration;
                }else{
                    sumTime += diff;
                }
            }else {
                sumTime += duration;
            }
        }
        return sumTime;
    }

    /**给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
     * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
     * */
    public int thirdMax(int[] nums) {
        if(nums.length < 3){
            if(nums.length==2){
                return Math.max(nums[0],nums[1]);
            }
            if(nums.length>0){
                return nums[0];
            }else{
                System.out.println("数据为空！");
            }
        }

        int[] result = {-1,-1,-1};
        for(int i = 0;i < nums.length;i++){
            if(i==0){
                result[0] = i;continue;
            }
            if(nums[i]>=nums[result[0]]){
                if(nums[i]==nums[result[0]]){
                    continue;
                }
                result[2]=result[1];
                result[1]=result[0];
                result[0]=i;
                continue;
            }else {
                if(i==1 || result[1]==-1){
                    result[1] = i;continue;
                }
                if(nums[i]>=nums[result[1]]){
                    if(nums[i]==nums[result[1]]){
                        continue;
                    }
                    result[2] = result[1];
                    result[1] = i;
                    continue;
                }else{
                    if(result[2]==-1){
                        result[2] = i;continue;
                    }
                    if(nums[i]>nums[result[2]]){
                        result[2] = i;
                    }
                }
            }
        }
        for (int i : result) {
            System.out.print(i+"  ");
        }
        if(result[2]==-1){
            return nums[result[0]];
        }
        return nums[result[2]];
    }

    public static void main(String[] args){
        GetTime getTime = new GetTime();
        int[] arr = {2, 2, 3, 1};
        System.out.println(arr[2]);
        System.out.println(getTime.thirdMax(arr));
    }
}
