class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(0, new ArrayList<>(), 0, candidates, target);
        return res;
    }
    public void helper (int sum, List<Integer> sublist,int start, int[] candidates, int target){
        // System.out.println("sum: "+ sum+ "  index: "+ start);
        if(sum == target){
            res.add(new ArrayList<>(sublist));
            // System.out.println(res);
            return;
        }
        if(sum > target){
            return;
        }
        for(int i = start; i< candidates.length;i++){
            sum += candidates[i];
            sublist.add(candidates[i]);
            helper(sum, sublist, i, candidates, target);
            sublist.remove(sublist.size()-1);
            sum-=candidates[i];
        }
    }
}