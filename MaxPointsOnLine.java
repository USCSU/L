package LinkedIn;

import java.util.HashMap;

class Point{
    int x;
    int y;
    Point(){
       x =0;
       y =0;
    }
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class MaxPointsOnLine {
    public static int maxPointNumber(Point[] points){
        if(points ==null) return 0;
        if(points.length < 2) return points.length;
        int max =0 ;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        for(int i =0;i<points.length-1;i++){
            int equal = 1;
            for(int j =i+1;j<points.length;j++){
                if(equal(points[i],points[j])){
                    equal++;
                    continue;
                }
                double slope = getSlope(points[i],points[j]);
                if(map.containsKey(slope)){
                    map.put(slope,map.get(slope)+1);
                }else{
                    map.put(slope,1);
                }
                int tmp =0;
                for(Integer val:map.values())
                    tmp = Math.max(tmp,val);
                max = Math.max(max,tmp+equal);
                map.clear();
            }
        }
        return max;
    }
    public static double getSlope(Point p1, Point p2){
        int x = p2.x - p1.x;
        int y = p2.y - p1.y;
        if(x ==0) return Double.POSITIVE_INFINITY;
        return y==0?0:((double)y/(double)x);
    }
    public static boolean equal(Point p1, Point p2){
        return p1.x == p2.x && p2.y == p1.y;
    }
    public static void main(String[] args){
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        Point[] points = {p1,p2};
        System.out.println(maxPointNumber(points));
    }
}
