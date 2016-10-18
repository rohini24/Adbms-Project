package com;
import java.util.*;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 
 */
public class User extends Frame implements ActionListener{
     /* @param args the command line arguments
     */
    Label score,titlel,q1,q2,q3,q4,q5,op1,op2,op3,op4,op5;
    int counter=0;
    Label x1,x2,x3,xp1,xp2,xp3;
    TextField x1t,x2t,x3t;
    TextField result,namet,rollt,q1t,q2t,q3t,q4t,q5t;
    Button b1,b2;
    static Button logout;
    static Button b3,nextb;
    TextArea ta;
     String name,roll;
    Image img;
       User(String name,String roll)
       {         
           setSize(700,580);
           setVisible(true);
           setLayout(null);
           setTitle("Test your skills");
           setResizable(false);
           Font fn=new Font("Georgia",Font.BOLD,12);
           setFont(fn);
           setForeground(Color.black);
           setBackground(Color.LIGHT_GRAY);
           setLocation(400,50);
           //b1=new Button("Submit");
           //b1.setBounds(0,0,00,50);
           
           //namel=new Label("Name:");
           //namel.setBounds(40,450,50,30);
           titlel=new Label("ADBMS Exam");
           titlel.setBounds(200,40,400,30);
           titlel.setForeground(Color.white);
           
           score=new Label("Your Score: ");
           score.setBounds(400,40,400,30);
           score.setForeground(Color.RED);
           
           result=new TextField();
           result.setBounds(500,40,40,30);
                   
           Font myFont = new Font("Serif",Font.BOLD,18);
           titlel.setFont(myFont);
           score.setFont(myFont);

             this.name=name;
             this.roll=roll;
           
                      Font fo = new Font("Serif",Font.BOLD,16);

           q1=new Label("Q1. The method of access that uses key transformation is called as");
           q1.setBounds(5,100,500,30);
           q1.setForeground(Color.BLUE);
           q1.setFont(fo);

           op1=new Label("A) Direct    B) Hash    C) Sequential    D) Random");
           op1.setBounds(5,130,500,30);
           op1.setForeground(Color.white);     
          
           q1t=new TextField();
           q1t.setBounds(530,130,40,30);
           
           x1=new Label("\nQ1. Fork is\n");
           x1.setBounds(5,100,500,30);
           x1.setForeground(Color.BLUE);
           x1.setFont(fo); 
           xp1=new Label("A)the dispatching of a task  B)the creation of a new job  C)the creation of a new process\n");
           xp1.setBounds(5,130,500,30);
           xp1.setForeground(Color.white);     
           x1t=new TextField();
           x1t.setBounds(530,130,40,30);
           
           q2=new Label("\nQ2.Which JDBC driver Type(s) is(are) the JDBC-ODBC bridge?\n");
           q2.setBounds(5,160,500,30);
           q2.setForeground(Color.BLUE);
           q2.setFont(fo);

           op2=new Label("A) Type 1    B) Type 2    C) Type 3    D) Type 4\n");
           op2.setBounds(5,190,500,30);
           op2.setForeground(Color.white);     
           
           q2t=new TextField();
           q2t.setBounds(530,190,40,30);
     
 
           x2=new Label("\nQ2.Which of the following are(is) Language Processor(s)\n");
           x2.setBounds(5,160,500,30);
           x2.setForeground(Color.BLUE);
           x2.setFont(fo); 
           xp2=new Label("A)assembler    B)compilers    C)interpreters    D)All of these\n");
           xp2.setBounds(5,190,500,30);
           xp2.setForeground(Color.white);     
           x2t=new TextField();
           x2t.setBounds(530,190,40,30);
           
           q3=new Label("\nQ3. How many types of indexes are there in sql server?");
           q3.setBounds(5,210,500,30);
           q3.setForeground(Color.BLUE);
           q3.setFont(fo);

           op3=new Label("A) 1   B) 3   C) 2    D) 5\n");
           op3.setBounds(5,240,500,30);
           op3.setForeground(Color.white);     
           
           q3t=new TextField();
           q3t.setBounds(530,240,40,30);
          
           x3=new Label("\nQ3.What is the name of OS for the computer called MacLite?\n");
           x3.setBounds(5,210,500,30);
           x3.setForeground(Color.BLUE);
           x3.setFont(fo); 
           xp3=new Label("A) MS-DOS   B) OZ  C) DOS    D) Windows\n");
           xp3.setBounds(5,240,500,30);
           xp3.setForeground(Color.white);     
           x3t=new TextField();
           x3t.setBounds(530,240,40,30);
           
           
           b3=new Button("SUBMIT");
           b3.setBounds(300,400,100,50);

           nextb=new Button("Next");
           nextb.setBounds(200,500,100,50);
           
           logout=new Button("Logout");
           logout.setBounds(380,500,100,50);
             
           logout.setForeground(Color.black);
           logout.setBackground(Color.RED);
         add(b3);add(nextb);
         add(logout);         
         
           b3.addActionListener(this);
           nextb.addActionListener(this);

           //b4.addActionListener(this);
         logout.addActionListener(this);
         add(result);
                  add(score);

         add(titlel);
         add(q1);
         add(q1t);
         add(op1);
         add(q2);
         add(q2t);
         add(op2);
         add(q3);
         add(q3t);
         add(op3);
         add(q4);
         add(q4t);
         add(op4);
         add(q5t);
         add(op5);

       }

    @Override
    public void actionPerformed(ActionEvent te){


if(q1t.getText().equals("B")){
       counter+=5;
       q1t.setText("");
}else  counter+=0; 

if(x1t.getText().equals("C")){
       counter+=5;
    x1t.setText("");

}else  counter+=0; 

if(q2t.getText().equals("A")){
       counter+=5;
    q2t.setText("");

}else  counter+=0;

if(x2t.getText().equals("D")){
       counter+=5;
    x2t.setText("");

}else  counter+=0; 

if(q3t.getText().equals("C")){
       counter+=5;
    q3t.setText("");

}else  counter+=0;       

if(x3t.getText().equals("B")){
       counter+=5;
    x3t.setText("");

}else  counter+=0; 


if(te.getSource()==b3)
        {
result.setText(String.valueOf(counter));
 
b3.setVisible(false);
   

try {
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","roshu","abc123");  
              // Statement stmt1= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             Statement stmt2= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            // stmt1.executeUpdate("update students set marks=String.valueOf(counter) where roll='9'");
          
         //rs.getString(4)+result.getText();
           // mar=10;
            stmt2.executeUpdate("update students set marks='"+result.getText()+"' where roll="+roll);
          } catch (Exception ex) {
   
                                 }
           
}

if(te.getSource()==nextb)
{
    b3.setVisible(true);
    b3.setBounds(200,500,100,50);

    titlel.setText("OPERATING SYSTEM");
    //  new exam();
    nextb.setVisible(false);
    q1.setVisible(false);
    q1t.setVisible(false);
    op1.setVisible(false);
    
       add(x1);
       add(x1t);
       add(xp1);
       
       
    q2.setVisible(false);
    q2t.setText("");
    q2t.setVisible(false);
    op2.setVisible(false);
    
       add(x2);
       add(x2t);
       add(xp2);
       
       
    q3.setVisible(false);
    q3t.setText("");
    q3t.setVisible(false);
    op3.setVisible(false);
    
       add(x3);
       add(x3t);
       add(xp3);
  
}
            if(te.getSource()==logout)
            {
                       addWindowListener(new WindowAdapter() { 
                        @Override
                        public void windowClosing(WindowEvent we)
                        {
                        
                             dispose();
                       }
                        });
                          LG.tt1.setEnabled(true);
                          LG.tt2.setEnabled(true);
                          LG.bb1.setEnabled(true);
                          LG.cb.setState(false);
                          LG.tt2.setText("");
                          LG.fg=false;
                             dispose();                           
            }   
        }                       
 }
