class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    public void helper(List<Integer> list, int[] nums, boolean[] visited){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            if(!visited[i]){
                list.add(n);
                visited[i] = true;
                helper(list, nums, visited);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}