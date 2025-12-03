import java.awt.Image;

public class AnimatedThings extends SolidThings {


    AnimatedThings(int x, int y, int height, int width) {
        super(x, y, height, width);
    }


    AnimatedThings(int x, int y, Image image) {
        super(x, y, image);
    }
}