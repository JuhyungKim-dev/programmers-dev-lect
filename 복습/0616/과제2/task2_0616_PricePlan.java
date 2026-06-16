public enum task2_0616_PricePlan {

    LITE(10),
    BASIC(20),
    PREMIUM(30);

    private final int capacity;
    task2_0616_PricePlan(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public static task2_0616_PricePlan from(int choice) {
        switch (choice) {
            case 1:
                return LITE;
            case 2:
                return BASIC;
            case 3:
                return PREMIUM;
            default:
                return null;
        }
    }
}