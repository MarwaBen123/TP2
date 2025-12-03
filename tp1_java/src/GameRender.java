import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class GameRender extends JPanel {

    private Dungeon dungeon;
    private Hero hero;


    public GameRender(Dungeon dungeon, Hero hero) {
        this.dungeon = dungeon;
        this.hero = hero;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Things t : dungeon.getRenderList()) {
            if (t.image != null) {

                g.drawImage(t.image, t.x, t.y, null);
            } else {

                g.setColor(Color.GRAY);
                g.fillRect(t.x, t.y, t.width, t.height);
            }
        }

        if (hero != null) {
            HitBox hb = hero.getHitBox();
            g.setColor(Color.RED);
            g.fillRect(
                    (int) hb.getX(),
                    (int) hb.getY(),
                    (int) hb.getWidth(),
                    (int) hb.getHeight()
            );
        }
    }
}