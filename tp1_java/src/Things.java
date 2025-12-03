import java.awt.Image;

public class Things {
    int x;
    int y;
    int height;
    int width;
    Image image;

    // Constructeur "classique" : position + taille (TP1)
    Things(int x, int y, int height, int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    // Constructeur TP2 : position + image
    // La hauteur et la largeur sont récupérées à partir de l'image
    Things(int x, int y, Image image){
        this.x = x;
        this.y = y;
        this.image = image;
        this.height = image.getHeight(null);
        this.width = image.getWidth(null);
    }
}