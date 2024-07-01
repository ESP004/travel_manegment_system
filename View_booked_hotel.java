
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class View_booked_hotel extends JFrame implements ActionListener{
    
    String username;
    JLabel username_data , select_hotel_data , total_person_data , no_of_days_data , ac_non_ac_data , food_includerd_data , id_data , number_data , phone_data , total_price_data;
    JButton back;
    
    View_booked_hotel(String username)
    {
        
        this.username = username;
        
        //add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 390, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,110,400,390);
        add(image);
        
        //add label for username
        JLabel username_lbl = new JLabel("Username  :");
        username_lbl.setBounds(50, 50, 150, 30);
        username_lbl.setFont(new Font("Serif" , Font.BOLD , 20));
        add(username_lbl);
        //add lbl for fetched data
        username_data = new JLabel();
        username_data.setBounds(200,50,250,30);
        username_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(username_data);
        
        //add label for select package
        JLabel select_hotel = new JLabel("Select hotel :");
        select_hotel.setBounds(50, 105, 150, 30);
        select_hotel.setFont(new Font("Serif" , Font.BOLD , 20));
        add(select_hotel);
        //add jlable for fetched data
        select_hotel_data = new JLabel();
        select_hotel_data.setBounds(200,105,250,30);
        select_hotel_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(select_hotel_data);
        
        //add label for total person
        JLabel total_person = new JLabel("Total persons :");
        total_person.setBounds(50, 160, 150, 30);
        total_person.setFont(new Font("Serif" , Font.BOLD , 20));
        add(total_person);
        //add lable for fetched data
        total_person_data = new JLabel();
        total_person_data.setBounds(200, 160, 250, 30);
        total_person_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(total_person_data);
        
        //add label for No of days
        JLabel no_of_days = new JLabel("No of days :");
        no_of_days.setBounds(50, 215, 150, 30);
        no_of_days.setFont(new Font("Serif" , Font.BOLD , 20));
        add(no_of_days);
        //add lable for fetched data
        no_of_days_data = new JLabel();
        no_of_days_data.setBounds(200, 215, 250, 30);
        no_of_days_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(no_of_days_data);
        
        //add label for No of days
        JLabel ac_non_ac = new JLabel("Ac/ non-Ac :");
        ac_non_ac.setBounds(50, 270, 150, 30);
        ac_non_ac.setFont(new Font("Serif" , Font.BOLD , 20));
        add(ac_non_ac);
        //add lable for fetched data
        ac_non_ac_data = new JLabel();
        ac_non_ac_data.setBounds(200,270,250,30);
        ac_non_ac_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(ac_non_ac_data);
        
        //add label for No of days
        JLabel food_includerd = new JLabel("Food included :");
        food_includerd.setBounds(50, 325, 150, 30);
        food_includerd.setFont(new Font("Serif" , Font.BOLD , 20));
        add(food_includerd);
        //add lable for fetched data
        food_includerd_data = new JLabel();
        food_includerd_data.setBounds(200,325,250,30);
        food_includerd_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(food_includerd_data);
        
        //add label for id
        JLabel id = new JLabel("Id       :");
        id.setBounds(50, 380, 380, 30);
        id.setFont(new Font("Serif" , Font.BOLD , 20));
        add(id);
        //add lbl for fetched data
        id_data = new JLabel();
        id_data.setBounds(200,380,250,30);
        id_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(id_data);
        
        //add label for number
        JLabel number = new JLabel("Number  :");
        number.setBounds(50, 435, 150, 30);
        number.setFont(new Font("Serif" , Font.BOLD , 20));
        add(number);
        //add lbl for fetched data
        number_data = new JLabel();
        number_data.setBounds(200,435,250,30);
        number_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(number_data);
        
        //add label for phone no
        JLabel phone = new JLabel("Phone no  :");
        phone.setBounds(50, 490, 150, 30);
        phone.setFont(new Font("Serif" , Font.BOLD , 20));
        add(phone);
        //add lbl for fetched data
        phone_data = new JLabel();
        phone_data.setBounds(200,490,250,30);
        phone_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(phone_data);
        
        //add label for total price
        JLabel total_price = new JLabel("Total price :");
        total_price.setBounds(50, 545, 150, 30);
        total_price.setFont(new Font("Serif" , Font.BOLD , 20));
        add(total_price);
        //add lable for fetched data
        total_price_data = new JLabel();
        total_price_data.setBounds(200, 545, 250, 30);
        total_price_data.setFont(new Font("Serif" , Font.BOLD , 15));
        add(total_price_data);
        
        //fetchdata from user_details table and set on lable
        Conn con = new Conn();
        String query = "select * from booked_hotel where username = '"+this.username+"'";
        try {
            ResultSet hotel_data = con.s.executeQuery(query);
            if(hotel_data.next())
            {
                username_data.setText(this.username);
                select_hotel_data.setText(hotel_data.getString("hotel_name"));
                total_person_data.setText(hotel_data.getString("total_parson"));
                no_of_days_data.setText(hotel_data.getString("days"));
                ac_non_ac_data.setText(hotel_data.getString("ac"));
                food_includerd_data.setText(hotel_data.getString("food"));
                id_data.setText(hotel_data.getString("id"));
                number_data.setText(hotel_data.getString("number"));
                phone_data.setText(hotel_data.getString("phone"));
                total_price_data.setText(hotel_data.getString("total_price"));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Add personal details or book a hotel first");
                setVisible(false);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //View details button
        back = new JButton("Back");
        back.setBounds(200,595,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Serif" , Font.BOLD , 20));
        back.addActionListener(this);
        add(back);
        
        //deploy the frame
        setLayout(null);
        setTitle("View booked hotel");
        getContentPane().setBackground(Color.WHITE);
        setSize(950,670);
        setLocation(430,150);
        setVisible(true);
    }
    
    public static void main(String args[])
    {
        new View_booked_hotel("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == back)
        {
            //close the current frame
            setVisible(false);
        }
    }
    
}
