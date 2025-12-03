import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class GameRender extends JPanel {

    private Dungeon dungeon;
    private Hero hero;

    // Le constructeur reçoit le donjon et le héros à afficher
    public GameRender(Dungeon dungeon, Hero hero) {
        this.dungeon = dungeon;
        this.hero = hero;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // =====================
        //  Dessin du donjon
        // =====================
        for (Things t : dungeon.getRenderList()) {
            if (t.image != null) {
                // on dessine l'image de la tuile à sa position
                g.drawImage(t.image, t.x, t.y, null);
            } else {
                // au cas où il n'y a pas d'image (debug)
                g.setColor(Color.GRAY);
                g.fillRect(t.x, t.y, t.width, t.height);
            }
        }

        // =====================
        //  Dessin du héros
        // =====================
        if (hero != null) {
            HitBox hb = hero.getHitBox();
            g.setColor(Color.RED); // pour bien voir le héros
            g.fillRect(
                    (int) hb.getX(),
                    (int) hb.getY(),
                    (int) hb.getWidth(),
                    (int) hb.getHeight()
            );
        }
    }
}