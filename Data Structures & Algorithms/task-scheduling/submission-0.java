class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        Queue<Pair> queue = new LinkedList<>();
        int time = 0;
        int[] count = new int[26];
        for(int i=0;i<tasks.length;i++){
            count[tasks[i]-'A']++;
        }
        for(int i=0;i<26;i++){
            if(count[i]>0){
                maxHeap.offer(count[i]);
            }
        }
        // System.out.println(maxHeap + "  "+ maxHeap.size());
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            // System.out.println(time + " - time - start  ");
            if(!maxHeap.isEmpty()){
                int curr = maxHeap.poll()-1;
                // System.out.println(curr + " - curr  ");

                if(curr>0){
                    // System.out.println(curr+ " , "+ time +n);
                    queue.offer(new Pair(curr, time +n));
                }
            }
            if(!queue.isEmpty() && queue.peek().next == time){
                maxHeap.offer(queue.poll().size);
            }
            // System.out.println(time + " - time - end  ");

        }
        return time;
    }
}
class Pair{
    int next;
    int size;
    Pair(int s,int n){
        this.next = n;
        this.size = s;
    }
}