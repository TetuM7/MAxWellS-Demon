import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
if (e.getActionCommand().equals("'add"))
{
Particle p1 = new Particle(true, true, w,
h);//takes in temp, then region
Particle p2 = new Particle(false, true,w,h);
Particle p3 = new Particle(true,
false,w,h);
Particle p4 =new Particle(false, false, w, h);
particles[pCount] = p1;
particles[pCount+1]
= p2;
particles[pCount+2]
=p3;
particles[pCount+3] = p4;


pCount += 4;
}
else if (e.getActionCommand(). equals ("reset"))
	{
	for (int i = 0; i < particles.length; i++)
	{
	particles[i] = null;}
	
	pCount=4;
	Particle p1= new Particle(true, true,
	w, h);//takes in temp, then region
	Particle p2 = new Particle(false, true,
	w,h);
	Particle p3 = new Particle(true, false,w,h);
	Particle p4= new Particle(false, false,
	w, h);
	
	particles[0] = p1;
	particles[1]
	= p2;
	particles[2]
	= p3;
	particles[3] = p4;}
	}}
//end void actionPerformed

// end class ButtonListener
public Maxwel()
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
h=gamePanel.getHeight();

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
public class Game extends Panel implements MouseListener{ //the draw here is clashing with the rectangle draw, need to make
boolean closed;

		public void mousePressed (MouseEvent e)
		
		{
		
		closed = false;
		repaint();
		
		}
		public void mouseReleased(MouseEvente)
		{
		
		closed = true;
		repaint();
		}
		public Game()
		{
		addMouseListener(this);
		//addMouseMotionListener(this);
		
		//setSize (800, 800) ;
		//setVisible(true);
		}
 public void paintComponent (Graphics g)
{
super.paintComponent(g);
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
	gamePanel,repaint();
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
	
}}}


public class Animator implements ActionListener

{

public void actionPerformed (ActionEvent e)
{
double 1sum = 0;
double sum = 0;
double 1Count = 0;
double Count = 0;}

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

}}}