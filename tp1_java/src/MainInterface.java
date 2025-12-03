import javax.swing.JFrame;
import java.awt.Dimension;

public class MainInterface extends JFrame {

    private Dungeon dungeon;
    private Hero hero;
    private GameRender gameRender;

    public MainInterface() {
        super("Mon interface graphique");

        // ferme le programme quand on clique sur la croix
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // ========================
        //  Création du monde
        // ========================
        TileManager tileManager = new TileManager(32, 32);
        dungeon = new Dungeon(10, 10, tileManager);
        hero = Hero.getInstance(50, 50, 32, 32);

        // Panneau qui dessine le donjon + le héros
        gameRender = new GameRender(dungeon, hero);

        // on ajoute le panneau dans la fenêtre
        this.add(gameRender);

        // taille de la fenêtre (un peu plus grande que la map)
        this.setSize(new Dimension(400, 400));
        this.setLocationRelativeTo(null); // centre la fenêtre
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // lance l'interface graphique
        new MainInterface();
    }
}