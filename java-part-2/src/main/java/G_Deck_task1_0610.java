public class G_Deck_task1_0610 {

    final int CARD_NUM = 52;
    G_Card2_task1_0610[] cards = new G_Card2_task1_0610[CARD_NUM];

    public G_Deck_task1_0610() {

        int i = 0;

        for (int k = G_Card2_task1_0610.KIND_MAX; k > 0; k--) {
            for (int n = 0; n < G_Card2_task1_0610.NUM_MAX; n++) {
                cards[i++] = new G_Card2_task1_0610(k, n + 1);
            }
        }
    }

    public G_Card2_task1_0610 pick(int index) {
        return cards[index];
    }

    public G_Card2_task1_0610 pick() {
        int index = (int)(Math.random() * CARD_NUM);
        return pick(index);
    }

    public void shuffle() {

        for (int i = 0; i < cards.length; i++) {

            int index = (int)(Math.random() * CARD_NUM);

            G_Card2_task1_0610 temp = cards[i];
            cards[i] = cards[index];
            cards[index] = temp;
        }
    }
}