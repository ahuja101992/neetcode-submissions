class Solution {
    public boolean canJump(int[] nums) {
        int maxSpot = 0;
        for(int i=0;i< nums.length;i++){
            if(i> maxSpot) return false;
            maxSpot = Math.max(maxSpot, i+nums[i]);
        }
        return true; 
    }
}