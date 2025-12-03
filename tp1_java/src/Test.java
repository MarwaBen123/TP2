public class Test {
    public static void main(String[] args) {

        TileManager tileManager = new TileManager(20, 20);

        Dungeon dungeon = new Dungeon(10, 10, tileManager);

        dungeon.fillThingArray();

        HitBox h0 = new HitBox(50, 50, 20, 20);
        HitBox h1 = new HitBox(60, 60, 20, 20);
        HitBox h2 = new HitBox(10, 10, 20, 20);

        System.out.println(h0);
        System.out.println(h1);
        System.out.println(h2);


        System.out.println("\nTest intersection h0 / h1 : ");
        if (h0.intersect(h1)) {
            System.out.println("Collision détectée !");
        } else {
            System.out.println("Aucune collision.");
        }

        System.out.println("\nTest intersection h0 / h2 : ");
        if (h0.intersect(h2)) {
            System.out.println("Collision détectée !");
        } else {
            System.out.println("Aucune collision.");
        }


        System.out.println("\nAffichage du donjon avec h0 comme héros :\n");
        dungeon.displayDungeonInConsole(h0);

        System.out.println("\nAffichage du donjon avec h1 comme héros :\n");
        dungeon.displayDungeonInConsole(h1);

        System.out.println("\nAffichage du donjon avec h2 comme héros :\n");
        dungeon.displayDungeonInConsole(h2);
    }
}