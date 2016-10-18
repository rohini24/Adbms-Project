package com;
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
import java.util.Hashtable;

/**
 
 */
public class DB extends Frame implements ActionListener{
     /* @param args the command line arguments
     */
    Hashtable<String,String> tb=new Hashtable<String,String>();
    Label namel,rolll,titlel;
    TextField namet,rollt;
    Button b1,b2,b3,search;
    static Button logout;
    static Button b4;
    TextArea ta;
    Image img;
       DB()
       {         
           setSize(600,580);
           setVisible(true);
           setLayout(null);
           setTitle("Students Record");
           setResizable(false);
           Font fn=new Font("Georgia",Font.BOLD,12);
           setFont(fn);
           setForeground(Color.black);
           setBackground(Color.gray);
           setLocation(400,130);
           
           namel=new Label("Name:");
           namel.setBounds(40,450,50,30);
           
           rolll=new Label("Roll NO:");
           rolll.setBounds(190,450,70,30);
           
           namet=new TextField();
           namet.setBounds(90,450,90,30);
           
           rollt=new TextField();
           rollt.setBounds(260,450,90,30);
           
           b1=new Button("ADD record");
           b1.setBounds(40,500,100,50);
           
           b2=new Button("DELETE record");
           b2.setBounds(150,500,100,50);
           
           b3=new Button("DISPLAY record");
           b3.setBounds(260,500,100,50);
           
           b4=new Button("UPDATE record");
           b4.setBounds(370,500,100,50);
           
           search=new Button("SEARCH");
           search.setBounds(480,500,100,50);
           
           ta=new TextArea();
           ta.setBounds(50,80,500,350);
           ta.setBackground(Color.WHITE);
           ta.setFocusable(false);
           
           logout=new Button("Logout");
           logout.setBounds(380,450,90,30);
             
           logout.setForeground(Color.black);
           logout.setBackground(Color.RED);
           
             titlel=new Label("Sr.No           Roll no             Name           Contact         Marks");
             titlel.setBounds(100,50,400,30);
             titlel.setForeground(Color.white);
             
           add(namel);
           add(rolll);
           add(namet);
           add(rollt);
           add(b1);
           add(b2);
           add(b3);
           add(b4);
           add(search);
           add(logout);
           add(ta);
           add(titlel);
           b1.addActionListener(this);
           b2.addActionListener(this);
           b3.addActionListener(this);
           b4.addActionListener(this);
           search.addActionListener(this);
           logout.addActionListener(this);  
       }
           
       public void display(){
           int i=1;
           try {
               ta.setForeground(Color.black);
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","roshu","abc123");  
            Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             ResultSet rs=stmt.executeQuery("select *from students");
              rs.beforeFirst();
        ta.setText("");
        while(rs.next()){
            tb.put(rs.getString(1),rs.getString(4));
        ta.append("   \t"+i+"\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t"+rs.getString(4)+"\n");
                   i++;
                }     
                rs.close();
                        con.close();
            } catch (Exception ex) {
            }
       }
    

    @Override
    public void actionPerformed(ActionEvent e){
       
       int i=1;
        if(e.getSource()==b1)
        {
             try {
Class.forName("oracle.jdbc.driver.OracleDriver");  

Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","roshu","abc123");  
             Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             stmt.executeUpdate("insert into students values("+(Integer.parseInt(rollt.getText()))+",'"+namet.getText()+"')");
          } catch (Exception ex) {}
            rollt.setText("");
            namet.setText("");
            rollt.setFocusable(true); 
        }
        
         if(e.getSource()==b2)
        {
             try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","roshu","abc123");  
  
                 Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                int executeUpdate = stmt.executeUpdate("delete from students where roll="+rollt.getText());
          } catch (Exception ex) {}
            namet.setText(" ");
            rollt.setText(" ");
            rollt.setFocusable(true); 
        }
         
           if(e.getSource()==b4)
           {
                    b4.setEnabled(false);
                    logout.setEnabled(false);
                    new Update(namet.getText(),rollt.getText());
                    rollt.setText(" ");
                    namet.setText(" ");
           }
           
           if(e.getSource()==search){
               int count=0;
        System.out.println(tb);
        while(tb.size()>0)
        {
          if(tb.containsValue("0")==true){
      count++;
          }              

        }System.out.println(count);
           }
            if(e.getSource()==logout)
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
               
           display(); 
        }                       
 }
