package LinkedIn;

import java.util.Random;

/**
 * Created by Garvin on 10/21/2014.
 */
public class shuffleCard {
    public static void shufflecard(int[] cards)
    {
//        Random rd = new Random();
//        for(int i=0;i<52;i++)
//        {
//            int j = rd.nextInt(52);//生成随机数
//            Card temp = card[i];//交换
//            card[i]=card[j];
//            card[j]=temp;
//        }
        Random rd = new Random();
        for(int i =0;i<54;i++){
            int random = rd.nextInt(54);
            int temp = cards[i];
            cards[i] = cards[random];
            cards[random] = temp;
        }
    }
    public static void shuffle(int[] cards){
        Random rd = new Random();
        for(int i =0;i<54;i++){
            int random = rd.nextInt(54);
            int temp = cards[random];
            cards[random] = cards[i];
            cards[i] = temp;
        }
    }
    public static void main(String[] args){
        int[] cards={1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,12,12,12,12,13,13,13,13,14,15};
        int j = 0;
        while(j++<10) {
            System.out.println();
            shufflecard(cards);
            for (int i : cards)
                System.out.print(i + " ");
        }
    }
}
