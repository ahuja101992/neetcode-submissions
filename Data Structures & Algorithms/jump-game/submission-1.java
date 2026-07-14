class Solution {
    public boolean canJump(int[] nums) {
        // 2,0,0
        int goal = nums.length-1;
        for(int i= nums.length-2;i>=0;i--){
            if(i+ nums[i]>=goal){
                goal = i;
            }
           
        }
        return goal ==0 ;
    }
}