class task2_2_0617_Adventurer extends Thread {
    private final String name;
    private final task2_2_0617_Dungeon dungeon;

    public task2_2_0617_Adventurer(String name, task2_2_0617_Dungeon dungeon) {
        this.name = name;
        this.dungeon = dungeon;
    }

    @Override
    public void run() {
        try {
            dungeon.enter(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}