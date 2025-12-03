public class TestHero {
    public static void main(String[] args) {

        Hero h1 = Hero.getInstance(50, 50, 20, 20);

        Hero h2 = Hero.getInstance(100, 100, 30, 30);

        System.out.println("h1 = " + h1);
        System.out.println("h2 = " + h2);

        System.out.println("Même instance ? " + (h1 == h2));

    }
}