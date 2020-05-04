import java.util.*;
class LinkedListNode{
    int key;
    String value;
    LinkedListNode prev;
    LinkedListNode next;
    public LinkedListNode(int key, String value){
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
    public String toString(){
        return value;
    }
}
class cache{
    int size;
    Map<Integer, LinkedListNode> map;
    LinkedListNode head;
    LinkedListNode tail;
    public cache(int size){
        this.size = size;
        map = new HashMap<Integer, LinkedListNode>();
        head = null;
        tail = null;
    }
    public boolean isFull(){
        return size == map.size();
    }
    public void add(int key, String value){
        if(isFull()){
            evict();
        }
        LinkedListNode item = new LinkedListNode(key, value);
        map.put(key,item);
        addToHead(item);
    }
    public String get(int key){
        LinkedListNode item = map.get(key);
        System.out.println(item);
        moveToHead(item);
        return item.value;
    }
    public void evict(){
        LinkedListNode node = removeFromTail();
        map.remove(node.key);
    }
    public void addToHead(LinkedListNode node){
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
    public void moveToHead(LinkedListNode node){
        LinkedListNode prev = node.prev;
        LinkedListNode next = node.next;
        if(prev != null) prev.next = next;
        if(next != null) next.prev = prev;
        if(node == head) head=next;
        if(node == tail) tail=prev;
        addToHead(node);
    }
    public LinkedListNode removeFromTail(){
        LinkedListNode node = tail;
        tail = tail.prev;
        tail.next = null;
        return node;
    }
    public String toString(){
        return map.toString();
    }
}
public class LRU{
    public static void main(String[] args) {
        cache lru = new cache(3);
        lru.add(1,"Prash");
        lru.add(2,"Aditya");
        lru.add(3,"Ananth");
        String s = lru.get(1);
        System.out.println(s); 
        System.out.println(lru);
        lru.add(4,"Sarada");
        System.out.println(lru);
    }
}