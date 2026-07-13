class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(new ArrayList<>(), 0, nums);
        return res;
    }

    public void helper(List<Integer> sublist, int start, int[] nums){
        res.add(new ArrayList<>(sublist));
        for(int i= start;i<nums.length;i++){
            if(i> start && nums[i] == nums[i-1]) continue;
            sublist.add(nums[i]);
            helper(sublist, i+1, nums);
            sublist.remove(sublist.size()-1);
        }
    }
}
