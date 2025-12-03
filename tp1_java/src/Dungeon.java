import java.awt.Image;
import java.util.ArrayList;

public class Dungeon {

    // Carte logique du donjon (W = mur, ' ' = vide)
    private char[][] map;

    // Dimensions en cases
    private int height;
    private int width;

    // Taille des tuiles + accès aux images
    private TileManager tileManager;

    // Liste pour les collisions (TP1)
    private ArrayList<Things> thingsList;

    // ===============================
    //   Nouvelle liste 3.2.4 (TP2)
    //   Liste d'objets à afficher
    // ===============================
    private ArrayList<Things> renderList;

    // Constructeur
    public Dungeon(int height, int width, TileManager tileManager) {
        this.height = height;
        this.width = width;
        this.tileManager = tileManager;

        this.map = new char[height][width];
        this.thingsList = new ArrayList<>();
        this.renderList = new ArrayList<>();

        // Création de la map (murs aux bords)
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                    map[i][j] = 'W'; // mur
                } else {
                    map[i][j] = ' '; // vide
                }
            }
        }

        // Pour les collisions (hérité du TP1)
        fillThingArray();

        // 🔥 NOUVEAU (3.2.4)
        respawnListOfThings();
    }

    // ====================================================
    //   Liste collision (TP1)
    // ====================================================
    public void fillThingArray() {
        thingsList.clear();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                int px = (int) (i * tileManager.getHeight());
                int py = (int) (j * tileManager.getWidth());

                // Mur → SolidThings
                if (map[i][j] == 'W') {
                    thingsList.add(new SolidThings(px, py,
                            (int) tileManager.getHeight(),
                            (int) tileManager.getWidth()));
                }
                // Sol → Things
                else {
                    thingsList.add(new Things(px, py,
                            (int) tileManager.getHeight(),
                            (int) tileManager.getWidth()));
                }
            }
        }
    }

    // ====================================================
    //   Liste graphique (TP2 – 3.2.4)
    // ====================================================
    public void respawnListOfThings() {
        renderList.clear();

        // Choix des images (à adapter selon texture.png)
        Image wall = tileManager.getTile(0, 0);  // tuile mur
        Image floor = tileManager.getTile(0, 1); // tuile sol

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                int px = (int) (i * tileManager.getHeight());
                int py = (int) (j * tileManager.getWidth());

                // Mur avec image
                if (map[i][j] == 'W') {
                    renderList.add(new SolidThings(px, py, wall));
                }
                // Sol avec image
                else {
                    renderList.add(new Things(px, py, floor));
                }
            }
        }
    }

    // Getter demandé par 3.2.4
    public ArrayList<Things> getRenderList() {
        return renderList;
    }

    // ====================================================
    //   Affichage console (TP1)
    // ====================================================
    public void displayDungeonInConsole(HitBox hero) {

        int heroRow = (int) (hero.getX() / tileManager.getHeight());
        int heroCol = (int) (hero.getY() / tileManager.getWidth());

        System.out.println("row : " + heroRow + " col : " + heroCol);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (j == heroRow && i == heroCol)
                    System.out.print("H");
                else
                    System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public ArrayList<Things> getThingsList() {
        return thingsList;
    }
}