package LinkedIn;

import java.util.HashMap;

class doubleLinkedNode{
    int key;
    int value;
    doubleLinkedNode pre;
    doubleLinkedNode next;
    public doubleLinkedNode(int key, int value){
        this.key = key;
        this.value = value;
        pre = null;
        next = null;
    }
}
public class LRUTest {
    HashMap<Integer,doubleLinkedNode> map;
    doubleLinkedNode head;
    doubleLinkedNode end;
    int size;
    int capacity;
    public LRUTest(int capacity){
        size = 0;
        this.capacity = capacity;
        map = new HashMap<Integer, doubleLinkedNode>();
        head = null;
        end = null;
    }
    public void set(int key, int value){
        if(map.containsKey(key)){
            doubleLinkedNode cur = map.get(key);
            cur.value = value;
            remove(cur);
            setHead(cur);
            map.put(key,cur);
        }else{
            doubleLinkedNode cur = new doubleLinkedNode(key,value);
            if(size>=capacity){
                remove(end);
                end = end.pre;
                if(end!=null) end.next = null;
                setHead(cur);
            }else{
                setHead(cur);
                size++;
                map.put(key,cur);
            }
        }
    }
    public int get(int key){
        if(!map.containsKey(key)) return -1;
        doubleLinkedNode cur = map.get(key);
        remove(cur);
        setHead(cur);
        map.put(key,cur);
        return cur.value;
    }
    public void remove(doubleLinkedNode node){
        doubleLinkedNode next = node.next;
        doubleLinkedNode pre = node.pre;
        if(next!=null)
            next.pre = pre;
        else end= pre;

        if(pre!=null)
            pre.next = next;
        else
            head = next;
    }
    public void setHead(doubleLinkedNode node){
        node.next = head;
        if(head!=null)
            head.pre = node;
        head = node;
        if(end==null)
            end = node;
    }


}
