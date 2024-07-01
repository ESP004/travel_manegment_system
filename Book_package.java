
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Book_package extends JFrame implements ActionListener{
    
    JLabel username_data , id_data , number_data , phone_data;
    JComboBox select_pkg_box;
    JTextField total_person_txt , total_price_txt;
    JButton check_price , book_package , back;
    String username;
    
    Book_package(String username)
    {
        this.username = username;
        
        //add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 390, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,110,400,390);
        add(image);
        
        //add label for username
        JLabel main_lbl = new JLabel("Book Package");
        main_lbl.setBounds(150, 40, 350, 40);
        main_lbl.setFont(new Font("Serif" , Font.BOLD , 30));
        add(main_lbl);
        
        //add label for username
        JLabel username_lbl = new JLabel("Username  :");
        username_lbl.setBounds(50, 110, 150, 30);
        username_lbl.setFont(new Font("Serif" , Font.BOLD , 20));
        add(username_lbl);
        //add lbl for fetched data
        username_data = new JLabel();
        username_data.setBounds(200,110,250,30);
        username_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(username_data);
        
        //add label for select package
        JLabel select_pkg = new JLabel("Select package :");
        select_pkg.setBounds(50, 170, 150, 30);
        select_pkg.setFont(new Font("Serif" , Font.BOLD , 20));
        add(select_pkg);
        //add jcombobox for select package
        String[] choice = {"GOLD PACKAGE" , "SILVER PACKAGE" , "BRONZE PACKAGE"};
        select_pkg_box = new JComboBox(choice);
        select_pkg_box.setBounds(200,170,250,30);
        select_pkg_box.setFont(new Font("Serif" , Font.BOLD , 15));
        add(select_pkg_box);
        
        //add label for total person
        JLabel total_person = new JLabel("Total persons :");
        total_person.setBounds(50, 230, 150, 30);
        total_person.setFont(new Font("Serif" , Font.BOLD , 20));
        add(total_person);
        //add textfield for person
        total_person_txt = new JTextField();
        total_person_txt.setBounds(200, 230, 250, 30);
        total_person_txt.setFont(new Font("Serif" , Font.BOLD , 15));
        add(total_person_txt);
        
        //add label for id
        JLabel id = new JLabel("Id       :");
        id.setBounds(50, 290, 150, 30);
        id.setFont(new Font("Serif" , Font.BOLD , 20));
        add(id);
        //add lbl for fetched data
        id_data = new JLabel();
        id_data.setBounds(200,290,250,30);
        id_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(id_data);
        
        //add label for number
        JLabel number = new JLabel("Number  :");
        number.setBounds(50, 350, 150, 30);
        number.setFont(new Font("Serif" , Font.BOLD , 20));
        add(number);
        //add lbl for fetched data
        number_data = new JLabel();
        number_data.setBounds(200,350,250,30);
        number_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(number_data);
        
        //add label for phone no
        JLabel phone = new JLabel("Phone no  :");
        phone.setBounds(50, 410, 150, 30);
        phone.setFont(new Font("Serif" , Font.BOLD , 20));
        add(phone);
        //add lbl for fetched data
        phone_data = new JLabel();
        phone_data.setBounds(200,410,250,30);
        phone_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(phone_data);
        
        //add label for total price
        JLabel total_price = new JLabel("Total price :");
        total_price.setBounds(50, 470, 150, 30);
        total_price.setFont(new Font("Serif" , Font.BOLD , 20));
        add(total_price);
        //add textfield for person
        total_price_txt = new JTextField();
        total_price_txt.setBounds(200, 470, 250, 30);
        total_price_txt.setFont(new Font("Serif" , Font.BOLD , 15));
        add(total_price_txt);
        
        //add button
        //back button
        check_price = new JButton("Check");
        check_price.setBounds(50,530,100,30);
        check_price.setBackground(Color.BLACK);
        check_price.setForeground(Color.WHITE);
        check_price.setFont(new Font("Serif" , Font.BOLD , 20));
        check_price.addActionListener(this);
        add(check_price);
        
        //back button
        book_package = new JButton("Book");
        book_package.setBounds(200,530,100,30);
        book_package.setBackground(Color.BLACK);
        book_package.setForeground(Color.WHITE);
        book_package.setFont(new Font("Serif" , Font.BOLD , 20));
        book_package.addActionListener(this);
        add(book_package);
        
        //back button
        back = new JButton("Back");
        back.setBounds(350,530,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Serif" , Font.BOLD , 20));
        back.addActionListener(this);
        add(back);
        
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
                phone_data.setText(user_data.getString("phone_no"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //deploy the frame
        setLayout(null);
        setTitle("Book package");
        getContentPane().setBackground(Color.WHITE);
        setSize(950,670);
        setLocation(430,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        // actionPerformdd on the click of check button
        if(ae.getSource() == check_price)
        {
            //apply valadition to handel update empty string
            if(number_data.getText().equals("") || username.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add personal details first");
                setVisible(false);
            }
            //apply condition for empty fields
            else if(select_pkg_box.getSelectedItem().equals("") || total_person_txt.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Fill the empty fields");
            }
            else
            {
                String pkg = (String) select_pkg_box.getSelectedItem();
                String person = total_person_txt.getText();

                int price = 0;
                Conn con = new Conn();
                try {
                    ResultSet pkg_data = con.s.executeQuery("select * from pkg_price where package = '"+pkg+"'");
                    while(pkg_data.next())
                    {
                        price = Integer.parseInt(pkg_data.getString("price")) * Integer.parseInt(person);
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                total_price_txt.setText(Integer.toString(price));
            }     
        }
        // actionPerformdd on the click of book button
        else if(ae.getSource() == book_package)
        {
            try {
                //fetch data from textfields
                String pkg = (String) select_pkg_box.getSelectedItem();
                String person = total_person_txt.getText();
                String id = id_data.getText();
                String number = number_data.getText();
                String phone = phone_data.getText();
                String price = total_price_txt.getText();
                //check personal details is alredy added or not
                Conn con1 = new Conn();
                ResultSet pkg_data = con1.s.executeQuery("select * from booked_pkg where username = '"+this.username+"'");
                if(pkg_data.next())
                {
                    JOptionPane.showMessageDialog(null, "One package is alredy booked");
                }
                else
                {
                    //apply valadition for empty price
                    if(price.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Check the price first");
                        return;
                    }
                    //valisation to handle emply string on the database
                    if(username.equals("") || number.equals("") || id.equals(""))
                    {
                        return;
                    }
                    else
                    {
                        Conn con = new Conn();
                        String query = "insert into booked_pkg values('"+username+"','"+pkg+"','"+person+"','"+id+"','"+number+"','"+phone+"','"+price+"')";
                        try {
                            con.s.executeLargeUpdate(query);
                            JOptionPane.showMessageDialog(null, "Sucessfull");
                            setVisible(false);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
            // actionPerformdd on the click of back button
            catch (SQLException ex) {
                Logger.getLogger(Book_package.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ae.getSource() == back)
        {
            //close the current frame
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new Book_package("");
    }
    
}
