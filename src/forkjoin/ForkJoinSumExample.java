package forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinSumExample {
    public static void main(String[] args) {
        int[] nums = new int[100];
        for(int i=0; i<nums.length; i++){
            nums[i]=i ;
        }
        int start =0;
        int end = nums.length;

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        SumTask task = new SumTask(nums, start, end);

        forkJoinPool.invoke(task);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
