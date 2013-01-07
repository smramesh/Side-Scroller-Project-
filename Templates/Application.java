
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class Application extends JFrame implements ActionListener, KeyListener{
    Ellipse2D.Double myEllipse;
    Rectangle2D.Double backgroundRectangle;  
    Timer tm = new Timer(5, this); 
    int x = 10, velX = 0;
    int y = 230, velY = 0; 
    
    
    
    public Application() {

    tm.start(); 
    addKeyListener(this); 
    setFocusable(true); 
    setFocusTraversalKeysEnabled(false); 
    }
    
    public static void main(String[] args ) {
    Application b = new Application();

    b.setSize( 400, 300 );
    b.setVisible(true);
    b.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    
    }
    
    public void actionPerformed( ActionEvent ae ) {
    	if(x<10){
    		velX = 0; 
    		x = 10; 
    	}
    	if(x>370){
    		velX = 0; 
    		x = 370; 
    	}
    x += velX; 
    
    	if(y>230){
    		velY = 0; 
    		y = 230; 
    	}
    	
    	if(y<150){
    		velY = 0; 
    		y = 150; 
    	}
    y -= velY;   
    repaint();
    }

    public void keyPressed(KeyEvent kP){
    	int c = kP.getKeyCode();
    	
    	if(c == KeyEvent.VK_LEFT){
    		velX = -1;
    	}
    	
    	if(c == KeyEvent.VK_RIGHT){
    		velX = 1;
    	}
    	
    	if(c == KeyEvent.VK_UP){
    		velY = 1;        				
    	}
 
    }
    
    public void keyReleased(KeyEvent kR){
    	velX = 0;  
    	velY = -1; 

    	 
    }
    
    public void keyTyped(KeyEvent kT){
    	
    }
    public void paint(Graphics g) {
        
    	
        myEllipse = new Ellipse2D.Double( x, y, 20, 30 );       
        backgroundRectangle = new Rectangle2D.Double( 0, 0, 400, 300 );
    	Graphics2D g2 = (Graphics2D)g;
    	g2.setColor( Color.BLACK );
    	g2.fill( backgroundRectangle );
    	g2.setColor(Color.gray);
    	g2.fill(myEllipse);




}
}

