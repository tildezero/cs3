import mayflower.*;


public class MyWorld extends World {

	private Cat cat;
	private Dog dog;
	private Jack jack;
	private Ninja ninja;
	
    public MyWorld() 
    {
    	setBackground("img/BG/BG.png");
    	
    	cat = new Cat();
    	addObject(cat, 100, 100);
    	
    	dog = new Dog();
    	addObject(dog, 200, 150);
    	
    	
    	
    	jack = new Jack();
    	addObject(jack, 300, 300);
    	
    	ninja = new Ninja();
    	addObject(ninja, 250, 250);
    	
    	
    }
    
    public void act()
    {
    }
    
}