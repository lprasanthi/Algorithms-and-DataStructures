// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3309/
public class LRUCache {
    class LinkedListNode{
        int key;
        int value;
        LinkedListNode prev;
        LinkedListNode next;
        public LinkedListNode(int key, int value){
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
        public String toString(){
            return key+", "+value;
        }
    }
    class LRUCache {
        int size;
        Map<Integer, LinkedListNode> map;
        LinkedListNode head;
        LinkedListNode tail;
        public LRUCache(int capacity) {
            this.size = capacity;
            map = new HashMap<Integer, LinkedListNode>();
            head = null;
            tail = null;
        }
        private boolean isFull(){
            return size == map.size();
        }
        private void addToHead(LinkedListNode node){
            if(head == null){
                head = node;
                tail = node;
                return;
            }
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }
        private void moveToHead(LinkedListNode node){
            if(node == head)
                return;
            LinkedListNode prev = node.prev;
            LinkedListNode next = node.next;
            if(prev != null) prev.next = next;
            if(next != null) next.prev = prev;
            if(node == tail) tail=prev;
            addToHead(node);
        }
        private void evict(){
            LinkedListNode node = removeFromTail();
            map.remove(node.key);
        }
        private LinkedListNode removeFromTail(){
            LinkedListNode node = tail;
            tail = tail.prev;
            if(tail != null)
                tail.next = null;
            return node;
        }
        public int get(int key) {
            LinkedListNode item = map.get(key);
            if(item == null)
                return -1;
            moveToHead(item);
            return item.value;
        }
        
        public void put(int key, int value) {
            if(map.containsKey(key)){
                LinkedListNode node = map.get(key);
                node.value = value;
                moveToHead(node);
                return;
            }
            if(isFull()){
                evict();
            }
            LinkedListNode item = new LinkedListNode(key, value);
            
            map.put(key,item);
            addToHead(item);
        }
    }
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}