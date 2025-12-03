import java.awt.Image;

public class AnimatedThings extends SolidThings {

    // Constructeur TP1 : position + taille
    AnimatedThings(int x, int y, int height, int width) {
        super(x, y, height, width);
    }

    // Nouveau constructeur TP2 : position + image
    AnimatedThings(int x, int y, Image image) {
        super(x, y, image);
    }
}