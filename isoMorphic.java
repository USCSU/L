package LinkedIn;

//Given two words as Strings, determine if they are isomorphic. Two words are called isomorphic
//        * if the letters in one word can be remapped to get the second word. Remapping a letter means replacing all
//        * occurrences of it with another letter while the ordering of the letters remains unchanged. No two letters
//        * may map to the same letter, but a letter may map to itself.
//        *
//        * Example:
//        *   given "foo", "app"; returns true
//        *     we can map 'f' -> 'a' and 'o' -> 'p'
//        *
//        *   given "foo", "boa"; returns false
//        *     we can map 'f' -> 'b', 'o' -> 'o', we can't map 'o' -> 'a'
//        *
//        *   given "bar", "foo"; returns false.
//        *     we can't map both 'a' and 'r' to 'o'
//        *
//        *   given "turtle", "tletur"; returns true
//        *     we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' ->'r'
//        *
//        *   given "ab", "ca"; returns true.
//        *     we can map 'a' -> 'c', 'b' -> 'a'.

import java.util.HashMap;

public class isoMorphic {
    public static  boolean isomophic(String s1, String s2){
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;

        HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) return false;
            } else {
                if (map2.containsKey(c2))
                    return false;
                map1.put(c1, c2);
                map2.put(c2, c1);
            }
        }

        return true;
    }
    public static void main(String[] args){
        System.out.println(isomophic("foo","app"));
        System.out.println(isomophic("foo","boa"));
        System.out.println(isomophic("bar","foo"));
        System.out.println(isomophic("turtle","tletur"));
        System.out.println(isomophic("ab","ca"));
    }


}
