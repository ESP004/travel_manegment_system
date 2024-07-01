
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Forget_pass extends JFrame implements ActionListener{
    
    JTextField username_txt , name_txt , ans_txt , sq_txt , password_txt;
    JButton back , search , retrive;
    
    Forget_pass()
    {
        
        //create the panel for place the image
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(232, 194, 181));
        p1.setBounds(0, 0, 600, 500);
        p1.setLayout(null);
        add(p1);
        
        //add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(700, 100, 200, 200);
        add(image);
        
        //add label for user name
        JLabel username = new JLabel("Username  :");
        username.setBounds(100, 60, 150, 30);
        username.setFont(new Font("Arial" , Font.BOLD , 20));
        p1.add(username);
        //add textfield for username
        username_txt = new JTextField();
        username_txt.setBounds(250, 60, 140, 30);
        username_txt.setFont(new Font("Arial" , Font.BOLD , 15));
        username_txt.addActionListener(this);
        p1.add(username_txt);
        
        //add button for back
        search = new JButton("Search");
        search.setBounds(400, 60, 100, 30);
        search.setBackground(new Color(163, 163, 163));
        search.setFont(new Font("Arial" , Font.BOLD , 15));
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        p1.add(search);
        
        //add label for name
        JLabel name = new JLabel("Name      :");
        name.setBounds(100, 130, 150, 30);
        name.setFont(new Font("Arial" , Font.BOLD , 20));
        p1.add(name);
        //add textfield for name
        name_txt = new JTextField();
        name_txt.setBounds(250, 130, 250, 30);
        name_txt.setFont(new Font("Arial" , Font.BOLD , 15));
        name_txt.addActionListener(this);
        p1.add(name_txt);
        
        //add label for Security question
        JLabel sq = new JLabel("Security question :");
        sq.setBounds(100, 200, 150, 30);
        sq.setFont(new Font("Arial" , Font.BOLD , 15));
        p1.add(sq);
        //add textfield for Security question
        
        sq_txt = new JTextField();
        sq_txt.setBounds(250, 200, 250, 30);
        sq_txt.setFont(new Font("Arial" , Font.BOLD , 15));
        sq_txt.addActionListener(this);
        p1.add(sq_txt);
        
        //add label for Answer
        JLabel ans = new JLabel("Answer :");
        ans.setBounds(100, 270, 150, 30);
        ans.setFont(new Font("Arial" , Font.BOLD , 20));
        p1.add(ans);
        //add textfield for Answer
        ans_txt = new JTextField();
        ans_txt.setBounds(250, 270, 140, 30);
        ans_txt.setFont(new Font("Arial" , Font.BOLD , 15));
        ans_txt.addActionListener(this);
        p1.add(ans_txt);
        
        //add button for back
        retrive = new JButton("Retrive");
        retrive.setBounds(400, 270, 100, 30);
        retrive.setBackground(new Color(163, 163, 163));
        retrive.setFont(new Font("Arial" , Font.BOLD , 15));
        retrive.setForeground(Color.WHITE);
        retrive.addActionListener(this);
        p1.add(retrive);
        
        //add label for password
        JLabel password = new JLabel("Password  :");
        password.setBounds(100, 340, 150, 30);
        password.setFont(new Font("Arial" , Font.BOLD , 20));
        p1.add(password);
        //add textfield for password
        password_txt = new JTextField();
        password_txt.setBounds(250, 340, 250, 30);
        password_txt.setFont(new Font("Arial" , Font.BOLD , 15));
        password_txt.addActionListener(this);
        p1.add(password_txt);
        
        //add button for back
        back = new JButton("Back");
        back.setBounds(400, 400, 100, 30);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Arial" , Font.BOLD , 20));
        back.setForeground(new Color(232, 194, 181));
        back.addActionListener(this);
        p1.add(back);
        
        //deploy the frame
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,500);
        setLocation(250,150);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //fetch data from the database
        String username = username_txt.getText();
        //prepare query
        String query = "select * from login where username = '"+username+"'";
        //action performed on search button click
        if(ae.getSource() == search)
        {
            //set name and security question according to user name from database
            Conn con = new Conn();
            try {
                ResultSet user_data = con.s.executeQuery(query);
                while(user_data.next())
                {
                    name_txt.setText(user_data.getString("name"));
                    sq_txt.setText(user_data.getString("security_question"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        //action performed on search retrive click
        else if(ae.getSource() == retrive)
        {
            //fetch ans from text field
            String ans = ans_txt.getText();
            //fetch ans from database
            Conn con = new Conn();
            try {
                ResultSet user_data = con.s.executeQuery(query);
                //variable use to store ans from database
                String user_ans = null;
                while(user_data.next())
                {
                    //fetch ans from database
                    user_ans = (String) user_data.getString("answer");
                    //apply check and set passworf in password text field
                    if(user_ans.equals(ans))
                    {
                        password_txt.setText(user_data.getString("password"));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect answer");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        //action performed on back button click
        else if(ae.getSource() == back)
        {
            //redirect to login page
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }
    
    public static void main(String args[])
    {
        new Forget_pass();
    }
    
}
