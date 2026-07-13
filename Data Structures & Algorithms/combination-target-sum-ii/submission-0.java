class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if(i>start && candidates[i] == candidates[i-1]) continue;
            sum += candidates[i];
            sublist.add(candidates[i]);
            helper(sum, sublist, i+1, candidates, target);
            sublist.remove(sublist.size()-1);
            sum-=candidates[i];
        }
    }
}