public class task2_1_0611_Main {

    Scanner sc = new Scanner(System.in);
    System.out.println("[1]Lite:10 [2]Basic:20 [3]Premium:30");
    int plan = Integer.parseInt(sc.nextLine());
    MemberManager manager = new MemberManager(plan * 10);

    // 회원추가 부분 (case 1)
    if (manager.isFull()) {
        System.out.println("회원이 꽉 찼습니다.");
    } else {
        System.out.println("등급 [1]일반 [2]VIP");
        int grade = Integer.parseInt(sc.nextLine());
        System.out.print("이름 > ");   String name  = sc.nextLine();
        System.out.print("이메일 > "); String email = sc.nextLine();
        System.out.print("연락처 > "); String phone = sc.nextLine();

        if (manager.existsEmail(email)) {
            System.out.println("이미 존재하는 회원입니다.");
        } else {
            Member m = (grade == 2) ? new VipMember(name, email, phone)
                    : new NormalMember(name, email, phone);
            manager.add(m);   // 어떤 등급이든 Member로 추가 (다형성)
        }
    }
}
