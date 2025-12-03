import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TileManager {
    // taille d'une tuile en pixels
    private int height;   // nombre de pixels sur l'axe Y
    private int width;    // nombre de pixels sur l'axe X

    // tableau 2D qui contient toutes les tuiles découpées
    private Image[][] tiles;

    // image complète du tileset (texture.png)
    private BufferedImage tileSheet;

    TileManager(int height, int width) {
        // on stocke la taille d'une tuile
        this.height = height;
        this.width = width;

        try {
            // on charge l'image et on la découpe en tuiles
            setTiles(this.width, this.height, "./image/texture.jpg");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement de la texture : " + e.getMessage());
        }
    }

    // taille d'une tuile (en pixels) côté vertical
    public double getHeight() {
        return height;
    }

    // taille d'une tuile (en pixels) côté horizontal
    public double getWidth() {
        return width;
    }

    /**
     * Charge le tileset depuis le fichier fileName,
     * et le découpe en petites images de taille (width x height).
     */
    private void setTiles(int width, int height, String fileName) throws IOException {
        // on lit l'image complète (le tileset)
        tileSheet = ImageIO.read(new File(fileName));

        // calcul du nombre de colonnes et de lignes dans le tileset
        int columns = tileSheet.getWidth() / width;   // nombre de tuiles sur l'axe X
        int rows = tileSheet.getHeight() / height;    // nombre de tuiles sur l'axe Y

        tiles = new Image[rows][columns];

        // on parcourt toutes les cases (ligne, colonne)
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {

                // position en pixels de la tuile dans l'image d'origine
                int x = col * width;   // colonne → axe X
                int y = row * height;  // ligne   → axe Y

                // on découpe un bout de width x height à partir de (x, y)
                tiles[row][col] = tileSheet.getSubimage(x, y, width, height);
            }
        }
    }

    /**
     * Retourne la tuile située à la ligne row et à la colonne col
     * dans le tableau de tuiles.
     */
    public Image getTile(int row, int col) {
        return tiles[row][col];
    }
}