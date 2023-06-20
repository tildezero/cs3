//A+ Computer Science  -  www.apluscompsci.com
//Name - Suhas Voolla
//Date - 2/14/2023
//Class - Pd 4
//Lab  - Lab50

import javax.swing.JFrame;

public class GraphicsRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public GraphicsRunner()
	{
		super("Graphics Runner");
		setSize(WIDTH,HEIGHT);
						
		getContentPane().add(new RecursiveCircles());
				
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		GraphicsRunner run = new GraphicsRunner();
	}
}