class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(new ArrayList<>(), nums);
        return res;
    }
    public void helper(List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int n : nums){
            if(!list.contains(n)){
                list.add(n);
                helper(list, nums);
                list.remove(list.size()-1);
            }
        }
    }
}