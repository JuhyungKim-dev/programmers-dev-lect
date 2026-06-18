
public class task1_3_0618_Main {
    public static void main(String[] args) {

        task1_3_0618_Chat chat = new task1_3_0618_Chat();
        task1_3_0618_QuestionThread qt = new task1_3_0618_QuestionThread(chat);
        task1_3_0618_AnswerThread at = new task1_3_0618_AnswerThread(chat);
        qt.start();
        at.start();
    }
}