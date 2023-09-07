import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
/*
 * Final Programming Project
 * By:
 * Shreesh Shrestha & Anthony Paguay
 * 
 * Paint class
 */

public class Paint extends JComponent {

    //Mouse Coordinates
    private int x,y,x1,y1;
    //Image which we will be drawing
    private Image image;
    //2D Graphic Object
    private Graphics2D g;
    
   
  
    public Paint(){

       
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                //Saves x and y coordinates of mouse when it is pressed
                x = e.getX();
                y = e.getY();

            }
            
        } );

         addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                //Saves x and y coordinates of mouse when it is dragged

                x1 = e.getX();
                y1 = e.getY();

                //draw the line between cords
                g.drawLine(x, y, x1, y1);
                repaint();

                //restores the new values
                x  = x1;
                y = y1;
                
            }

         });

        

    }

    protected void paintComponent(Graphics a){
        if(image ==null){// image to draw null
            image = createImage(getSize().width, getSize().height);//gets the size same as the frame
            g = (Graphics2D) image.getGraphics();
            //clear image
            clear();


        }

        a.drawImage(image,0,0,null);


    }

    public void clear(){ // draw white in entire image to clear
        g.setPaint(Color.white);
        g.fillRect(0, 0, getSize().width, getSize().height);
        g.setPaint(Color.black);// restarts with black paint
        repaint();
    }


    //To apply different color on graphics
    public void red(){
        g.setPaint(Color.red);

    }

    public void green(){
        g.setPaint(Color.green);

    }
    public void black(){
        g.setPaint(Color.black);

    }

    public void blue(){
        g.setPaint(Color.blue);

    }
    public void eraser(){
        g.setPaint(Color.white);

    }

   
    
    
}
