import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MaxwellsDemons {
	Game Gpanel;
	
	//int w;
	int h;
	double coldloc;
	double hotloc;
	int resolution = Toolkit.getDefaultToolkit().getScreenResolution();
	Game gamepanel;
	boolean isright;
	boolean isleft;
	Ball[] Balls;
	int bcount;
	String color;
	JButton addballs;
	JLabel temp1;
	JPanel bPanel1;
	JButton resetgame;
	JLabel temp2;
	public MaxwellsDemons()
	{
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Maxwell's Demon") ;
		f.setSize( new Dimension( 800, 800));
		f.setVisible(true);
		
		isright=false;
		isleft=false;
				
		bPanel1 = new JPanel();
		bPanel1.setBackground(Color.gray);
		bPanel1. setLayout(new GridLayout(1, 2));
		bPanel1.add (resetgame);
		bPanel1.add(addballs);
		bPanel1.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));

			ButtonListener b = new ButtonListener();
			resetgame.addActionListener(b);
			addballs.addActionListener(b);
			resetgame.setActionCommand("reset");
			addballs.setActionCommand("add");
			bPanel1.setVisible(true);
			
			
			f.add (bPanel1, BorderLayout.SOUTH) ;
			JPanel temp = new JPanel();
			temp. setBackground (Color.red) ;
			temp. setLayout (new GridLayout (1, 2)) ;
			JPanel left = new JPanel();
			new JLabel("left");
			temp1 = new JLabel("left");
			temp2 = new JLabel("right");
			left.add (temp1);
			left. setBackground (Color.green);
			JPanel right = new JPanel();
			right.setBackground(Color.black);
			right.add (temp2);
			temp.add (left);
			temp.add (right);
			f.add (temp, BorderLayout. NORTH) ;

			Balls = new Ball[200];
			bcount=4;
			gamepanel = new Game();
			gamepanel.setVisible(true);
			f.add (gamepanel);

			bcount=4;
			Ball b1 = new Ball("red");
			Ball b2 = new Ball("blue");
			Ball b3 = new Ball("red");
			Ball b4 =new Ball("blue");
			
			Balls[0] = b1;
			Balls[1]= b2;
			Balls[2]= b3;
			Balls[3] = b4;

			Timer tick = new Timer (100, new Animator());
			tick. start();
}
public class Ball
{
	double x, y;
	double vx, vy;
	double oldx, oldy;
	
	double squaredSpeed;
	int w =gamepanel.getWidth()-1;
     int h=gamepanel.getHeight()-1;
	
	  Ball(String u)
	  	{
		  
		color=u;
		if (u=="blue")
			{
			
		    
			double min = Math.min(w/2, w);
	        double max = Math.max(w/2, w);
	        //math.random gives random number from 0 to 1
	        x=min + (Math.random() * (max - min));
	        y = min + (Math.random() * (max - min));
			 boolean isright=true;

	
	    double vCM = (Math.random()* 2) + 2;
		double cmperpix = resolution/ 28.347;
		double vPixel = vCM * cmperpix;

		double vPixelSquared = Math.pow (vPixel, 2);
		double vXSquared = Math.random()* vPixelSquared;
		double vYSquared = vPixelSquared- vXSquared;
		squaredSpeed = Math.pow(vCM, 2) ;
		vx= Math.sqrt (vXSquared) ;
		vy= Math.sqrt(vYSquared);
		/*Random random = new Random () ;
		}
		if (random.nextBoolean())
		{
		vx*=- 1;
		}}*/
		}
	else
	{
		if (u=="red")
			
			
		{
			double min = Math.min(0, w/2);
	        double max = Math.max(0, w/2);
	        //math.random gives random number from 0 to 1
	        x= min + (Math.random() * (max - min));
	        y = min + (Math.random() * (max - min));
	        boolean isright= true;
	
	   double vCM = (Math.random()* 2) + 4;
		double cm = resolution/ 28.347;
		double vPixel = vCM * cm;
	
		double vPixelSquared = Math.pow (vPixel, 2);
		double vXSquared = Math.random()* vPixelSquared;
		double vYSquared = vPixelSquared- vXSquared;
		squaredSpeed = Math. pow(vCM, 2) ;
		vx= Math.sqrt (vXSquared) ;
		vy= Math.sqrt(vYSquared);
		/*Random random = new Random () ;
		}
		if (random.nextBoolean())
		{
		vx*=- 1;
		}}*/    
		}}}
	public void move(double delta) {
	oldx = x;
	oldy = y;
	x += vx * delta;
	y += vy * delta;
	stayOnScreen();
	}
	public void stayOnScreen() {
	// Check tests off each edge of screen
	
	if (x < 0)
	vx *= -1;
	if (x < 550)
	vx *= -1;
	if (y < 0)
	vy *= -1;
	if (y < 550)
	vy *= -1;
	
	if (!gamepanel.isgateclosed)
	{
		if (x== w/2)
			{vx *=-1;}
	}
	else if (gamepanel.isgateclosed)
	{ if(x>w/2)
	{
		if(y < h/3 && y>(h/3)*2)
		{vx*=-1;
		}}
	
	}}
	// Ball draw themselves at current position
	public void draw(Graphics g) {
	if(color =="blue")
		{g.setColor(Color.blue);}
	else
	{g.setColor(Color.blue);}
	g.fillOval((int) (x - 2), (int) (y - 2), 5, 5);
	// g.drawString("("+vx+";"+vy+")", (int) x, (int) (y+12));}
	}
}
public class Game extends JPanel implements MouseListener{
	Boolean isgateclosed;
	
	

	
	public void mousePressed (MouseEvent e)
	
	{
	
	isgateclosed = false;
	repaint();
	
	}
	public void mouseReleased(MouseEvent e)
	
	{
	
	isgateclosed = true;
	repaint();
	}
	public Game()
	{
	addMouseListener(this);
	
	}
	
	
public void gamegraphics(Graphics g)	
{
	int w =gamepanel.getWidth()-1;
    int h=gamepanel.getHeight()-1;
    
	g.drawLine(w/2,0,w/2,(3*h/8));
	g.drawLine (w/2, (5*h/8), w/2, h);
	if (isgateclosed)
		{
		g.setColor(Color.pink);
		g.fillRect(w/2 - w/120, (3*h/8), (w/60), (h/4));
		}
		for (int i = 0; i < bcount; i++)
		{
		Balls[i].draw(g);
		}
		gamepanel.repaint();
		}
	
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}}
	
public class Animator implements ActionListener

{
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < bcount; i++) {
		Balls[i].move(0.1);
		}
		gamepanel.repaint();
		}
/*public void actionPerformed (ActionEvent e)
{
double lsum = 0;
double rsum = 0;
double lCount = 0;
double rCount = 0;

for (int i = 0; i < bcount; i++)
{
Balls[i].isgateclosed = gamepanel.isgateclosed;
Balls[i].move(0.1);

if (Balls[i].u == "red")
{
lsum += Math.pow(Balls[i].vTotal, 2);

lCount++;}

else
{
rsum += Math.pow(Balls[i].vTotal, 2);
rCount++;
}

}
lsum/=lCount;
rsum/= rCount;

temp1.setText(String.valueOf(lsum));
temp2.setText(String.valueOf(rsum));}*/
}
class ButtonListener implements ActionListener

{
	@Override

	public void actionPerformed(ActionEvent e)

	{
	if (e.getActionCommand().equals("add"))
	{
	Ball b1 = new Ball("red");
	Ball b2 = new Ball("blue");
	Ball b3 = new Ball("red");
	Ball b4 =new Ball("blue");
	Balls[bcount] = b1;
	Balls[bcount+1]= b2;
	Balls[bcount+2]=b3;
	Balls[bcount+3] = b4;
	bcount += 4;
	}
	
	else if (e.getActionCommand(). equals ("reset"))
	{
	for (int i = 0; i < Balls.length; i++)
	{
	Balls[i] = null;}
	
	bcount=4;
	Ball b1 = new Ball("red");
	Ball b2 = new Ball("blue");
	Ball b3 = new Ball("red");
	Ball b4 =new Ball("blue");
	
	Balls[0] = b1;
	Balls[1]= b2;
	Balls[2]= b3;
	Balls[3] = b4;
	}
		}
}    

public static void main(String[] args)
{
	if (x < 0)
		vx*= -1;
		if (x > gamePanel.getwidth())
		vx*=-1;
		if (y < 0)
		vy *=-1;
		if (y > gamePanel.getHeight())
		vy*=-1;
		if (!gamePanel.open)
		if (!isblue && x > gamePanel.getwidth()/2) //particle is on wrong side, send it back WITHOUT
		{
		vx *=-1
		
		else if (isblue && x < gamePanel-getWidth()/2) //particle is on wrong side,
		{
		vx *= - 13
	
		else
		{
		{
		if(left 8& × > gamePanel.getwidth()/2) //particle is on wrong side, but could be let throug
		if (y > gamePanel-getHeight ()/3 && y < gamePanel-getHeight()/3 * 2) // its through the
		{
		left = false;
		7
		else //send it back
		7
		else if(ileft && x < gamePanel-getwädth()/2)
		if (y > gamePanel-getHeight ()/3 && y < gamePanel,getHeightO)/3*2) // its through the g
		left = trues

 new MaxwellsDemons();

}

}
	
	
	
	
	
	






