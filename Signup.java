
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Signup extends JFrame implements ActionListener{
    
    JTextField username_txt , name_txt , ans_txt;
    JPasswordField password_txt;
    JComboBox sq_box;
    JButton create , back;
    
    Signup()
    {
        //create the panel for place the image
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(59, 223, 245));
        p1.setBounds(0, 0, 600, 500);
        p1.setLayout(null);
        add(p1);
        
        //add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
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
        username_txt.setBounds(250, 60, 250, 30);
        username_txt.setFont(new Font("Arial" , Font.BOLD , 15));
        username_txt.addActionListener(this);
        p1.add(username_txt);
        
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
        
        //add label for password
        JLabel password = new JLabel("Password  :");
        password.setBounds(100, 200, 150, 30);
        password.setFont(new Font("Arial" , Font.BOLD , 20));
        p1.add(password);
        //add textfield for password
        password_txt = new JPasswordField();
        password_txt.setBounds(250, 200, 250, 30);
        password_txt.setFont(new Font("Arial" , Font.BOLD , 15));
        password_txt.addActionListener(this);
        p1.add(password_txt);
        
        //add label for Security question
        JLabel sq = new JLabel("Security question :");
        sq.setBounds(100, 270, 150, 30);
        sq.setFont(new Font("Arial" , Font.BOLD , 15));
        p1.add(sq);
        //add textfield for Security question
        String choice[] = {"Favorite book" , "Favorite movie" , "Favorite song" , "Favorite person"};
        sq_box = new JComboBox(choice);
        sq_box.setBounds(250, 270, 250, 30);
        sq_box.setFont(new Font("Arial" , Font.BOLD , 15));
        sq_box.addActionListener(this);
        p1.add(sq_box);
        
        //add label for Answer
        JLabel ans = new JLabel("Answer :");
        ans.setBounds(100, 340, 150, 30);
        ans.setFont(new Font("Arial" , Font.BOLD , 20));
        p1.add(ans);
        //add textfield for Answer
        ans_txt = new JTextField();
        ans_txt.setBounds(250, 340, 250, 30);
        ans_txt.setFont(new Font("Arial" , Font.BOLD , 15));
        ans_txt.addActionListener(this);
        p1.add(ans_txt);
        
        //add buttons
        //add button for create
        create = new JButton("Create");
        create.setBounds(250, 400, 100, 30);
        create.setBackground(Color.WHITE);
        create.setFont(new Font("Arial" , Font.BOLD , 20));
        create.setForeground(new Color(59, 223, 245));
        create.addActionListener(this);
        p1.add(create);
        
        //add button for back
        back = new JButton("Back");
        back.setBounds(400, 400, 100, 30);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Arial" , Font.BOLD , 20));
        back.setForeground(new Color(59, 223, 245));
        back.addActionListener(this);
        p1.add(back);
        
        
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
        //action performed on create button click
        if(ae.getSource() == create)
        {
            //fetch data from the textfields
            String username = username_txt.getText().trim();
            String name = name_txt.getText().trim();
            String password = password_txt.getText().trim();
            //sq stands for security question
            String sq = (String) sq_box.getSelectedItem();
            String ans = ans_txt.getText().trim();
            
            //handle empty fields condition
            if(username.equals("") || name.equals("") || password.equals("") || sq.equals("") || ans.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Fill all of the avove");
            }
            else
            {
                //valadition for name
                if(valName(name) == false)
                {
                    JOptionPane.showMessageDialog(null, "Enter a valid name" , "Error" ,JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //valadition for user name
                if(valUserName(username) == false)
                {
                    JOptionPane.showMessageDialog(null, "Invalid Username" , "Error" ,JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //valadition fpr password
                if(valPassword(password) == false || isValid(password) == false)
                {
                    JOptionPane.showMessageDialog(null, "Enter a strong password" , "Error" ,JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Conn con = new Conn();
                String query = "insert into login values('"+username+"','"+password+"','"+name+"','"+sq+"','"+ans+"')";
                try {
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Sucessfull");
                    //redirect to login page
                    setVisible(false);
                    new Login().setVisible(true);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
    
    // logic for valadating name
    public static boolean valName(String name)
    {
        return name.matches("[a-zA-Z ]+");
    }
    
    // logic for valadating username
    public static boolean valUserName(String user_name)
    {
        return user_name.matches("[a-zA-Z0-9]+");
    }
    
    // logic for valadating password
    public static boolean valPassword(String password)
    {
        if(password.length() > 7)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //logic to check password is valid or not
    public static boolean isValid(String password)
    {
        boolean hasLow = false , hasUpper = false , hasSpacial = false , hasDigit = false , hasSpace = false;
        char c;
        if(password.contains("@") || password.contains("*") || password.contains("#"))
        {
            hasSpacial = true;
        }
        if(password.contains(" "))
        {
            hasSpace = true;
        }
        for(int i = 0 ; i < password.length() ; i++)
        {
            c = password.charAt(i);
            if(Character.isDigit(c))
            {
                hasDigit = true;
            }
            else if(Character.isLowerCase(c))
            {
                hasLow = true;
            }
            else if(Character.isUpperCase(c))
            {
                hasUpper = true;
            }
            
            if(hasSpacial == true && hasDigit == true && hasLow == true && hasUpper == true && hasSpace == false)
            {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String args[])
    {
        new Signup();
    }
}
