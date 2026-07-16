class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        for(String word: wordList){
            set.add(word);
        }

        queue.offer(beginWord);
        set.remove(beginWord);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int i=0;i< size ;i++){
                String curr = queue.poll();
                char[] currWord = curr.toCharArray();
                for(int j=0;j<currWord.length;j++){
                    char orig = currWord[j];
                    for(char ch = 'a'; ch<='z';ch++){
                        currWord[j] = ch;
                        String newWord= String.valueOf(currWord);
                        if(set.contains(newWord)){
                            // System.out.println(newWord);
                            if(newWord.equals(endWord)){
                                return count+1;
                            }
                            set.remove(newWord);
                            queue.add(newWord);
                        }
                        currWord[j] = orig;
                    }
                }
            }
        }
        return 0;
    }
}