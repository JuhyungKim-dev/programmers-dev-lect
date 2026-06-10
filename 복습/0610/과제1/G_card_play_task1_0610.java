public class G_card_play_task1_0610 {

    public static void main(String[] args) {

        G_Deck_task1_0610 deck = new G_Deck_task1_0610();

        G_Card2_task1_0610 card = deck.pick(0);
        System.out.println(card);

        deck.shuffle();

        card = deck.pick(0);
        System.out.println(card);
    }
}