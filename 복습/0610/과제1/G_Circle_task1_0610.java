public class G_Circle_task1_0610 extends G_Shape_task1_0610 {

    G_Point_task1_0610 center;
    int r;

    public G_Circle_task1_0610() {
        this(new G_Point_task1_0610(0, 0), 100);
    }

    public G_Circle_task1_0610(G_Point_task1_0610 center, int r) {
        this.center = center;
        this.r = r;
        setColor("red");
    }

    @Override
    public void draw() {
        System.out.println(
                "Center is (" + center.getX() + ", " + center.getY() +
                        "), r is " + r +
                        ", color is " + getColor()
        );
    }
}