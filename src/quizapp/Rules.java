package quizapp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rules extends JFrame implements ActionListener{
    String name;
    JButton start,back;
    Rules(String name){
        this.name=name;
        getContentPane().setBackground(Color.WHITE);//frame bg
        setLayout(null);
        
        JLabel heading = new JLabel("Rules");
        heading.setBounds(50,20,700,30);
        add(heading);
        heading.setFont(new Font("Impact",Font.BOLD,28));
        heading.setForeground(new Color(67,230,189));
        
         JLabel rules = new JLabel();
        rules.setBounds(20,90,700,350);
        add(rules);
        rules.setFont(new Font("Tahoma",Font.PLAIN,17));
        rules.setText(
        "<html>"+ 
                "1. You will be given only 10 questions" + "<br><br>" +
                "2. Lifeline can be used only once" + "<br><br>" +
                "3. All the questions are compulsory" + "<br><br>" +
                "4. Submit button will be available on the final question." + "<br><br>" +
                "5. Choose any one of the 4 options" + "<br><br>" +
                "6. Select your answer before timer runs out" + "<br><br>" +
                "7. Good Luck" + "<br><br>" +
            "<html>"
        );
        rules.setForeground(Color.BLACK);
        
        //exit button->
        back = new JButton("Exit");
        back.setBounds(250,500,100,30);
        back.setBackground(new Color(67,230,189));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);// exiting frame on click
        add(back);
        
        start = new JButton("Start");
        start.setBounds(400,500,100,30);
        start.setBackground(new Color(67,230,189));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);// for showing rules on click
        add(start);
        //rules button end
        
        
        setSize(800,650);
        setLocation(350,100);//location on screen
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== start){
            setVisible(false);
            new Quiz(name);
        }else{
            setVisible(false);
            new Login();
        }
    }
    public static void main(String args[]){
        new Rules("name");
    }
}
