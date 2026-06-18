class task1_3_0618_QuestionThread extends Thread {
    private task1_3_0618_Chat chat;

    private String[] questions = {
            "Hi", "How are you?", "What are you doing?"
    };

    public task1_3_0618_QuestionThread(task1_3_0618_Chat chat) {
        this.chat = chat;
    }

    @Override
    public void run() {
        for (String q : questions) {
            chat.question(q);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}