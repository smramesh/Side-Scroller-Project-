import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TPArrayList {
	ArrayList<ImageIcon> TPArray;
	
	public TPArrayList()
	{
		TPArray = new ArrayList<ImageIcon>();
		TPArray.add(new ImageIcon("src/Shovel.png"));
		TPArray.add(new ImageIcon("src/Pistol.png"));
		TPArray.add(new ImageIcon("src/Unarmed.png"));
		TPArray.add(new ImageIcon("src/Swordsman.png"));
	}

	public ImageIcon getTPArray(int x) {
		return TPArray.get(x);
	}

	public void setTPArray(ArrayList<ImageIcon> tPArray) {
		TPArray = tPArray;
	}

}
