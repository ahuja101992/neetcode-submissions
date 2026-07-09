class MedianFinder {

    PriorityQueue<Integer> lower; 
    PriorityQueue<Integer> upper;

    public MedianFinder() {
        lower = new PriorityQueue<>((a,b) -> b-a);
        upper = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(lower.isEmpty() ||num <= lower.peek()){
            lower.offer(num);
        } else {
            upper.offer(num);
        }
        if (lower.size()-upper.size()>= 2){
            upper.offer(lower.poll());
        } else if (upper.size() - lower.size() >=2 ){
            lower.offer(upper.poll());
        }
    }
    
    public double findMedian() {
        if(lower.size() == upper.size()){
            return (double) (upper.peek()+ lower.peek())/2;
        } else {
            if(lower.size()> upper.size()){
                return (double) lower.peek();
            } else {
                return (double) upper.peek();
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */