public class HitBox {
    // dimensions hitbox
    private double width;
    private double height;

    // position coin sup gauche du pc
    private double x;
    private double y;

    // constructeur
    public HitBox(double x, double y, double width, double height) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    // get sur la position X
    public double getX() { return x; }

    //  position Y
    public double getY() { return y; }

    // largeur hitbox
    public double getWidth() { return width; }

    // hauteur hitbox
    public double getHeight() { return height; }

    // déplace hitbox a dx/dy
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    // teste si deux hitbox se superposent
    public boolean intersect(HitBox box) {
        boolean Xoverlap = false;
        boolean Yoverlap = false;

        // test du recouvrement sur l'axe X
        // la box testé est à droite
        if (this.x <= box.getX()) {
            // commence dans la largeur
            if (box.getX() > this.x && box.getX() < this.x + this.width) {
                Xoverlap = true;
            }
        }

        // la box testé est à gauche
        if (this.x > box.getX()) {
            if (this.x < box.getX() + box.getWidth()) {
                Xoverlap = true;
            }
        }

        // test du recouvrement sur l'axe Y
        // en-dessous
        if (this.y <= box.getY()) {
            if (box.getY() > this.y && box.getY() < this.y + this.height) {
                Yoverlap = true;
            }
        }

        // elle est au-dessus
        if (this.y > box.getY()) {
            if (this.y < box.getY() + box.getHeight()) {
                Yoverlap = true;
            }
        }

        // 2 hitbox se touchent si elles se recouvrent en X ET en Y
        return Xoverlap && Yoverlap;
    }
}