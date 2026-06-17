
public class task2_0_0617_Main {

    public static void main(String[] args) {

        task2_0_0617_Race race = new task2_0_0617_Race();
        task2_0_0617_Snail s1 = new task2_0_0617_Snail("달팽이1", race);
        task2_0_0617_Snail s2 = new task2_0_0617_Snail("달팽이2", race);
        task2_0_0617_Snail s3 = new task2_0_0617_Snail("달팽이3", race);
        s1.start();
        s2.start();
        s3.start();
    }
}