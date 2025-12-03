import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TileManager {

    private int height;
    private int width;


    private Image[][] tiles;

    private BufferedImage tileSheet;

    TileManager(int height, int width) {
        // on stocke la taille d'une tuile
        this.height = height;
        this.width = width;

        try {
            setTiles(this.width, this.height, "./image/texture.jpg");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement de la texture : " + e.getMessage());
        }
    }


    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }


    private void setTiles(int width, int height, String fileName) throws IOException {

        tileSheet = ImageIO.read(new File(fileName));

        int columns = tileSheet.getWidth() / width;   // nombre de tuiles sur l'axe X
        int rows = tileSheet.getHeight() / height;    // nombre de tuiles sur l'axe Y

        tiles = new Image[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {

                int x = col * width;   // colonne → axe X
                int y = row * height;  // ligne   → axe Y

                tiles[row][col] = tileSheet.getSubimage(x, y, width, height);
            }
        }
    }

    public Image getTile(int row, int col) {
        return tiles[row][col];
    }
}