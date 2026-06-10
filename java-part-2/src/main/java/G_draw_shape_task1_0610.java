public class G_draw_shape_task1_0610 {

    public static void main(String[] args) {

        G_Point_task1_0610[] p = new G_Point_task1_0610[3];

        p[0] = new G_Point_task1_0610(100, 100);
        p[1] = new G_Point_task1_0610(140, 50);
        p[2] = new G_Point_task1_0610(200, 100);

        G_Triangle_task1_0610 t = new G_Triangle_task1_0610(p);

        G_Circle_task1_0610 c =
                new G_Circle_task1_0610(
                        new G_Point_task1_0610(150, 150),
                        50
                );

        t.draw();
        c.draw();
    }
}