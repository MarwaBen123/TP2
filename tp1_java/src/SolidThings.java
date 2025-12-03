import java.awt.Image;

public class SolidThings extends Things {

    // gère les collisions avec les autres objets
    public HitBox hitBox;

    // Constructeur TP1 : position + taille
    SolidThings(int x, int y, int height, int width) {
        super(x, y, height, width);
        this.hitBox = new HitBox(x, y, height, width);
    }

    // Nouveau constructeur TP2 : position + image
    SolidThings(int x, int y, Image image) {
        super(x, y, image);
        // hitbox basée sur la taille de l'image
        this.hitBox = new HitBox(x, y, this.height, this.width);
    }

    public HitBox getHitBox() {
        return hitBox;
    }
}