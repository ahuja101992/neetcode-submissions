/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);        
        
        for(ListNode list : lists){
            if(list!= null)
                heap.offer(list);
        }
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while(!heap.isEmpty()){
            ListNode curr = heap.poll();
            res.next = curr;
            if(curr.next != null){
                heap.offer(curr.next);
            }
            res = res.next; 
        }
        res.next =  null;
        return temp.next; 
    }
}
