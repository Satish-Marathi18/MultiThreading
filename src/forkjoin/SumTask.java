package forkjoin;

import java.util.concurrent.RecursiveAction;

public class SumTask extends RecursiveAction {
    private static final int THRESHOLD = 10;

    private int[] nums;
    private int start;
    private int end;

    SumTask(int[] nums, int start, int end) {
        this.nums=nums;
        this.start=start;
        this.end=end;
    }

    @Override
    protected void compute() {
        if(end-start <= THRESHOLD){
            for(int i=0; i<nums.length; i++){
                nums[i]++;
            }
        }
        else {
            int mid = (start + end)/2;
            SumTask lefTask = new SumTask(nums, start, mid);
            SumTask righTask = new SumTask(nums, mid+1, end);

            invokeAll(lefTask,righTask);
        }
    }
    
}
