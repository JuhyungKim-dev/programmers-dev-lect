public class task2_0611_NormalMember extends task2_0611_Member {

    public task2_0611_NormalMember(String name, String email, String phone) {
        super(name, email, phone);
    }

    @Override
    public String getGrade() {
        return "일반";
    }

    @Override
    public String getBenefit() {
        return "기본 서비스";
    }
}