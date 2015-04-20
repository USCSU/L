package LinkedIn;

/**
 * Created by Garvin on 10/20/2014.
 */
public class FindChar {
    public static char findNextChar(char[] list, char c) {
        assert list.length > 0;
        int left = 0, right = list.length - 1;
        char result = list[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list[mid] == c) {
                if (mid < list.length - 1) return list[mid+1];
                else return result;
            }
            else if (list[mid] < c) {
                left = mid + 1;
            }
            else {//list[mid] > c
                result = list[mid];
                right = mid - 1;
            }
        }
        return result;
    }
public static char getNext(char[] list, char c){
    int low = 0, high = list.length-1;
    char result = list[0];
    while(low<=high){
        int mid = low+(high-low)/2;
        if(list[mid] == c){
            if(mid < list.length -1) return list[mid+1];
            else return result;

        }else if(list[mid]>c){
            result = list[mid];
            high = mid - 1;
        }else{
            low = mid + 1;
        }
    }
   return result;
}
    //find and findchar are the same
    public static char find(char [] chs , char target){
        int left = 0;
        int right = chs.length - 1;
        while(left<=right){
            int mid = (left+right)/2;
            if (chs[mid] == target){
                if (mid<chs.length - 1){
                    return chs[mid+1];
                }else{
                    return chs[0];
                }
            } else if (target > chs[mid]){
                left = mid+1;
            }else{
                right = mid -1 ;
            }
        }

        if(left == 0||left == chs.length) return chs[0];
        else return chs[left];
    }
    public static char findchar(char[] chars, char c){
        if(chars == null || chars.length == 0) return ' ';
        int low =0, high = chars.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(c == chars[mid]){
                if(mid < chars.length-1){
                    return chars[mid+1];
                }else return chars[0];
            }else if(c<chars[mid])
                high = mid -1;
            else
                low = mid + 1;
        }
        if(low == 0 || low == chars.length) return chars[0];
        else return chars[low];
    }
    public static void main(String[] args) {
        char[] list = {'c', 'f', 'j', 'p', 'v'};
        char[] target = {'a', 'c', 'f', 'k', 'v', 'z'};
        for (char c : target) System.out.println(c + " -> " + getNext(list, c));
        System.out.println("................");
        System.out.println();
        for (char c : target) System.out.println(c + " -> " + findNextChar(list, c));
        System.out.println("................");
        System.out.println();
        char [] c1 = {'c', 'f', 'j', 'p', 'v'};
        char [] c2 = {'c', 'f', 'k'};
        System.out.print(find(c1,'a') + " ");
        System.out.print(find(c1,'c')+ " ");
        System.out.print(find(c1,'k') + " ");
        System.out.print(find(c1,'z') + " ");
        System.out.print(find(c2,'f') + " ");
        System.out.print(find(c2,'c') + " ");
        System.out.print(find(c2,'d') + " ");
        System.out.print(findchar(c1,'a') + " ");
        System.out.print(findchar(c1,'c') + " ");
        System.out.print(findchar(c1,'k') + " ");
        System.out.print(findchar(c1,'z') + " ");
        System.out.print(findchar(c2,'f') + " ");
        System.out.print(findchar(c2,'c') + " ");
        System.out.println(findchar(c2,'d') + " ");
    }
}
