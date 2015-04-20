package LinkedIn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class TextFilePrac implements Iterable<String>{
    String fileName;
    public TextFilePrac(String name){
        fileName = name;
    }
    public Iterator<String> iterator(){
        return new TextFileIteratorPrac();
    }
    class TextFileIteratorPrac implements  Iterator<String>{
        BufferedReader reader;
        String line;
        TextFileIteratorPrac(){
            try {
                reader = new BufferedReader(new FileReader(fileName));
                line = reader.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }

        }
        public boolean hasNext(){
            return line!=null;
        }
        public String next(){
            String res = line;
            try{
                if(res== null){
                    reader.close();
                }else{
                    line = reader.readLine();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return res;
        }
    }
    public static void main(String[] args){
        String s = "/Users/Trace_route/Dropbox/IdeaProjets/LeetCode/src/LinkedIn/WaterH2O.java";
        for(String str:new TextFile(s))
            System.out.println(str);
    }
}
