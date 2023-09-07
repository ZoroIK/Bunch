/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 import java.awt.BorderLayout;
 import java.awt.event.ActionListener;
 import java.io.IOException;
 import java.awt.event.ActionEvent;
 import java.awt.Color;
 
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;
 import javax.swing.JTextField;
 import javax.swing.JTextArea;
 import javax.swing.WindowConstants;
 /**
  *
  * @author ajpag
  */
 public class RPS extends JFrame{
     JButton shootButton;
     JButton playAgainButton;
     JButton list;
     JLabel pick, wrong,instructions;
     JTextArea results;
     JTextField theirChoice;
     JPanel center,lower,upper;
     String TC;
     int cc, tc;
     int i,c;
     Color r = new Color(204, 0 , 0);
      
     public static String Results(int x){ // Made by Shreesh
         String s = "";
         if(x == 0){
             s += "Rock";
         }
         if(x == 1){
             s += "Paper";
         }
         if(x == 2){
             s += "Scissors";
         }
         return s;
     }
     
     public int tChoice(){
        tc = 3; 
         if(TC.equals("Rock")){
         tc = 0;
         }
         if(TC.equals("Paper")){
             tc = 1;
         }
         if(TC.equals("Scissor")){
             tc = 2;
         }
         return tc;
     }
     
     public RPS(){
         super("Rock Paper Scissors");
         setLocation(450, 120);
         setSize(250, 299);
         
         center = new JPanel();
         add(center, BorderLayout.CENTER);
         
         lower = new JPanel();
         add(lower, BorderLayout.SOUTH);
         
         upper = new JPanel();
         add(upper,BorderLayout.NORTH);
         
         shootButton = new JButton("Shoot");
         
         shootButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             if(i == 1){
                 center.remove(wrong);
                 setSize(150, 299);
                 i = 0;
                 }
             try{
                 TC = theirChoice.getText();
                 tChoice();
                 if(tc == 3){
                     tc = 0;
                 throw new IOException();
             }
                 cc = (int)(Math.random()*10);
                 cc %= 3;
                 if (tc == cc){
                 results.setText("Tied\nYou Choose: " + Results(tc) + "\nComputer Choose: " + Results(cc));
             }
 
             if (tc - cc == -2||tc - cc == 1){
                results.setText("Won\nYou Choose: " + Results(tc) + "\nComputer Choose: " + Results(cc));
             }
             
             if (tc - cc == 2||tc - cc == -1){
                 results.setText("Lost\nYou Choose: " + Results(tc) + "\nComputer Choose: " + Results(cc));
             }
             center.add(results);
             center.remove(theirChoice);
             theirChoice.setText("");
             theirChoice.requestFocus();
             center.remove(pick);
             lower.add(playAgainButton);
             lower.remove(shootButton);
             setSize(250, 300);   
         }catch(IOException eh){
             center.add(wrong);
             setSize(250, 300);
             i = 1;
         }
         }}
         );
         
         playAgainButton = new JButton("Play Again");
         
         playAgainButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){        
             center.remove(results);
             results.setText("");
             center.add(pick);
             center.add(theirChoice);
             lower.remove(playAgainButton);
             lower.add(shootButton);
             setSize(250, 299);
         }
         });

         list= new JButton("Back");
         list.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                listGame.display();
                setVisible(false);
                
            }
            
        });
         
         instructions = new JLabel("Enter: Rock, Paper or Scissor");
         pick = new JLabel("Choice:");
         wrong = new JLabel("Please follow Instructions");
         wrong.setForeground(r);
         results = new JTextArea();
         theirChoice = new JTextField(8);
         
         upper.add(instructions);
         center.add(pick);
         center.add(theirChoice);
         lower.add(list);
         lower.add(shootButton);  
         
         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     }
     public static void display(){
         RPS rps = new RPS();
         rps.setVisible(true);
     }
 }