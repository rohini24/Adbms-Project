package com;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Update extends Frame implements ActionListener{
    Label lu1,lu2,lu3,lu4;
    TextField tu1,tu2,tu3,tu4;
    String name,roll;
    Button up;
     Update(String name,String roll) {
         setSize(320,120);
         setVisible(true);
         setResizable(false);
         setTitle("Update Record");
         setLayout(null);
         Font fm=new Font("Georgia",Font.BOLD,13);
         setFont(fm);
         setLocation(640,400);
         addWindowListener(new WindowAdapter() { 
                        @Override
                        public void windowClosing(WindowEvent we)
                        {
                             DB.b4.setEnabled(true);
                             dispose();
                       }
              });
         this.name=name;
         this.roll=roll;
         tu1=new TextField();
         tu1.setBounds(120,40,100,30);
       // tu2=new TextField();
        //tu2.setBounds(120,70,100,30);
        
        
        lu1=new Label("Marks");
        lu1.setBounds(25,40,80,20);
        
      //  lu2=new Label("Roll No:");
        //lu2.setBounds(25,70,80,20);

         up=new Button("UPDATE");
         up.setBounds(230,40,70,60);
         up.setForeground(Color.MAGENTA);
         add(lu1);
         //add(lu2);
         add(tu1);
        // add(tu2);
         add(up);
         up.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           try {
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","roshu","abc123");  
               Statement stmt1= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             //Statement stmt2= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             stmt1.executeUpdate("update students set marks='"+tu1.getText()+"' where roll="+roll);
            // stmt2.executeUpdate("update student set roll="+(Integer.parseInt(tu2.getText()))+" where roll="+roll);
          } catch (Exception ex) {
   
                                 }
            tu1.setText("");
           // tu2.setText("");
            tu1.setFocusable(true);
            
            DB.b4.setEnabled(true);
            DB.logout.setEnabled(true);
            dispose();            
    }        
}