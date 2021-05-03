package ie.tudublin;


import C19748821.AudioVisualizer;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new AudioVisualizer());
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}