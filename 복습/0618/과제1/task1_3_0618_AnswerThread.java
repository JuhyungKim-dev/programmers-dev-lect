class task1_3_0618_AnswerThread extends Thread {
    private task1_3_0618_Chat chat;

    private String[] answers = {
            "Hello", "I'm fine, thank you!", "I'm coding in Java"
    };

    public task1_3_0618_AnswerThread(task1_3_0618_Chat chat) {
        this.chat = chat;
    }

    @Override
    public void run() {
        for (String a : answers) {
            chat.answer(a);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}