package LinkedIn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Trace_route on 11/6/14.
 */
public class TextFile implements Iterable<String> {
    String fileName;
    public TextFile(String fileName){
        this.fileName = fileName;
    }
    public Iterator<String> iterator(){
        return new TextFileIterator();
    }
    class TextFileIterator implements Iterator<String>{
        BufferedReader reader;
        String nextLine;
        public TextFileIterator(){
            try{
                reader = new BufferedReader(new FileReader(fileName));
                nextLine = reader.readLine();
            }catch (IOException e){
                throw new IllegalArgumentException();
            }
        }
        public boolean hasNext(){
            return nextLine!=null;
        }
        public String next(){
            String result = nextLine;
            try{
                if(nextLine == null){
                    reader.close();
                }else{
                    nextLine = reader.readLine();
                }
                return result;
            }catch (IOException e){
                throw  new IllegalArgumentException();
            }
        }
    }
    public static void main(String[] args){
        String s = "/Users/Trace_route/Dropbox/IdeaProjets/LeetCode/src/LinkedIn/WaterH2O.java";
        for(String str:new TextFile(s))
            System.out.println(str);
    }
}
