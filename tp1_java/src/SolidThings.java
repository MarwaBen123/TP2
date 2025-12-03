import java.awt.Image;

public class SolidThings extends Things {

    public HitBox hitBox;

    SolidThings(int x, int y, int height, int width) {
        super(x, y, height, width);
        this.hitBox = new HitBox(x, y, height, width);
    }

    SolidThings(int x, int y, Image image) {
        super(x, y, image);
        // hitbox basée sur la taille de l'image
        this.hitBox = new HitBox(x, y, this.height, this.width);
    }

    public HitBox getHitBox() {
        return hitBox;
    }
}