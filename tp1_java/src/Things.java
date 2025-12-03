import java.awt.Image;

public class Things {
    int x;
    int y;
    int height;
    int width;
    Image image;

    Things(int x, int y, int height, int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    Things(int x, int y, Image image){
        this.x = x;
        this.y = y;
        this.image = image;
        this.height = image.getHeight(null);
        this.width = image.getWidth(null);
    }
}