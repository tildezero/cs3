import mayflower.*;

public class MyWorld extends World {
    // private Cat cat;
    // private Dog dog;
    // private Jack jack;
    // private Ninja ninja;

    private String[][] tiles;

    public MyWorld() 
    {
        setBackground("img/BG/BG.png");

        // cat = new Cat();
        // addObject(cat, 100, 100);

        // dog = new Dog();
        // addObject(dog, 200, 150);

        // jack = new Jack();
        // addObject(jack, 300, 300);

        // ninja = new Ninja();
        // addObject(ninja, 250, 250);

        tiles = new String[6][8];
        buildWorld();
        addDog();
        addRandomObjects();
        //addDog();
        addMainCharacter();
        addNinja();

    }

    public void act()
    {
    }

    private void buildWorld() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = "";
            }
        }

        for (int i = 0; i < tiles[5].length; i++) {
            tiles[5][i] = "ground";
        }

        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {
                if (tiles[r][c].equals("ground")) {
                    addObject(new Block(), c * 100, r * 100);
                }
            }
        }
    }

    public void addRandomObjects() {
        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {
                int rn = (int) (Math.random() * tiles[0].length);
                if (rn <= 3) {
                    addObject(new Yarn(), c * 100, r * 100);
                    tiles[r][c] = "yarn";
                }
            }
        }  
    }

    public void addMainCharacter() {
        boolean added = false;
        while (!added) {
            Cat cat = new Cat();
            int row = (int) (Math.random() * tiles.length);
            int col = (int) (Math.random() * tiles[0].length);
            if (tiles[row][col].equals("")) {
                addObject(cat, col * 100, row * 100);
                tiles[row][col] = "cat";
                added = true;
            }
        }
    }

    public void addNinja() {
        boolean added = false;
        while (!added) {
            Ninja ninja = new Ninja();
            int row = (int) (Math.random() * tiles.length);
            int col = (int) (Math.random() * tiles[0].length);
            if (tiles[row][col].equals("")) {
                addObject(ninja, col * 100, row * 100);
                tiles[row][col] = "ninja";
                added = true;
            } else {
                added = false;
            }
        }
    }

    public void addDog() {

        Dog dog = new Dog();

        addObject(dog, 2 * 100, 3 * 100);
        tiles[3][2] = "dog";

        
    }

}