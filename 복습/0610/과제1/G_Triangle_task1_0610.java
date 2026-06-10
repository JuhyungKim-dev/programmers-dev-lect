public class G_Triangle_task1_0610 extends G_Shape_task1_0610 {

    G_Point_task1_0610[] p = new G_Point_task1_0610[3];

    public G_Triangle_task1_0610(G_Point_task1_0610[] p) {
        this.p = p;
    }

    @Override
    public void draw() {
        System.out.println(
                "P0 is (" + p[0].getX() + ", " + p[0].getY() +
                        "), P1 is (" + p[1].getX() + ", " + p[1].getY() +
                        "), P2 is (" + p[2].getX() + ", " + p[2].getY() + ")"
        );
    }
}