
import java.awt.*;
import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Maxwell{
Particle[] particles;
int pCount;
Game gamePanel;
JButton addParticles;

JButton reset;

JPanel buttonPanel1;

JLabel temp1;

JLabel temp2;
int w;

int h;
 
class ButtonListener implements ActionListener

{
	@Override

	public void actionPerformed(ActionEvent e)

	{
	if (e.getActionCommand().equals("add"))
	{
	Particle p1 = new Particle(true, true, w,h);//takes in temp, then region
	Particle p2 = new Particle(false, true,w,h);
	Particle p3 = new Particle(true,false,w,h);
	Particle p4 =new Particle(false, false, w, h);
	particles[pCount] = p1;
	particles[pCount+1]= p2;
	particles[pCount+2]=p3;
	particles[pCount+3] = p4;
	pCount += 4;
	}
	
	else if (e.getActionCommand(). equals ("reset"))
	{
	for (int i = 0; i < particles.length; i++)
	{
	particles[i] = null;}
	
	pCount=4;
	Particle p1= new Particle(true, true,w, h);//takes in temp, then region
	Particle p2 = new Particle(false, true,w,h);
	Particle p3 = new Particle(true, false,w,h);
	Particle p4= new Particle(false, false,w, h);
	
	particles[0] = p1;
	particles[1]= p2;
	particles[2]= p3;
	particles[3] = p4;
	}
		}
}    

public Maxwell()
{
JFrame f = new JFrame();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setTitle("Maxwell's Demon") ;
f.setSize( new Dimension( 800, 800 ));
f.setVisible(true);
//w = f-getWidth();
//h = f.getHeight();

buttonPanel1 = new JPanel();
buttonPanel1.setBackground(Color.gray);
buttonPanel1. setLayout(new GridLayout(1, 2));
buttonPanel1.add (reset);
buttonPanel1.add(addParticles);

ButtonListener b = new ButtonListener();
reset.addActionListener(b);
addParticles.addActionListener(b);
reset.setActionCommand("reset");
addParticles.setActionCommand("add");
buttonPanel1.setVisible(true);


f.add (buttonPanel1, BorderLayout.SOUTH) ;
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


particles = new Particle[200];
pCount=4;
gamePanel = new Game();
gamePanel.setVisible(true);
f.add (gamePanel);

w = gamePanel.getWidth();
h= gamePanel.getHeight();

Particle p1= new Particle(true, true,
w,h);//takes in temp, then region
Particle p2 = new Particle (false,true,
w,h);
Particle p3= new Particle(true,
false,w,h);
Particle p4 = new Particle(false,false,w,h);

particles[0] = p1;
particles[1] = p2;
particles[2] = p3;
particles[3] = p4;

Timer tick = new Timer (100, new Animator());
tick. start();
}
class Particle {
	double x, y;
	double vx, vy;
	double oldx, oldy;
	public Particle() {
	x = (int) (Math.random() * 400 + 100); // [100, 500)
	y = (int) (Math.random() * 400 + 100);
	vx = (int) (Math.random() * 100 - 50); // [-50, 50)
	vy = (int) (Math.random() * 100 - 50);
	}
	public Particle(int xClick, int yClick) {
	x = xClick;
	y = yClick;
	vx = (int) (Math.random() * 100 - 50); // [-50, 50)
	vy = (int) (Math.random() * 100 - 50);
	}
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
	if (x > 550)
	vx *= -1;
	if (y < 0)
	vy *= -1;
	if (y > 550)
	vy *= -1;
	}
	// Balls draw themselves at current position
	public void draw(Graphics g) {
	g.setColor(Color.black);
	g.fillOval((int) (x - 2), (int) (y - 2), 5, 5);
	// g.drawString("("+vx+";"+vy+")", (int) x, (int) (y+12));
	
	}}
public class Game extends Panel implements MouseListener{ //the draw here is clashing with the rectangle draw, need to make
boolean closed;

		public void mousePressed (MouseEvent e)
		
		{
		
		closed = false;
		repaint();
		
		}
		public void mouseReleased(MouseEvent blasae)
		{
		
		closed = true;
		repaint();
		}
		//public Game()
		{
		addMouseListener(this);
		//addMouseMotionListener(this);
		
		//setSize (800, 800) ;
		//setVisible(true);
		}
 public void paintComponent (Graphics g)
{
super.paintComponents(g);
int w = getWidth();
int h = getHeight();
g.drawLine(w/2,0,w/2,(3*h/8));
g.drawLine (w/2, (5*h/8), w/2, h);
if (closed)
	{
	g.setColor(Color.pink);
	g.fillRect(w/2 - w/120, (3*h/8), (w/60), (h/4));
	}
	for (int i = 0; i < pCount; i++)
	{
	particles[i].draw(g);
	}
	gamePanel.repaint();
	}
 @Override
public void mouseClicked(MouseEvent e){
//TODO Auto-generated method stub}
 }
 @Override
public void mouseEntered (MouseEvent e) {

//TODO Auto-generated method stub}
 }
 @Override
public void mouseExited (MouseEvent e) {
//TODO Auto-generated method stub
	
}public class Animator implements ActionListener

{

public void actionPerformed (ActionEvent e)
{
double lsum = 0;
double rsum = 0;
double lCount = 0;
double rCount = 0;

for (int i = 0; i < pCount; i++)
{
particles[i].closed = gamePanel.closed;
particles[i].move(0.1);

if (particles[i].left == true)
{
lsum += Math.pow(particles[i].vTotal, 2);

lCount++;}

else
{
rsum += Math.pow(particles[i].vTotal, 2);
rCount++;
}

}
lsum/=lCount;
rsum/= rCount;

temp1.setText(String.valueOf(lsum));
temp2.setText(String.valueOf(rsum));


}}}