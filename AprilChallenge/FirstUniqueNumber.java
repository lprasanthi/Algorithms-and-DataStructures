// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/
public class FirstUniqueNumber {
    class Node{
        public int data;
        public Node next;
        public Node prev;
        public Node(int data){
            this.data = data;
            this.next=null;
            this.prev=null;
        }
        public String toString(){
            return ""+data;
        }
    }
    class FirstUnique {
        Map<Integer, Node> map;
        Node head;
        Node tail;
        public FirstUnique(int[] nums) {
            map=new HashMap<Integer, Node>();
            for(int i : nums){
                add(i);
            }
        }
        
        public int showFirstUnique() {
            return head==null ? -1 : head.data;
        }
        
        private void deleteNode(int value){
            Node node= map.get(value);
            if(node==null) return;
            if(head != tail && node != head && node != tail){
                node.prev.next=node.next;
                node.next.prev=node.prev; 
            }
            if(node == head) { 
                head= head.next; 
                if(head!=null) head.prev=null;
            }
            if(node == tail) { 
                tail=tail.prev; 
                if(tail != null) tail.next=null;
            }
            map.put(value, null);
        }
        private void addNode(int value){
            Node node=new Node(value);
            if(tail != null){
                tail.next=node;
                node.prev=tail;
                tail=tail.next;
            }
            if(null == head) head= node;
            if(null == tail) tail= node;
            map.put(value,node);
            //System.out.println(map);
        }
        public void add(int value) {
            if(!map.containsKey(value)){
                addNode(value);
            }else{
               deleteNode(value);
            }
        }
    }
    
    /**
     * Your FirstUnique object will be instantiated and called as such:
     * FirstUnique obj = new FirstUnique(nums);
     * int param_1 = obj.showFirstUnique();
     * obj.add(value);
     */
}