

import java.awt.*;
import java.util.*;
public class TownsPeople {
int rand,param;


public TownsPeople()
{
	Random generator = new Random();
	rand = generator.nextInt(4)+1;
	TPArrayList person = new TPArrayList();
	person.getTPArray(rand);
}


}