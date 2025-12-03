public class TestAvancerHero {
    public static void main(String[] args) {

        TileManager tileManager = new TileManager(20, 20); // version TP1
        Dungeon dungeon = new Dungeon(10, 10, tileManager);
        dungeon.fillThingArray();

        Hero hero = Hero.getInstance(50, 50, 20, 20);

        System.out.println("\nDéplacement du héros vers la gauche jusqu'au mur :\n");

        for (int i = 0; i < 15; i++) {
            System.out.println("Étape " + i);
            dungeon.displayDungeonInConsole(hero.getHitBox());
            System.out.println();

            hero.moveIfPossible(-10, 0, dungeon); // déplacement vers la gauche
        }
    }
}
