class Solution {
    public int jump(int[] nums) {
        int count =0;
        int maxSpot = 0;
        int maxWin = 0;
        for(int i=0;i<nums.length;i++){
            if(maxWin >= nums.length-1){
                return count;
            }
            maxSpot = Math.max(maxSpot, nums[i]+i);
            if(i == maxWin){
                count++;
                maxWin = maxSpot;
            }
        }
        return count;
    }
}