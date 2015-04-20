package LinkedIn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval{
    int start;
    int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class addInterval {
    public static ArrayList<Interval> addInterval(ArrayList<Interval> list, Interval item){
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(list == null || list.isEmpty() || item == null) return res;
        list.add(item);
        Comparator<Interval> cmp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        Collections.sort(list,cmp);
        Interval pre = list.get(0);
        for(int i =1;i<list.size();i++){
            Interval cur = list.get(i);
            if(pre.end < cur.start){
                res.add(pre);
                pre = cur;
            }else{
                pre.end = cur.end>pre.end?cur.end:pre.end;
            }
        }
        res.add(pre);
        return res;
    }
    public static ArrayList<Interval> addInt(ArrayList<Interval> list, Interval item){
        //error checking
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(list == null ) return res;
        if(item == null ) return list;
        list.add(item);
        //rewrite comparator
        Comparator<Interval> cmp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        };
        Collections.sort(list,cmp);
        //
        Interval pre = list.get(0);
        for(int i =1;i<list.size();i++){
            Interval cur = list.get(i);
            if(pre.end > cur.start){
                pre.end = pre.end>cur.end?pre.end:cur.end;
            }else{
                res.add(pre);
                pre = cur;
            }
        }
        res.add(pre);
        return res;
    }
    public static void main(String[] args){
        Interval i1 = new Interval(1,2);
        Interval i2 = new Interval(3,5);
        Interval i3 = new Interval(6,7);
        Interval i4 = new Interval(8,10);
        Interval i5 = new Interval(12,16);
        ArrayList<Interval> list =new ArrayList<Interval>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
//        list.add(i5);
        Interval i6 = new Interval(4,9);
        ArrayList<Interval> res = addInt(list, i5);
        for(Interval i:res){
            System.out.println("["+i.start +" , " + i.end+"]");
        }
    }
}
