import java.awt.Image;

public class DynamicThings extends AnimatedThings{

    // Vitesse sur les axes X et Y
    private int speedX;
    private int speedY;

    // Constructeur TP1 : position + taille
    DynamicThings(int x, int y, int height, int width) {
        super(x, y, height, width);
        // Les vitesses sont mises à leur valeur par défaut
        this.speedX = speedX;
        this.speedY = speedY;
    }

    // Nouveau constructeur TP2 : position + image
    DynamicThings(int x, int y, Image image) {
        super(x, y, image);
        // on laisse pour l'instant les vitesses à 0
        this.speedX = 0;
        this.speedY = 0;
    }

    public void moveIfPossible(double x, double y, Dungeon dungeon){
        boolean move = true;
        super.getHitBox().move(x,y);
        for(Things things : dungeon.getThingsList() ){
            if(things instanceof SolidThings){
                if(((SolidThings) things).getHitBox().intersect(this.hitBox)){
                    move = false;
                    break;
                }
            }
        }
        if(move){
            this.x += (int) x;
            this.y += (int) y;
        }
        else{
            this.getHitBox().move(-x,-y);
        }
    }

    public int getX() {
        return this.x;
    }
}