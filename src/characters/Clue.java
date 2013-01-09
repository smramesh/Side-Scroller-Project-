import java.util.*; 


public class Clue{
	 int clue; 
	 ImageIcon clueImage; 

	public Clue(clue){		
		if(clue==0){
			clueImage = new ImageIcon("clue1.png");
		}
		if(clue==1){
			clueImage = new ImageIcon("clue2.png"); 
		}
		else{

			clueImage = new ImageIcon("clues.png"); 
					}

	}





}