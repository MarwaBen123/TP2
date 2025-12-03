public class TestAvancerHero {
    public static void main(String[] args) {

        // --- Création du donjon (même que TP1) ---
        TileManager tileManager = new TileManager(20, 20); // version TP1
        Dungeon dungeon = new Dungeon(10, 10, tileManager);
        dungeon.fillThingArray();

        // --- Récupération du héros (singleton) ---
        Hero hero = Hero.getInstance(50, 50, 20, 20);

        // --- Q2 : faire avancer le héros jusqu'au mur ---
        System.out.println("\nDéplacement du héros vers la gauche jusqu'au mur :\n");

        for (int i = 0; i < 15; i++) {
            System.out.println("Étape " + i);
            dungeon.displayDungeonInConsole(hero.getHitBox());
            System.out.println();

            hero.moveIfPossible(-10, 0, dungeon); // déplacement vers la gauche
        }
    }
}
