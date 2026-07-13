class Solution {
    Map<Character, String> phone = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
      }};
    char[] arr;
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return res;
        }
        arr = digits.toCharArray();
        helper(new StringBuilder(), 0);
        return res;
    }
    public void helper(StringBuilder sb,int index){
        if(index == arr.length){
            res.add(sb.toString());
            return;
        }
        String str = phone.get(arr[index]);
        for(char ch : str.toCharArray()){
            sb.append(ch);
            helper(sb, index+1);
            sb.setLength(sb.length()-1);
        }
    }
}