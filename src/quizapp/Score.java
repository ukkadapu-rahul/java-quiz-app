
package quizapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Score extends JFrame implements ActionListener {

    public Score(String name, int score) {
        setBounds(600,150,750,550);
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         ImageIcon ic =new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        // to get image from folder
        Image i2= ic.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,200,300,250);
        add(image);
         
        JLabel heading = new JLabel("Thank You "+ name+ " for Playing!");
        heading.setBounds(45,30,700,30);  
        heading.setFont(new Font("Tahoma",Font.PLAIN,26));
         add(heading);
         
         
        JLabel fscore = new JLabel("Your score is: "+ score);
        fscore.setBounds(350,200,300,30);  
        fscore.setFont(new Font("Tahoma",Font.PLAIN,26));
         add(fscore);
        
        JButton agn = new JButton("QUIT");
         agn.setBounds(380,270,130,20);
         agn.setBackground(new Color(67,230,189));
         agn.setForeground(Color.white);
         agn.addActionListener(this);
         add(agn);

         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    
    public static void main(String[] args){
        new Score("User", 0);
    }
}
