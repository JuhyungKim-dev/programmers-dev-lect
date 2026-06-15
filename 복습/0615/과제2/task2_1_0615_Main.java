public class task2_1_0615_Main {
    public static void main(String[] args) {

        task2_1_0615_MyHashMap map = new task2_1_0615_MyHashMap();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);
        System.out.println("apple = " + map.get("apple"));
        System.out.println("banana = " + map.get("banana"));
        System.out.println("melon = " + map.get("melon"));

        map.put("apple", 10);
        System.out.println("apple 수정 후 = " + map.get("apple"));
        System.out.println("contains apple : " + map.containsKey("apple"));
        System.out.println("contains grape : " + map.containsKey("grape"));
        System.out.println("size = " + map.size());
        System.out.println("remove apple = " + map.remove("apple"));
        System.out.println("apple 삭제 후 = " + map.get("apple"));
        System.out.println("size = " + map.size());
    }
}
