package ShuffleDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDemo {
    //定义牌面花色
    public static final String[] SUIT ={"♠","♥","♦","♣"};

    public static List<Card> buyCard() {
        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i < SUIT.length; i++) {
            for (int j = 0; j < 13; j++) {
                Card card = new Card(j,SUIT[i]);
                cardList.add(card);
            }
        }
        return cardList;
    }
    //洗牌:从最后一个下标处开始,然后找到一个随机的下标处的值,然后进行交换
    public static void shuffle(List<Card> cardList) {
        for (int i = cardList.size()-1; i > 0 ; i--) {
            Random random = new Random();
            int index = random.nextInt(i);
            swap(cardList,i,index);
        }
    }
    //交换方法
    public static void swap(List<Card> listCard ,int i,int j) {
        //Card temp = Card[i];
        Card temp = listCard.get(i);
        //Card[i] = Card[j];
        listCard.set(i,listCard.get(j));
        //Card[j] = temp;
        listCard.set(j,temp);
    }

    public static void main(String[] args) {
        List<Card> cards = buyCard();
        System.out.println(cards);

        System.out.println("洗牌");
        shuffle(cards);
        System.out.println(cards);

        System.out.println("揭牌");

       List<Card> hand0 = new ArrayList<>();
       List<Card> hand1 = new ArrayList<>();
       List<Card> hand2 = new ArrayList<>();

       List<List<Card>> hand = new ArrayList<>();
       hand.add(hand0);
       hand.add(hand1);
       hand.add(hand2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                hand.get(i).add(cards.remove(0));
            }
        }
        System.out.println("第一个人的牌:");
        System.out.println(hand0);
        System.out.println("第二个人的牌:");
        System.out.println(hand1);
        System.out.println("第三个人的牌");
        System.out.println(hand2);
        System.out.println("剩下的牌");
        System.out.println(cards);
      }
}