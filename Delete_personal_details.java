package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Delete_personal_details extends JFrame implements ActionListener{
    
    JLabel username_data ,id_data , number_data , name_data , gender_data , country_data , address_data , phone_no_data , email_data;
    String username;
    JButton delete;
    
    Delete_personal_details(String username)
    {
        this.username = username;
        
        //add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(626, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,370,626,300);
        add(image);
        
        //add username label
        JLabel username_lbl = new JLabel("Username :");
        username_lbl.setBounds(50,60,100,30);
        username_lbl.setFont(new Font("Serif" , Font.BOLD , 20));
        add(username_lbl);
        //add lbl for fetched data
        username_data = new JLabel();
        username_data.setBounds(250,60,250,30);
        username_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(username_data);
        
        //add id label
        JLabel id = new JLabel("Id  :");
        id.setBounds(50,120,100,30);
        id.setFont(new Font("Serif" , Font.BOLD , 20));
        add(id);
        //add lbl for fetched data
        id_data = new JLabel();
        id_data.setBounds(250,120,250,30);
        id_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(id_data);
        
        //add number label
        JLabel number = new JLabel("Number  :");
        number.setBounds(50,180,100,30);
        number.setFont(new Font("Serif" , Font.BOLD , 20));
        add(number);
        //add lbl for fetched data
        number_data = new JLabel();
        number_data.setBounds(250,180,250,30);
        number_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(number_data);
        
        //add name label
        JLabel name = new JLabel("Name  :");
        name.setBounds(50,240,100,30);
        name.setFont(new Font("Serif" , Font.BOLD , 20));
        add(name);
        //add lbl for fetched data
        name_data = new JLabel();
        name_data.setBounds(250,240,250,30);
        name_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(name_data);
        
        //add gender label
        JLabel gender = new JLabel("Grnder  :");
        gender.setBounds(50,300,100,30);
        gender.setFont(new Font("Serif" , Font.BOLD , 20));
        add(gender);
        //add lbl for fetched data
        gender_data = new JLabel();
        gender_data.setBounds(250,300,250,30);
        gender_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(gender_data);
        
        //add username label
        JLabel country = new JLabel("Country  :");
        country.setBounds(450,60,100,30);
        country.setFont(new Font("Serif" , Font.BOLD , 20));
        add(country);
        //add lbl for fetched data
        country_data = new JLabel();
        country_data.setBounds(550,60,250,30);
        country_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(country_data);
        
        //add address label
        JLabel address = new JLabel("Address  :");
        address.setBounds(450,120,100,30);
        address.setFont(new Font("Serif" , Font.BOLD , 20));
        add(address);
        //add lbl for fetched data
        address_data = new JLabel();
        address_data.setBounds(550,120,250,30);
        address_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(address_data);
        
        //add username label
        JLabel phone = new JLabel("Phone no  :");
        phone.setBounds(450,180,100,30);
        phone.setFont(new Font("Serif" , Font.BOLD , 20));
        add(phone);
        //add lbl for fetched data
        phone_no_data = new JLabel();
        phone_no_data.setBounds(550,180,250,30);
        phone_no_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(phone_no_data);
        
        //add email label
        JLabel email = new JLabel("Email  :");
        email.setBounds(450,240,100,30);
        email.setFont(new Font("Serif" , Font.BOLD , 20));
        add(email);
        //add lbl for fetched data
        email_data = new JLabel();
        email_data.setBounds(550,240,250,30);
        email_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(email_data);
        
        //fetchdata from user_details table and set on lable
        Conn con = new Conn();
        String query = "select * from user_details where username = '"+this.username+"'";
        try {
            ResultSet user_data = con.s.executeQuery(query);
            while(user_data.next())
            {
                username_data.setText(this.username);
                id_data.setText(user_data.getString("id"));
                number_data.setText(user_data.getString("number"));
                name_data.setText(user_data.getString("name"));
                gender_data.setText(user_data.getString("gender"));
                country_data.setText(user_data.getString("country"));
                address_data.setText(user_data.getString("address"));
                phone_no_data.setText(user_data.getString("phone_no"));
                email_data.setText(user_data.getString("email"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //View details button
        delete = new JButton("Delete");
        delete.setBounds(726,500,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Serif" , Font.BOLD , 20));
        delete.addActionListener(this);
        add(delete);
        
        //deploy the frame
        setLayout(null);
        setTitle("View details");
        getContentPane().setBackground(Color.WHITE);
        setSize(850,670);
        setLocation(480,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        // actionPerformdd on the click of delete button
        if(ae.getSource() == delete)
        {
            //apply valadition
            if(number_data.getText().equals("") || username.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add personal details first");
                setVisible(false);
            }
            else
            {
                Conn con = new Conn();
                try {
                    con.s.executeUpdate("delete from user_details where username = '"+this.username+"'");
                    con.s.executeUpdate("delete from booked_pkg where username = '"+this.username+"'");
                    con.s.executeUpdate("delete from booked_hotel where username = '"+this.username+"'");
                    JOptionPane.showMessageDialog(null, "Sucessfull");
                    System.exit(0);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
    }
    
    public static void main(String args[])
    {
        new Delete_personal_details("");
    }
}

