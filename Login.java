
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField username_txt;
    JPasswordField password_txt;
    JButton login , signup , forget;
    
    Login()
    {
        //create the panel for place the image
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(59, 223, 245));
        p1.setBounds(0, 0, 400, 500);
        p1.setLayout(null);
        add(p1);
        
        //add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 130, 200, 200);
        p1.add(image);
        
        //add label for user name
        JLabel username = new JLabel("Username  :");
        username.setBounds(500, 130, 150, 30);
        username.setFont(new Font("Arial" , Font.BOLD , 20));
        add(username);
        //add textfield for username
        username_txt = new JTextField();
        username_txt.setBounds(650, 130, 250, 30);
        username_txt.setFont(new Font("Arial" , Font.BOLD , 15));
        username_txt.addActionListener(this);
        add(username_txt);
        
        //add label for user name
        JLabel password = new JLabel("Password  :");
        password.setBounds(500, 200, 150, 30);
        password.setFont(new Font("Arial" , Font.BOLD , 20));
        add(password);
        //add textfield for password
        password_txt = new JPasswordField();
        password_txt.setBounds(650, 200, 250, 30);
        password_txt.setFont(new Font("Arial" , Font.BOLD , 15));
        password_txt.addActionListener(this);
        add(password_txt);
        
        //add buttons
        //add button for login
        login = new JButton("Login");
        login.setBounds(500, 270, 150, 30);
        login.setBackground(new Color(59, 223, 245));
        login.setFont(new Font("Arial" , Font.BOLD , 20));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        //add button for signup
        signup = new JButton("Signup");
        signup.setBounds(750, 270, 150, 30);
        signup.setBackground(new Color(59, 223, 245));
        signup.setFont(new Font("Arial" , Font.BOLD , 20));
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        //add button for forget password
        forget = new JButton("Forget Password");
        forget.setBounds(580, 340, 240, 30);
        forget.setBackground(new Color(59, 223, 245));
        forget.setFont(new Font("Arial" , Font.BOLD , 20));
        forget.setForeground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        forget.addActionListener(this);
        add(forget);
        
        
        //deploy the frame
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,500);
        setLocation(250,150);
        setVisible(true);
    }
    
    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == login)
        {
            String username = username_txt.getText();
            String password = password_txt.getText();
            //handle empty fields condition
            if(username.equals("") || password.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Empty username or password");
            }
            else
            {
                Conn con = new Conn();
                try {
                    ResultSet user_data = con.s.executeQuery("select * from login where username = '"+username+"' and password = '"+password+"'");
                    if(user_data.next())
                    {
                        //redirect to loading page
                        setVisible(false);
                        new Loading(username).setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Credencials");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            
        }
        else if(ae.getSource() == signup)
        {
            //redirect to signup page
            setVisible(false);
            new Signup().setVisible(true);
        }
        else if(ae.getSource() == forget)
        {
            //redirect to signup page
            setVisible(false);
            new Forget_pass().setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new Login();
    }

    
    
}
