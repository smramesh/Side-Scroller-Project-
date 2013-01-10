import java.awt.*;
import java.util.*;

public class TPArrayList {
	ArrayList<String> TPArray = new ArrayList<String>();
	
	public TPArrayList(int x)
	{
		TPArray.add("Rake TP");
		TPArray.add("Pistol TP");
		TPArray.add("unarmed TP");
		TPArray.add("Sword TP");
		System.out.println(TPArray.get(x));
	}

}
