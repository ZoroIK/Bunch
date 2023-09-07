import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

/*
 * Final Programming Project
 * By:
 * Shreesh Shrestha & Anthony Paguay
 * 
 * Citations: event.zip (File in programming II CSCI185-CS-2022FA)
 * 
 * Main Page
 */

public class mainPage {

	private int x=90, y=20;	// coordinates of circle
	private JFrame frame;
	private PaintPanel circlePanel;//creates a paint panel for the circle
    private int replay = 0;
    private JButton Start = new JButton("Start");
    private JLabel Title = new JLabel("~~~~~||BUNCH||~~~~~",SwingConstants.CENTER);
    
    
	
	private class PaintPanel extends JPanel
	{
		// for the rep-paint()
		public void paintComponent(Graphics g )
		{
			super.paintComponent(g);
			
			// clears the screen
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			// draws the circle in new position
			g.setColor(Color.red);
			g.fillOval(x, y, 20, 20);

            
		}
	}
	
	public mainPage( )
	{   
        //creates a JFrame of title "Bunch" and sets its basic operations
		frame = new JFrame("BUNCH");
		frame.setSize( 400, 400);
		frame.setLocation( 800, 200);
        frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //color and fonts
        Color m = new Color(128,0,0);
        Color o = new Color(222,100,46);
        Color r = new Color(204,24,31);
        Font myfont1 = new Font("Algerian", Font.BOLD,18);
        Font myfont2 = new Font("Gabriola", Font.BOLD,18);
        
        //sets colors and fonts for Label and JButton
        Title.setFont(myfont1);
        Title.setForeground(Color.white);
        Start.setFont(myfont2);

        //cretes new paintpanel
		circlePanel = new PaintPanel();
    
        //creates new panel and adds them to the frame
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2,1));
        panel1.add(Title);
        panel1.add(new MovingMessagePanel("**Welcome to Bunch**",100));
        panel1.setBackground(Color.black);
        

        frame.add(BorderLayout.NORTH, panel1);
		frame.add(BorderLayout.CENTER, circlePanel);

        JPanel panel3 = new JPanel();
        panel3.add(Start);
        
        frame.add(BorderLayout.SOUTH, panel3);

        //adds action listener to the JButton
        Start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource()== Start){

                listGame.display();// displays the listGame frame
                frame.setVisible(false);//hides the  main frame


                }
            }

        });
	}

    //creates a moving message panel 
    static class MovingMessagePanel extends JPanel {
        private String m = "";
        private int x = 0;//x coordinate
        private int y = 10;//y coordinate
    
        public MovingMessagePanel(String heading, double delay) {
          m = heading;
    
          // Creates a timer
          Timer timer = new Timer((int)delay, new TimerListener());
          timer.start();
        }
    
        //displays the message in the component
        public void paintComponent(Graphics h) {
          super.paintComponent(h);
          h.setColor(Color.RED);//sets color of the message
          if (x > getWidth()) {
            x = -20;
          }
          x += 5;
          h.drawString(m, x, y);//draws te string
    
          
        }
    
        class TimerListener implements ActionListener {
          public void actionPerformed(ActionEvent e) {
            repaint();
          }
        }
    }
    
	public void launch( )
	{
        //sets frame visibility to true
        frame.setVisible(true);
        
		
        do{
		for (int i = 0; i < 200; i++)
		{
			//changes the circle's coordinates
			 
			++y;
            
			// repaint 
			circlePanel.repaint();

			try {  // waits 1ms 
				Thread.sleep(1);
			}catch (Exception ex) {System.out.println("Error!");}			
		}
        for (int i = 0; i < 200; i++)
		{
			// changes the circle's coordinates
			 
			++x;
            
			// repaint 
			circlePanel.repaint();
			try {  // wait 1ms 
				Thread.sleep(1);
			}catch (Exception ex) {System.out.println("Error!");}			
		}
        for (int i = 0; i < 100; i++)
		{
			// changes the circle's coordinates
			 
			--y;

			// repaint
			circlePanel.repaint();
			try {  // wait 1ms 
				Thread.sleep(1);
			}catch (Exception ex) {System.out.println("Error!");}			
		}
        for (int i = 0; i < 100; i++)
		{
			// changes the circle's coordinates
			 
			--x;
			// repaint
			circlePanel.repaint();
			try {  // wait 1ms 
				Thread.sleep(1);
			}catch (Exception ex) {System.out.println("Error!");}			
		}
        for (int i = 0; i < 100; i++)
		{
			// changes the circle's coordinates
			 
			++x;
			//repaint
			circlePanel.repaint();
			try {  // wait 1ms 
				Thread.sleep(1);
			}catch (Exception ex) {System.out.println("Error!");}			
		}
        for (int i = 0; i < 100; i++)
		{
			// changes the circle's coordinates
			 
			--y;
			// repaint
			circlePanel.repaint();
			try {  // wait 1ms 
				Thread.sleep(1);
			}catch (Exception ex) {System.out.println("Error!");}			
		}
        for (int i = 0; i < 200; i++)
		{
			// changes the circle's coordinates
			 
			--x;
			//repaint 
			circlePanel.repaint();
			try {  // wait 1ms 
				Thread.sleep(1);
			}catch (Exception ex) {System.out.println("Error!");}			
		}
         }while( replay == 0);
	}
    //displays the mainPage
	public static void display() {
		mainPage first = new mainPage();
		first.launch();
	}

	
}
