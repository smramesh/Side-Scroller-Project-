
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner; 
import sun.audio.*; 
import java.io.*; 

public class Application extends JFrame implements ActionListener, KeyListener{
	
	JLabel dialogue; JPanel gamePanel; 
    Ellipse2D.Double myEllipse, townsPeopleEllipse;
    Rectangle2D.Double backgroundRectangle;  
    Timer tm = new Timer(5, this); 
    int x = 10, velX = 0;
    int y = 230, velY = 0; 
    int displayCounter = 0; 
    Image graveyardBackground, transitionaryBackground, townBackground, town1; 
    Image dbImage; 
    Graphics dbg; 

    
    
    public Application() {
    music();  
    tm.start(); 
    addKeyListener(this); 
    setFocusable(true); 
    setFocusTraversalKeysEnabled(false); 
    graveyardBackground = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src/pictures/graveyardbackground.png")).getImage();
    transitionaryBackground = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src/pictures/transitionarybackground.png")).getImage();
    townBackground = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src/pictures/townBackground.png")).getImage();
    town1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src/pictures/town1area.png")).getImage();
    
    
    }
    
    public static void main(String[] args ) {
    Application b = new Application();

    b.setSize( 400, 300 );
   	b.setVisible(true);  
    b.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    
    }
    
    
    //*************************ACTION LISTENER METHOD***********//
    //*********************************************************//
    //This is where the speed and direction of movements is tracked.
    public void actionPerformed( ActionEvent ae ) {
    	if(x<10&&displayCounter!=0){
    		velX = 0; 
    		x = 370; 
    		displayCounter--; 
    		
    		
    	}
    	if(x<10&&displayCounter==0){
    		velX = 0; 
    		x = 10; 
    		displayCounter = 0; 
    		
    		
    	}
    	if(x>370){
    		velX = 0; 
    		x = 10; 
    		displayCounter++; 
    		
    		
    	}
    x += velX; 
    
    	if(y>230){
    		velY = 0; 
    		y = 230; 
    	}
    	
    	if(y<90){
    		velY = 0; 
    		y = 90; 
    	}
    y -= velY;   
    
    repaint();
    }
//************************************************************//
//************************************************************//
    
    
    
    
    
    
    
    //************************************************//
    //****************KEY LISTENER METHODS************//
    //************************************************///
    //This is where the character moves based on keyboard commands.
    public void keyPressed(KeyEvent kP){
    	int c = kP.getKeyCode();
    	
    	if(c == KeyEvent.VK_A){
    		velX = -1;
    	}
    	
    	if(c == KeyEvent.VK_D){
    		velX = 1;
    	}
    	
    	if(c == KeyEvent.VK_SPACE){
    		velY = 2;        				
    	}
 
    }
    
    public void keyReleased(KeyEvent kR){
    	velX = 0;  
    	velY = -1; 
    }
    public void keyTyped(KeyEvent kT){
    	
    }
    
    //***************************************//
    
    //****************MUSIC METHOD**********//
    //**************************************//
    //***************************************//
    //This method is where the music gets implemented. 
    public void music(){
    	AudioPlayer musicPlayer = AudioPlayer.player;
    	AudioStream backgroundMusic;
    	AudioData musicData;
    	ContinuousAudioDataStream loop = null; 
    	
    	try{     	
    		InputStream test = new FileInputStream("src/music/piano.wav"); 
    		backgroundMusic = new AudioStream(test); 
    		AudioPlayer.player.start(backgroundMusic);    		
    	}
    	catch(IOException error){
    		 System.out.println(error);
    	}
    	musicPlayer.start(loop);
    	 
    }
    
    //*****************************************//
    //*****************************************//
    
    
    
       
    //***********PAINT METHOD**************//
    //*************************************//    
    //This method is where the character gets painted. 
        
    
    public void paint(Graphics g){
    	
    	dbImage = createImage(getWidth(), getHeight());
    	dbg = dbImage.getGraphics(); 
    	paintComponent(dbg);
    	g.drawImage(dbImage, 0, 0, this);
    }
    
    
    public void paintComponent(Graphics g) {        
    	townsPeopleEllipse = new Ellipse2D.Double(70, 230, 20, 30);    	
        myEllipse = new Ellipse2D.Double( x, y, 20, 30 );       
        backgroundRectangle = new Rectangle2D.Double( 0, 0, 400, 300 );
    	Graphics2D g2 = (Graphics2D)g;
    	g2.setColor( Color.BLACK );
    	g2.fill( backgroundRectangle );
    	if(displayCounter==0){
    	g2.drawImage(graveyardBackground, 0, 0, null); 
    	}
    	else if(displayCounter==2){
    		g2.drawImage(townBackground, 0, 0, null); 
    	}
    	else if(displayCounter==3){
    		g2.drawImage(town1, 0, 0, null); 
    	}
    	else{
    	g2.drawImage(transitionaryBackground, 0, 0, null); 
    	}
    	g2.setColor(Color.gray);
    	g2.fill(myEllipse);
    	
    	if(displayCounter==2){
    		g2.setColor(Color.RED); 
    		g2.fill(townsPeopleEllipse); 
    	}
    	
    	repaint(); 
    }
    
    //************************************//
    //***********************************//
}

