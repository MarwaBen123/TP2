import java.awt.Image;
import java.util.ArrayList;

public class Dungeon {

    private char[][] map;


    private int height;
    private int width;

    private TileManager tileManager;

    private ArrayList<Things> thingsList;


    private ArrayList<Things> renderList;


    public Dungeon(int height, int width, TileManager tileManager) {
        this.height = height;
        this.width = width;
        this.tileManager = tileManager;

        this.map = new char[height][width];
        this.thingsList = new ArrayList<>();
        this.renderList = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                    map[i][j] = 'W'; // mur
                } else {
                    map[i][j] = ' '; // vide
                }
            }
        }


        fillThingArray();

        respawnListOfThings();
    }

    public void fillThingArray() {
        thingsList.clear();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                int px = (int) (i * tileManager.getHeight());
                int py = (int) (j * tileManager.getWidth());

                if (map[i][j] == 'W') {
                    thingsList.add(new SolidThings(px, py,
                            (int) tileManager.getHeight(),
                            (int) tileManager.getWidth()));
                }

                else {
                    thingsList.add(new Things(px, py,
                            (int) tileManager.getHeight(),
                            (int) tileManager.getWidth()));
                }
            }
        }
    }


    public void respawnListOfThings() {
        renderList.clear();


        Image wall = tileManager.getTile(0, 0);  // tuile mur
        Image floor = tileManager.getTile(0, 1); // tuile sol

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                int px = (int) (i * tileManager.getHeight());
                int py = (int) (j * tileManager.getWidth());


                if (map[i][j] == 'W') {
                    renderList.add(new SolidThings(px, py, wall));
                }

                else {
                    renderList.add(new Things(px, py, floor));
                }
            }
        }
    }


    public ArrayList<Things> getRenderList() {
        return renderList;
    }

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