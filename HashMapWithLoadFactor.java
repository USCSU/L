package LinkedIn;

import java.util.LinkedList;

/**
 * Created by Trace_route on 11/1/14.
 */
public class HashMapWithLoadFactor<K,V> {
    int size;
    int capacity;
    LinkedList<Cell<K,V>>[] items;
    float loadFactor;
    public HashMapWithLoadFactor(){
        capacity = 1<<4;
        loadFactor = 0.75f;
        items = new LinkedList[capacity];
    }
    public HashMapWithLoadFactor(int capacity, float loadFactor){
        if(capacity<=0)
            throw new IllegalArgumentException("Illegal Capacity"+capacity);
        if(loadFactor<=0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal loadFactor"+loadFactor);
        if(capacity > (1<<30)) {
            this.capacity = (1<<30);
        }
        else if((capacity&1) == 1){
            this.capacity = 1;
            while(this.capacity < capacity)
                this.capacity<<=1;
        }
        else this.capacity = capacity;
        this.loadFactor = loadFactor;
        items = new LinkedList[this.capacity];
    }
    public int hashCode(K key){
        return key.toString().length()%capacity;
    }
    public boolean hasOverLoad(){
        return size/capacity>=loadFactor;
    }
    public void put(K key, V value){
        Cell<K,V> entry = new Cell<K, V>(key,value);
        if(hasOverLoad()) reSize();
        int hash = hashCode(key);
        if(items[hash]==null){
            items[hash] = new LinkedList<Cell<K, V>>();
        }else{
            for(int i =0;i<items[hash].size();i++){
                if(entry.equvilant(items[hash].get(i))){
                    items[hash].remove(i);
                    size--;
                    break;
                }
            }
        }
        items[hash].addFirst(entry);
        size++;

    }
    public void reSize(){
        capacity*=2;
        LinkedList<Cell<K,V>>[] newArray = new LinkedList[capacity];
        for(LinkedList<Cell<K,V>> list:items){
            if(list == null) continue;
            for(Cell<K,V> cell:list){
                int hash = hashCode(cell.getKey());
                if(newArray[hash] == null){
                    newArray[hash] = new LinkedList<Cell<K, V>>();
                }
                newArray[hash].addFirst(cell);
            }
        }
        items = newArray;

    }
    public void remove(K key){
        int hash = hashCode(key);
        if(items[hash] == null) return;
        for(int i =0;i<items[hash].size();i++){
            Cell<K,V> cell = items[hash].get(i);
            if(key.equals(cell.getKey())) {
                items[hash].remove(i);
                size--;
                break;
            }
        }
    }
    public V get(K key){
        int hash = hashCode(key);
        if(items[hash] == null) return null;
        for(int i =0;i<items[hash].size();i++){
            Cell<K,V> cell = items[hash].get(i);
            if(key.equals(cell.getKey())){
                return cell.getValue();
            }
        }
        return null;
    }

}
class Cell<K,V>{
    private K key;
    private V value;
    public Cell(K key,V value){
        this.key = key;
        this.value = value;
    }
    public boolean equvilant(Cell<K,V> cell){
        return key.equals(cell.getKey()) && value.equals(cell.getValue());
    }
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
}
class HashMapTest{
    public static void main(String[] args){
        HashMapWithLoadFactor<String, Integer> map = new HashMapWithLoadFactor<String, Integer>(1,0.75f);
        map.put("suker",1);
        map.put("xiaofu",2);
        map.put("jingming",3);
        map.put("yrui",4);
        map.put("facebook",5);
        map.put("facebook",5);
        System.out.println(map.get("yrui"));
        System.out.println(map.get("suker"));
        System.out.println(map.get("jingming"));
        System.out.println(map.get("yrui"));
        System.out.println(map.get("facebook"));
        System.out.println(map.capacity);
        System.out.println(map.size);
        map.remove("facebook");
        System.out.println(map.capacity);
        System.out.println(map.size);
        System.out.println(map.get("facebook"));
    }

}
