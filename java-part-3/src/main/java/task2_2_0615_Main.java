public class task2_2_0615_Main {
    public static void main(String[] args) {

        task2_2_0615_MyTree tree = new task2_2_0615_MyTree();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) {
            tree.insert(v);
        }
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
    }
}
