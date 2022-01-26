import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class Bounce {

	String tempp1;
	String tempp2;
			
	// Bounce owns the MODEL -- state of the balls
	Ball[] balls;
	int ballCount;
	double coldloc;
	double hotloc;
	int resolution = Toolkit.getDefaultToolkit().getScreenResolution();
	Game gamepanel;
	boolean isright;
	boolean isleft;
	int bcount;
	String color;
	JButton addballs;
	JLabel temp1;
	JPanel bPanel1;
	JButton resetgame;
	JLabel temp2;
	// Bounce also owns the VIEW objects -- displaying the balls
	JFrame f;
	Game gamePanel;
	boolean isblue;
	boolean isgate;
		JButton addb;
		JButton reset;
		class ButtonListener implements ActionListener

		{
			@Override
			public void actionPerformed(ActionEvent e)

			{
			if (e.getActionCommand().equals("add"))
			{			
				if (bcount < 100) {
					balls[ballCount++] = new Ball(true);
					balls[ballCount++] = new Ball(false);
					}}
			
			else if (e.getActionCommand(). equals ("reset"))
			{
			for (int i = 0; i < balls.length; i++)
			{
			balls[i] = null;}
			
			bcount=4;
			Ball b1 = new Ball(true);
			Ball b2 = new Ball(true);
			Ball b3 = new Ball(false);
			Ball b4 =new Ball(false);
			
			balls[0] = b1;
			balls[1]= b2;
			balls[2]= b3;
			balls[3] = b4;
			}
				}
		}    
	public static void main(String[] args) {
		new Bounce();
	}

	public Bounce() {
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Bounce");
		f.setBackground(Color.white);
		
		// Initialize the model
		ballCount = 4;
		balls = new Ball[100];
		/*for (int i = 0; i < ballCount; i++) {
			balls[i] = new Ball(true);
		}*/
		Ball b1 = new Ball(true);
		Ball b2 = new Ball(true);
		Ball b3 = new Ball(false);
		Ball b4 =new Ball(false);
		
		balls[0] = b1;
		balls[1]= b2;
		balls[2]= b3;
		balls[3] = b4;
		
		bPanel1 = new JPanel();
		reset=new JButton("Reset");
				addb= new JButton("Add");

		
		bPanel1.setBackground(Color.gray);
		bPanel1. setLayout(new GridLayout(1, 2));
		bPanel1.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
		
		ButtonListener b = new ButtonListener();
		reset.addActionListener(b);
		addb.addActionListener(b);
		reset.setActionCommand("reset");
		addb.setActionCommand("add");
		bPanel1.setVisible(true);
		
		
		bPanel1.add( addb, BorderLayout.WEST );
	    bPanel1.add( reset, BorderLayout.EAST );
		//bPanel1.add (resetgame);
		//bPanel1.add(addballs);
		f.add (bPanel1, BorderLayout.SOUTH);
		// Create the play area
		
		
		
		JPanel left = new JPanel();
		left.setLayout (new GridLayout (1, 2)) ;
		new JLabel("left");
		temp1 = new JLabel("left");
		temp2 = new JLabel("right");
		left.add (temp1);
		left. setBackground (Color.YELLOW);
		left.setSize(100,100);
		JPanel right = new JPanel();
		right.setBackground(Color.GRAY);
		right.add (temp2);
		right.setSize(100,100);
		right.setLayout (new GridLayout (1, 2));
		JPanel holdthese = new JPanel();
		holdthese.setBackground(Color.BLUE);
		holdthese.setSize(new Dimension(100, 100));
		holdthese.add(left, BorderLayout.WEST);
		holdthese.add (right, BorderLayout. EAST);
		f.add (holdthese, BorderLayout. NORTH) ;
			gamePanel = new Game();
		f.add(gamePanel);
isgate=false;
		// An anonymous MouseAdapter to add new balls
		gamePanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				{
					isgate=true;
				}
			}
			public void mouseReleased(MouseEvent e)
			
			{
			
			isgate = false;}
			
		});
		
		
		// Create a timer
		Timer tick = new Timer(100, new Animator());
		tick.start();

		f.setSize(800, 800);
		f.setVisible(true);
	}


	public class Ball {
	 
		int w=800;
		int h=800;
		double x, y;
		double vx, vy;
		double oldx, oldy;
		Color b;
		double sssquared;
		
		
		

	public Ball(boolean rr) {
		  isblue=rr;
		if(isblue)
		{
				b=Color.BLUE;
			
		x = (int)(Math.floor(Math.random() * w/2) + 0); // [100, 500)
			y = (int) (Math.floor(Math.random() * h) + 0);
			double cv1 = (Math.random()* 2) + 2;
			double vc2 = resolution/ 28.347;
			double lp = cv1 * vc2;
			double ray = Math.pow (lp, 2);
			double essick = Math.random()* ray;
			double locYSquared = ray- essick;
			sssquared = Math.pow(cv1, 2) ;
			vx= Math.sqrt (essick) ;
			vy= Math.sqrt(locYSquared);
			
		}
		else
		{
			b=Color.RED;
			x = (int)(Math.floor(Math.random() * w) + w/2); // [100, 500)
			y = (int) (Math.floor(Math.random() * h) + 0);

			double cv1 = (Math.random()* 4) + 2;
			double vc2 = resolution/ 28.347;
			double lp = cv1 * vc2;
			double ray = Math.pow (lp, 2);
			double essick = Math.random()* ray;
			double locYSquared = ray- essick;
			sssquared = Math.pow(cv1, 2) ;
			vx= Math.sqrt (essick) ;
			vy= Math.sqrt(locYSquared);
			
		}
	
	
	}

		
		public void move(double delta) {
			oldx = x;
			oldy = y;
			x += vx * delta;
			y += vy * delta;
			stayOnScreen();
		}

		public void stayOnScreen() {
			
		
				if (isgate)
				{
					if (isblue && x > 800/2) 
					
					vx *=-1;
					
					else if (!isblue && x < 800/2) 
					
					vx *= - 1;
					
					if(y>800)
					{vy*=-1;}
					
					if(x>800)
					{vx *=-1;}
				}
			else
				{
				
				if(isblue && x > 800/2) 
				{if (y < 800/3 && y >(800/3) * 2) 
			
				vx*=-1;
				if(y<0)
				{vx*=-1;}
				else if(!isblue && x < 800/2)
				
				{
					if (y > 800/3 && y < 800/3*2) 
						vx*=-1;
					
				}if(y>800)
					{vy*=-1;}
				if(x>800)
				{vx *=-1;}
			/*if(isgate)
			{
				
				if (x < 0)
					vx *= -1;
				if (x > w/2)
					vx *= -1;
				if (y < 0)
					vy *= -1;
				if (y > h)
					vy *= -1;
			}
			else
			{
				if (x < w/2)
					vx *= -1;
				if (x > w )
					vx *= -1;
				if (y < 0)
					vy *= -1;
				if (y > h)
					vy *= -1;
			}*/
			
				}}
			
		}

		// Balls draw themselves at current position
		
		
		public void draw(Graphics g) {
			
			
			g.setColor(b);
			g.fillOval((int) (x - 2), (int) (y - 2), 5, 5);
			
			
			
	
		}
	}

	
	public class Game extends JPanel {

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int i = 0; i < ballCount; i++) {
				balls[i].draw(g);
				g.setColor(Color.BLACK);
		        g.drawLine(410, 0, 410, (800*2)/3 );
		        //g.drawString("hhh", 400,5);
			if(isgate)
			{
			g.setColor(Color.red);
        g.drawLine(410, 900, 410, 533 );
			}
			}
		}}
	
	// Animator is the CONTROLLER -- it responds to events
	public class Animator implements ActionListener {
		int templ;
		int tempr;
		int ltsum;
		int rtsum;
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < ballCount; i++) {
				balls[i].move(0.1);
			gamePanel.repaint();
			}
			/*for (int i = 0; i < ballCount; i++) {

				if (!isblue)
				{
				templ += Math.pow(balls[i].sssquared, 2);

				ltsum++;}

				else
				{
				tempr += Math.pow(balls[i].sssquared, 2);
				rtsum++;
				}

				
				templ/=ltsum;
				tempr/= rtsum;
			}
				tempp1=(String.valueOf(templ));
				tempp2=(String.valueOf(tempr));}*/
		
			
		}}

}
	


