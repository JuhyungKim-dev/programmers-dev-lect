public class task2_2_0617_Main {
    public static void main(String[] args) {

        task2_2_0617_Dungeon dungeon = new task2_2_0617_Dungeon(2);
        task2_2_0617_Adventurer a1 = new task2_2_0617_Adventurer("전사", dungeon);
        task2_2_0617_Adventurer a2 = new task2_2_0617_Adventurer("마법사", dungeon);
        task2_2_0617_Adventurer a3 = new task2_2_0617_Adventurer("궁수", dungeon);
        task2_2_0617_Adventurer a4 = new task2_2_0617_Adventurer("도적", dungeon);
        task2_2_0617_Adventurer a5 = new task2_2_0617_Adventurer("성기사", dungeon);
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }
}