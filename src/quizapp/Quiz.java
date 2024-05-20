package quizapp;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{
    String questions[][] =new String[10][5];
    String answers[][]= new String[10][2];
    String useranswer[][]=new String[10][1];//storing selected option 
    JLabel qno,question;
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup groupoptions;
    JButton next,submit,lifeline;
    
    public static int timer=15; //for timer near buttons
    public static int answer_given =0; // flag for timer after timer is 0
    public static int count=0;// for timer and q&a iteration
    public static int score=0; //final scores
    String name;

     Quiz(String name) {
         this.name=name;
         setBounds(50,0,1300,800);
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         ImageIcon ic =new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        // to get image from folder
        JLabel image =new JLabel(ic);
        image.setBounds(0,0,1300,350);
        add(image);
         
        qno = new JLabel();
        qno.setBounds(100,400,50,30);  //question numbers
        qno.setFont(new Font("Tahoma",Font.PLAIN,22));
         add(qno);
         
        question = new JLabel();
        question.setBounds(150,400,900,30); // questions
        question.setFont(new Font("Tahoma",Font.PLAIN,22));
         add(question);
         
         /* questions and answers below*/
         
         questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
        
        //answers
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
        
        opt1 = new JRadioButton();
        opt1.setBounds(170,480,700,30); //options
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog",Font.PLAIN,22));
         add(opt1);
         
        opt2 = new JRadioButton();
        opt2.setBounds(170,520,700,30); //option
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog",Font.PLAIN,22));
         add(opt2);
         
        opt3 = new JRadioButton();
        opt3.setBounds(170,560,700,30);
        opt3.setBackground(Color.WHITE);  //option
        opt3.setFont(new Font("Dialog",Font.PLAIN,22));
         add(opt3);
         
        opt4 = new JRadioButton();
        opt4.setBounds(170,600,700,30);
        opt4.setBackground(Color.WHITE);  //option
        opt4.setFont(new Font("Dialog",Font.PLAIN,22));
         add(opt4);
         
          groupoptions = new ButtonGroup();
         groupoptions.add(opt1);
         groupoptions.add(opt2);
         groupoptions.add(opt3);
         groupoptions.add(opt4);
         
         // next,lifeline,submit buttons
         next = new JButton("Next");
         next.setBounds(950,500,200,40);
         next.setFont(new Font("Tahoma",Font.PLAIN,22));
         next.setBackground(new Color(67,230,189));
         next.setForeground(Color.white);
         next.addActionListener(this);
         add(next);
         
         lifeline = new JButton("50-50 LifeLine");
         lifeline.setBounds(950,580,200,40);
         lifeline.setFont(new Font("Tahoma",Font.PLAIN,22));
         lifeline.setBackground(new Color(67,230,189));
         lifeline.setForeground(Color.white);
           lifeline.addActionListener(this);
         add(lifeline);
         
         submit = new JButton("Submit");
         submit.setBounds(950,660,200,40);
         submit.setFont(new Font("Tahoma",Font.PLAIN,22));
         submit.setBackground(new Color(67,230,189));
         submit.setForeground(Color.white);
         submit.setEnabled(false);
         submit.addActionListener(this);
         add(submit);
         
         start(count);

         
         setVisible(true);//frame
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()== next){
             repaint();
             opt1.setEnabled(true);
             opt2.setEnabled(true);
             opt3.setEnabled(true);
             opt4.setEnabled(true);
             /*
             enable options again if we used lifeline for previous question
             */
             
             answer_given =1;
             if(groupoptions.getSelection()== null){ //if no option selected
                 useranswer[count][0]= "";
                 
             }
             else{
                 useranswer[count][0]= groupoptions.getSelection().getActionCommand();
                
             }
             if(count==8) {//9th question
             next.setEnabled(false);
             submit.setEnabled(true);//to submit all answers
             }
             count++;
             start(count);
             
         }else if(ae.getSource() == lifeline){
             if(count ==2 || count ==4 || count==6 || count ==8 || count==9 ){
                 opt2.setEnabled(false);
                 opt3.setEnabled(false);
             }
             else{
                 opt1.setEnabled(false);
                 opt4.setEnabled(false);
             }
             lifeline.setEnabled(false); // use only 1 time
             
         }else if(ae.getSource()== submit){
             //if user has pressed on submit
             answer_given=1;
             if(groupoptions.getSelection()== null){ 
                useranswer[count][0]= "";
                 
            }
             else{
                useranswer[count][0]= groupoptions.getSelection().getActionCommand();
                 
            }
                for(int i=0;i<useranswer.length;i++){
                  if(useranswer[i][0].equals(answers[i][1])){
                      score += 10;
                  }   
                }
                setVisible(false);
                new Score(name, score);
        }
    }
    
     public void paint(Graphics g){ //paint method calls itself after initialisation
         super.paint(g);
         
         String time= "Time left :" + timer + "seconds";
         g.setColor(Color.RED);
         
         if(timer >0){
             g.setFont(new Font("Tahoma",Font.PLAIN,30));
             g.drawString(time, 900, 500);
         }
         else{
             g.setFont(new Font("Tahoma",Font.BOLD,30));
             g.drawString("Time's up!", 950, 500);
         }
         timer--;
         try{
             Thread.sleep(1000);
             repaint(); // calling paint method again
         }catch(InterruptedException ex){
         ex.printStackTrace();
         }
         /* checking condition wether option is selected or not before the
         timer runs out
         */
         if(answer_given == 1){
             answer_given=0;
             timer =15;
             
         }
         else if(timer < 0){
             timer =15;
             opt1.setEnabled(true);
             opt2.setEnabled(true);
             opt3.setEnabled(true);
             opt4.setEnabled(true);
             /*
             to enable back options again for next question if 
             we had used lifeline on previous question
             */
             if(count==8){ 
             next.setEnabled(false);
             submit.setEnabled(true);
             }
             if(count ==9 ){ //submit buton
                 if(groupoptions.getSelection()== null){ 
                 useranswer[count][0]= "";
                 
             }
             else{
                 useranswer[count][0]= groupoptions.getSelection().getActionCommand();
                 
             }
                 for(int i=0;i<useranswer.length;i++){
                  if(useranswer[i][0].equals(answers[i][1])){
                      score += 10;
                  }   
                 }
                 setVisible(false);
                 new Score(name,score);
                 
             }else{ //next button
             if(groupoptions.getSelection()== null){ //if no option selected
                 useranswer[count][0]= "";
                 
             }
             else{
                 useranswer[count][0]= groupoptions.getSelection().getActionCommand();
                 // get the selected option value and store in array
             }
             count++;
             start(count);//next question
             }
         }
     }
     
     public void start(int count){
         qno.setText("" +(count+1) +". ");  /*int to string conversion to place on label*/
         question.setText(questions[count][0]); /* displaying the questions
         count is initially 0, so the [0][0]th values in array i.e.
         the question will be printed
         */
         opt1.setText(questions[count][1]);
         opt1.setActionCommand(questions[count][1]);
         /*
         setActionCommand() used because of GetActionCommand()
         i.e setting initial value for option
         */
         opt2.setText(questions[count][2]);
         opt2.setActionCommand(questions[count][2]);
         opt3.setText(questions[count][3]);
         opt3.setActionCommand(questions[count][3]);
         opt4.setText(questions[count][4]);
         opt4.setActionCommand(questions[count][4]);
         
         groupoptions.clearSelection();
         /*
         if we select any option and don't do anything till timer runs up,
         the  next question's value will be same as previous question's selected
         option value
         clearSelection() will clear the option value for next question
         */
         
     }
    
    public static void main(String[] args){
        new Quiz("User");
    } 
}
