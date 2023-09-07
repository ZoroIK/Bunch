import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



/*
 * Final Programming Project
 * By:
 * Shreesh Shrestha & Anthony Paguay
 * 
 * 
 * 
 * List Page
 */

public class listGame extends JFrame {
    private JFrame frame;
    private JLabel Heading = new JLabel("Choose any of the games/apps from the following : ");

    private JButton R = new JButton("Rock Paper Scissors");
    private JButton P = new JButton("Paint");
    private JLabel n = new JLabel("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    private String head = "~~||BUNCH||~~";

    public listGame(){

        //colors and fonts
        Color m = new Color(128,0,0);
        Color o = new Color(222,100,46);
        Color r = new Color(204,24,31);
        Font myfont1 = new Font("Algerian", Font.BOLD,24);
        Font myfont2 = new Font("Gabriola", Font.BOLD,24);

        //sets colors and fonts for JLabel and JButtons
        Heading.setFont(myfont2);
        Heading.setForeground(Color.white);
        n.setForeground(Color.white);
        

        //creates new panel for JLabel
        JPanel panel1 = new JPanel();
        panel1.add(Heading);
        panel1.setBackground(Color.black);
        panel1.setForeground(Color.white);

        //creates new panel for JButtons
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(7,1));//sets layout of the panel
        panel2.add(R);
        panel2.add(P);

        //Creates a panel for the message
        JPanel message = new JPanel();
        message.setLayout(new GridLayout(2,1));
        message.add(new MovingMessagePanel(head,100));
        message.add(n);
        message.setBackground(Color.black);

        //adds action listener for each button
        R.addActionListener(new Listener());
        P.addActionListener(new Listener());

        //by the time of the submission we could only create one game and one app for the app

        //creates new frame
        frame = new JFrame();
        frame.setSize(700,700);
        frame.setTitle("Bunch");
        frame.setLocation( 800, 200);
        
       //sets visibility to true
        frame.setVisible(true);
        
        
        //sets all the other functions and operations of the frame
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.CENTER);
        frame.add(message,BorderLayout.SOUTH);

        
    }
    //creates a moving message panel 
    static class MovingMessagePanel extends JPanel {
        private String m = "";
        private int x = 10;//x coordinate
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
          h.drawString(m, x, y);//draws  string
    
          
        }
    
        class TimerListener implements ActionListener {
          public void actionPerformed(ActionEvent e) {
            repaint();
          }
        }
    }

    class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()== R){
                RPS.display();//displays RPS game 

                frame.setVisible(false);//hides the current frame
            }
            else if(e.getSource()== P){
                System.out.println("Paint");
                PaintAccess.display();

                frame.setVisible(false);
            }

        }

       
    }

    //displays the listGame
    public static void display(){
        listGame n = new listGame();
        

    }
}
