class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Integer> indegree = new HashMap<>();
      Map<Character, Set<Character>> adj = new HashMap<>();
      for(String word: words){
        for(char ch: word.toCharArray()){
            indegree.putIfAbsent(ch, 0);
            adj.putIfAbsent(ch, new HashSet<>());
        }
      }
      for (int i = 0; i < words.length - 1; i++) {
        String w1 = words[i];
        String w2 = words[i+1];
        for( int j=0;j<Math.min(w1.length(), w2.length());j++){
            if(w1.charAt(j)!= w2.charAt(j)){
                if(!adj.get(w1.charAt(j)).contains(w2.charAt(j))){
                    indegree.put(w2.charAt(j), indegree.get(w2.charAt(j))+1);
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                }
                break ;
            }
            if(w1.length() > w2.length()) return "";
        }
      }

      Queue<Character> queue = new LinkedList<>();
      for(char ch: indegree.keySet()){
        if(indegree.get(ch)==0){
            queue.offer(ch);
        }
      }
      StringBuilder sb = new StringBuilder();
      while(!queue.isEmpty()){
        char curr = queue.poll();
        sb.append(curr);
        Set<Character> list = adj.get(curr);
        for(char ch : list){
            indegree.put(ch, indegree.get(ch)-1);
            if(indegree.get(ch) ==0){
                queue.offer(ch);
            }
        }
      }
      if(sb.length()!= indegree.size()){
        return "";
      }
      return sb.toString();
    }
}
