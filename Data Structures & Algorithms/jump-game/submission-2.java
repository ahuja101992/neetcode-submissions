class Solution {
    public boolean canJump(int[] nums) {
        int maxSpot = 0;
        for (int i=0;i< nums.length;i++){
            if(maxSpot<i){
                return false;
            }
            maxSpot = Math.max(maxSpot, nums[i]+i);
        }
        return true ;
    }
}