package com;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.PopupMenu;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

public class LG extends Frame implements ActionListener{
   Hashtable<String,String> ht=new Hashtable<String,String>();
    static TextField tt1,tt2;
    Label ll1,ll2,ll3;
    static Button bb1;
    static Checkbox cb;
    String id="rohini",pas="1234";
    Font f;
    static Boolean fg=false;
    LG()
    {
        setSize(270,190);
        setTitle("LOGIN");
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setLocation(400,270);
        addWindowListener(new WindowAdapter() { 
                        @Override
                        public void windowClosing(WindowEvent we)
                        {
                            if(!fg)
                             dispose();
                       }
              });
       //add();
        f=new Font("Georgia",Font.BOLD,14);
        setFont(f);
        tt1=new TextField();
        tt1.setBounds(110,40,150,30);
        
        tt2=new TextField();
        tt2.setBounds(110,80,150,30);
        tt2.setEchoChar('*');
        ll1=new Label("Username:");
        ll1.setBounds(25,40,80,20);
        
        ll2=new Label("Password:");
        ll2.setBounds(25,80,80,20);
        ll3=new Label("");
        ll3.setBounds(30,110,250,20);
        ll3.setForeground(Color.red);
        bb1=new Button("Login");
        bb1.setBounds(120,125,100,50);
        bb1.setForeground(Color.BLUE);
                
        cb=new Checkbox("log in",false);
        cb.setBounds(40,130,60,20);
        cb.setEnabled(false);
        bb1.addActionListener(this);
        add(tt1);
        add(cb);
        add(tt2);
        add(ll3);
        add(ll2);
        add(ll1);
        add(bb1);
    }
    
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
         new LG();
            
    }
    

    @Override
    public  void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==bb1){
            
        
        if(id.equals(tt1.getText()) && pas.equals(tt2.getText())){
         
            tt1.setEnabled(false);
            tt2.setEnabled(false);
            bb1.setEnabled(false);
            cb.setState(true);
            fg=true;
            new DB();
            
         }
try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","roshu","abc123");  
  
//step3 create the statement object  
Statement stmt=con.createStatement();  
  
//step4 execute query  
ResultSet rs=stmt.executeQuery("select * from students");  
while(rs.next())  
{ //  hm.put(rs.getString(1),rs.getString(2));
if(tt1.getText().equals(rs.getString(2))&&tt2.getText().equals(rs.getString(1))){
            tt1.setEnabled(false);
            tt2.setEnabled(false);
            bb1.setEnabled(false);
            cb.setState(true);
            fg=true;
            new User(rs.getString(2),rs.getString(1));
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
        else
if(!rs.next()){
     tt1.setText("");
     tt2.setText("");
            ll3.setText("Incorrect Username or Password");
           
        }
}            

//step5 close the connection object  
con.close();  
  
}catch(Exception he){ System.out.println(he);}  
    }
    
}
    }

