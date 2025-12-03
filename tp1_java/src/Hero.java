public final class Hero extends DynamicThings{

    private static volatile Hero instance = null;


    private Hero(int x, int y, int height, int width) {
        super(x, y, height, width);
    }

    public static Hero getInstance(int x, int y, int height, int width){
        if (Hero.instance == null){
            synchronized (Hero.class){
                if(Hero.instance == null){
                    Hero.instance = new Hero(x, y, height, width);
                }
            }
        }
        return Hero.instance;
    }
            @Override
            public String toString() {
            return "Hero[x=" + this.x + ", y=" + this.y + "]";

        }
}
