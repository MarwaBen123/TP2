import javax.swing.JFrame;
import java.awt.Dimension;

public class MainInterface extends JFrame {

    private Dungeon dungeon;
    private Hero hero;
    private GameRender gameRender;

    public MainInterface() {
        super("Mon interface graphique");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);


        TileManager tileManager = new TileManager(32, 32);
        dungeon = new Dungeon(10, 10, tileManager);
        hero = Hero.getInstance(50, 50, 32, 32);

        gameRender = new GameRender(dungeon, hero);

        this.add(gameRender);
        this.setSize(new Dimension(400, 400));
        this.setLocationRelativeTo(null); // centre la fenêtre
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainInterface();
    }
}