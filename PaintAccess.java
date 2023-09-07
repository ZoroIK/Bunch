import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Final Programming Project
 * By:
 * Shreesh Shrestha & Anthony Paguay
 * 
 * PaintAccess class
 */
public class PaintAccess extends JFrame{
    private JButton Red= new JButton("Red");
    private JButton Green = new JButton("Green");
    private JButton Blue = new JButton("Blue");
    private JButton Black = new JButton("Black");
    private JButton Eraser = new JButton("Eraser");
    private JButton Clear = new JButton("Clear");
    private JButton list = new JButton("Back to list of apps/games");

    private JFrame frame;
    public Paint paint;


    public PaintAccess(){
        //main frame
        frame = new JFrame();
        frame.setTitle("Bunch(Paint)");
        
        
        //Set layout in content plane
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        
        //creates new paint
        paint = new Paint();

        //adds to the contnet plane
        content.add(paint, BorderLayout.CENTER);

        

        //new JPlane
        JPanel panel1 = new JPanel();
        
        
        //sets foreground and background to diffrent buttons
        Red.setBackground(Color.red);
        Red.setForeground(Color.white);

        Green.setBackground(Color.green);
        Green.setForeground(Color.white);

        Blue.setBackground(Color.blue);
        Blue.setForeground(Color.white);

        Black.setBackground(Color.black);
        Black.setForeground(Color.white);

        Clear.setForeground(Color.red);


        
        //adds all the buttons to plane1
        panel1.add(Red);
        panel1.add(Green);
        panel1.add(Blue);
        panel1.add(Black);
        panel1.add(Eraser);
        panel1.add(Clear);
        
        JPanel li = new JPanel();
        li.setLayout(new BorderLayout());
        li.add(panel1,BorderLayout.EAST);
        li.add(list,BorderLayout.WEST);

        li.setBackground(Color.DARK_GRAY);//sets background of the plane
        panel1.setBackground(Color.DARK_GRAY);

        //creates controls to each buttons
        Red.addActionListener(new Listener());
        Green.addActionListener(new Listener());
        Blue.addActionListener(new Listener());
        Black.addActionListener(new Listener());
        Eraser.addActionListener(new Listener());
        Clear.addActionListener(new Listener());
        list.addActionListener(new Listener());

        //adds plane to the content
        content.add(li,BorderLayout.SOUTH);

        //sets dimensions and other functions to the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setResizable(false);
        frame.setVisible(true);

    }

   //displays PaintAccess
    public static void display() {
        new PaintAccess();
       

    }
    //creates actionlistener to each buttons
    class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == Clear){
                paint.clear();

            }
            else if( e.getSource() == Red){
                paint.red();

            }
            else if( e.getSource() == Green){
                paint.green();

            }
            else if( e.getSource() == Black){
                paint.black();

            }
            else if( e.getSource() == Blue){
                paint.blue();

            }
            else if( e.getSource() == Eraser){
                paint.eraser();

            }
            else if(e.getSource()== list){
                listGame.display();
                frame.setVisible(false);
            }

        }
    }
}
