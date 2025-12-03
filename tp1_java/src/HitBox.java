public class HitBox {

    private double width;
    private double height;


    private double x;
    private double y;

    public HitBox(double x, double y, double width, double height) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }


    public double getY() { return y; }

    public double getWidth() { return width; }

    public double getHeight() { return height; }

    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean intersect(HitBox box) {
        boolean Xoverlap = false;
        boolean Yoverlap = false;

        if (this.x <= box.getX()) {
            // commence dans la largeur
            if (box.getX() > this.x && box.getX() < this.x + this.width) {
                Xoverlap = true;
            }
        }

        if (this.x > box.getX()) {
            if (this.x < box.getX() + box.getWidth()) {
                Xoverlap = true;
            }
        }

        if (this.y <= box.getY()) {
            if (box.getY() > this.y && box.getY() < this.y + this.height) {
                Yoverlap = true;
            }
        }

        if (this.y > box.getY()) {
            if (this.y < box.getY() + box.getHeight()) {
                Yoverlap = true;
            }
        }

        return Xoverlap && Yoverlap;
    }
}