
import java.util.*; 
import java.awt.*; 
import javax.swing.*; 

public class MainCharacter{

	private int energyBar; 
	private ImageIcon ghostImage; 
	private ArrayList<Clue> collectedClues; 


	public MainCharacter(){
		healthBar = 100; 
		ghostImage = new ImageIcon("ghostImage.png"); 
		collectedClues = new ArrayList<Clue>(); 


	}

	public void energyDepleted(){
		energyBar = energyBar-1; 
	}

	public ImageIcon getGhostImage(){
		return ghostImage; 
	}

	public ArrayList<Clue> getCollectedClues(){
		return collectedClues; 
	}






}