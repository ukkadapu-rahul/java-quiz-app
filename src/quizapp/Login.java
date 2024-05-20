package quizapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
    JButton rules, back;
    JTextField tfname;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon ic =new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        // to get image from folder
        JLabel image =new JLabel(ic);
        image.setBounds(0,0,600,500);
        add(image);// add image to frame
        
        JLabel heading = new JLabel("Quiz App Project");//heading
        heading.setBounds(750,60,300,45);
        add(heading);
        heading.setFont(new Font("Impact",Font.BOLD,40));//font setting
        heading.setForeground(new Color(67,230,189));//heading colour
        
        JLabel name = new JLabel("Enter your Name");//entering name
        name.setBounds(810,150,300,20);
        add(name);
        name.setFont(new Font("SansSerif",Font.BOLD,20));//font setting
        name.setForeground(Color.darkGray);
        
        //textfield for name
        tfname= new JTextField();
        tfname.setBounds(735, 200,300,25);
        tfname.setFont(new Font("Arial",Font.BOLD,20));
        add(tfname);
        
        //rules button
        rules = new JButton("Rules");
        rules.setBounds(735,270,120,25);
        rules.setBackground(new Color(67,230,189));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);// for showing rules on click
        add(rules);
        //rules button end
        
        //exit button->
        back = new JButton("Exit");
        back.setBounds(910,270,120,25);
        back.setBackground(new Color(67,230,189));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);// exiting frame on click
        add(back);
        //exit button
        
        
        
        setSize(1200,500);//frame
        setLocation(200,150);//frame
        setVisible(true);//frame
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== rules){  /* for function to know which button is being clicked*/
            String name= tfname.getText();// getting text from textfield
            setVisible(false);
            new Rules(name);// passing the entered name to next frame
        }else if(ae.getSource()== back){
            setVisible(false);// exit 
        }
    }
    public static void main(String[] args){
        new Login();
    }
}
