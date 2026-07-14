class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        Queue<Pair> queue = new LinkedList<>();
        int[] dict = new int[26];
        for(char c : tasks){
            dict[c-'A']++;
        }
        for(int el : dict){
            if(el>0){
                heap.offer(el);
            }
        }
        int time = 0;
        while(!heap.isEmpty() || !queue.isEmpty()){
            time++;
            int currElement =0 ;
            if(!heap.isEmpty()){
                currElement = heap.poll();
                currElement--;
            }
            
            if(currElement>0){
                queue.offer(new Pair(currElement, time+n));
            }
            if(!queue.isEmpty() && queue.peek().next == time){
                heap.offer(queue.poll().size);
            }
        }
        return time;
    }
}
class Pair {
    int next; 
    int size ;
    Pair(int size , int next){
        this.size = size ;
        this.next = next; 
    }
}