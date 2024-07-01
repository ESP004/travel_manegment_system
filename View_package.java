
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class View_package extends JFrame implements ActionListener{
    
    String username;
    JLabel username_data , selected_pkg_data , person_data , id_data , number_data , phone_data , price_data;
    JButton back;
    
    View_package(String username)
    {
        this.username = username;
        
        //add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 390, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,110,400,390);
        add(image);
        
        //add label for username
        JLabel main_lbl = new JLabel("View Package");
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
        
        //add label for Selected package
        JLabel selected_pkg = new JLabel("Selected package:");
        selected_pkg.setBounds(50, 170, 150, 30);
        selected_pkg.setFont(new Font("Serif" , Font.BOLD , 20));
        add(selected_pkg);
        //add lbl for fetched data
        selected_pkg_data = new JLabel();
        selected_pkg_data.setBounds(200,170,250,30);
        selected_pkg_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(selected_pkg_data);
        
        //add label for Total person
        JLabel person = new JLabel("Total person  :");
        person.setBounds(50, 230, 150, 30);
        person.setFont(new Font("Serif" , Font.BOLD , 20));
        add(person);
        //add lbl for fetched data
        person_data = new JLabel();
        person_data.setBounds(200,230,250,30);
        person_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(person_data);
        
        //add label for Id
        JLabel id = new JLabel("Id  :");
        id.setBounds(50, 290, 150, 30);
        id.setFont(new Font("Serif" , Font.BOLD , 20));
        add(id);
        //add lbl for fetched data
        id_data = new JLabel();
        id_data.setBounds(200,290,250,30);
        id_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(id_data);
        
        //add label for Number
        JLabel number = new JLabel("Number  :");
        number.setBounds(50, 350, 150, 30);
        number.setFont(new Font("Serif" , Font.BOLD , 20));
        add(number);
        //add lbl for fetched data
        number_data = new JLabel();
        number_data.setBounds(200,350,250,30);
        number_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(number_data);
        
        //add label for Phone no
        JLabel phone = new JLabel("Phone no  :");
        phone.setBounds(50, 410, 150, 30);
        phone.setFont(new Font("Serif" , Font.BOLD , 20));
        add(phone);
        //add lbl for fetched data
        phone_data = new JLabel();
        phone_data.setBounds(200,410,250,30);
        phone_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(phone_data);
        
        //add label for Price
        JLabel price = new JLabel("Price  :");
        price.setBounds(50, 470, 150, 30);
        price.setFont(new Font("Serif" , Font.BOLD , 20));
        add(price);
        //add lbl for fetched data
        price_data = new JLabel();
        price_data.setBounds(200,470,250,30);
        price_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(price_data);
        
        //View details button
        back = new JButton("Back");
        back.setBounds(200,530,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Serif" , Font.BOLD , 20));
        back.addActionListener(this);
        add(back);
        
        //set data on the taxt fielde
        Conn con = new Conn();
        String query = "select * from booked_pkg where username = '"+this.username+"'";
        try {
            ResultSet user_data = con.s.executeQuery(query);
            if(user_data.next())
            {
                username_data.setText(this.username);
                selected_pkg_data.setText(user_data.getString("package_type"));
                person_data.setText(user_data.getString("total_parson"));
                id_data.setText(user_data.getString("id"));
                number_data.setText(user_data.getString("number"));
                phone_data.setText(user_data.getString("phone"));
                price_data.setText(user_data.getString("total_price"));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Add personal details or book package first");
                setVisible(false);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //deploy the frame
        setLayout(null);
        setTitle("View package");
        getContentPane().setBackground(Color.WHITE);
        setSize(950,670);
        setLocation(430,150);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == back)
        {
            //close the current frame
            setVisible(false);
        }
        
    }
    
    public static void main(String args[])
    {
        new View_package("");
    }

    
    
}
