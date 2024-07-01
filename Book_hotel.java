
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Book_hotel extends JFrame implements ActionListener{
    
    String username;
    JLabel username_data , id_data , number_data , phone_data;
    JComboBox select_hotel_box , ac_non_ac_box , food_includerd_box;
    JTextField total_person_txt , no_of_days_txt , total_price_txt;
    JButton check_price , book_package , back;
    
    Book_hotel(String username)
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
        //username_data.addActionListener(this);
        add(username_data);
        
        //add label for select package
        JLabel select_hotel = new JLabel("Select hotel :");
        select_hotel.setBounds(50, 105, 150, 30);
        select_hotel.setFont(new Font("Serif" , Font.BOLD , 20));
        add(select_hotel);
        //add jcombobox for select package
        String[] choice = {"ITC RoyalBengal" , "JW Meriat"};
        select_hotel_box = new JComboBox(choice);
        select_hotel_box.setBounds(200,105,250,30);
        select_hotel_box.setFont(new Font("Serif" , Font.BOLD , 15));
        select_hotel_box.addActionListener(this);
        add(select_hotel_box);
        
        //add label for total person
        JLabel total_person = new JLabel("Total persons :");
        total_person.setBounds(50, 160, 150, 30);
        total_person.setFont(new Font("Serif" , Font.BOLD , 20));
        add(total_person);
        //add textfield for person
        total_person_txt = new JTextField();
        total_person_txt.setBounds(200, 160, 250, 30);
        total_person_txt.setFont(new Font("Serif" , Font.BOLD , 15));
        total_person_txt.addActionListener(this);
        add(total_person_txt);
        
        //add label for No of days
        JLabel no_of_days = new JLabel("No of days :");
        no_of_days.setBounds(50, 215, 150, 30);
        no_of_days.setFont(new Font("Serif" , Font.BOLD , 20));
        add(no_of_days);
        //add textfield for No of days
        no_of_days_txt = new JTextField();
        no_of_days_txt.setBounds(200, 215, 250, 30);
        no_of_days_txt.setFont(new Font("Serif" , Font.BOLD , 15));
        no_of_days_txt.addActionListener(this);
        add(no_of_days_txt);
        
        //add label for No of days
        JLabel ac_non_ac = new JLabel("Ac/ non-Ac :");
        ac_non_ac.setBounds(50, 270, 150, 30);
        ac_non_ac.setFont(new Font("Serif" , Font.BOLD , 20));
        add(ac_non_ac);
        //add jcombobox for select package
        String[] choice2 = {"Yes" , "No"};
        ac_non_ac_box = new JComboBox(choice2);
        ac_non_ac_box.setBounds(200,270,250,30);
        ac_non_ac_box.setFont(new Font("Serif" , Font.BOLD , 15));
        ac_non_ac_box.addActionListener(this);
        add(ac_non_ac_box);
        
        //add label for No of days
        JLabel food_includerd = new JLabel("Food included :");
        food_includerd.setBounds(50, 325, 150, 30);
        food_includerd.setFont(new Font("Serif" , Font.BOLD , 20));
        add(food_includerd);
        //add jcombobox for select package
        food_includerd_box = new JComboBox(choice2);
        food_includerd_box.setBounds(200,325,250,30);
        food_includerd_box.setFont(new Font("Serif" , Font.BOLD , 15));
        food_includerd_box.addActionListener(this);
        add(food_includerd_box);
        
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
        //add textfield for person
        total_price_txt = new JTextField();
        total_price_txt.setBounds(200, 545, 250, 30);
        total_price_txt.setFont(new Font("Serif" , Font.BOLD , 15));
        add(total_price_txt);
        
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
        
        //add button
        //back button
        check_price = new JButton("Check");
        check_price.setBounds(50,595,100,30);
        check_price.setBackground(Color.BLACK);
        check_price.setForeground(Color.WHITE);
        check_price.setFont(new Font("Serif" , Font.BOLD , 20));
        check_price.addActionListener(this);
        add(check_price);
        
        //back button
        book_package = new JButton("Book");
        book_package.setBounds(200,595,100,30);
        book_package.setBackground(Color.BLACK);
        book_package.setForeground(Color.WHITE);
        book_package.setFont(new Font("Serif" , Font.BOLD , 20));
        book_package.addActionListener(this);
        add(book_package);
        
        //back button
        back = new JButton("Back");
        back.setBounds(350,595,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Serif" , Font.BOLD , 20));
        back.addActionListener(this);
        add(back);
        
        //deploy the frame
        setLayout(null);
        setTitle("Book package");
        getContentPane().setBackground(Color.WHITE);
        setSize(950,670);
        setLocation(430,150);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        // actionPerformdd on the click of check button
        if(ae.getSource() == check_price)
        {
            //apply valadition
            if(number_data.getText().equals("") || username.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add personal details first");
                setVisible(false);
            }
            else
            {
                String hotel = (String) select_hotel_box.getSelectedItem();
                String person = total_person_txt.getText();
                String days = no_of_days_txt.getText();
                String ac_non_ac = (String) ac_non_ac_box.getSelectedItem();
                String food = (String)food_includerd_box.getSelectedItem();
                int price = 0;
                //handle empty fields
                if(person.equals("") || days.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Fill all the avove fields");
                }
                else
                {
                    String query = "select * from hotel_price where hotel_name = '"+hotel+"'";
                    Conn con = new Conn();
                    try {
                            ResultSet hotel_data = con.s.executeQuery(query);
                            while(hotel_data.next())
                            {
                                price = (Integer.parseInt(hotel_data.getString("price")) * Integer.parseInt(person)) * Integer.parseInt(days);
                                if(ac_non_ac == "Yes")
                                {
                                    price += Integer.parseInt(hotel_data.getString("with_ac"));
                                }
                                if(food == "Yes")
                                {
                                    price += Integer.parseInt(hotel_data.getString("with_food"));
                                }
                            }
                            total_price_txt.setText(Integer.toString(price));

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                
                
            }
        }
        // actionPerformdd on the click of book button
        else if(ae.getSource() == book_package)
        {
            
            try {
                String hotel = (String) select_hotel_box.getSelectedItem();
                String person = total_person_txt.getText();
                String days = no_of_days_txt.getText();
                String ac_non_ac = (String) ac_non_ac_box.getSelectedItem();
                String food = (String)food_includerd_box.getSelectedItem();
                String id = id_data.getText();
                String number = number_data.getText();
                String phone = phone_data.getText();
                String price = total_price_txt.getText();
                Conn con1 = new Conn();
                ResultSet room_data = con1.s.executeQuery("select * from booked_hotel where username = '"+this.username+"'");
                if(room_data.next())
                {
                    JOptionPane.showMessageDialog(null, "Hotel is alredy booked");
                }
                else
                {
                    //apply valadition for empty price
                    if(price.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Check the price first");
                        return;
                    }
                    //apply condition to handle null insertion and sucessfull box
                    if(id.equals("") || username.equals("") || number.equals(""))
                    {

                    }
                    else
                    {
                        String query = "insert into booked_hotel values('"+this.username+"','"+hotel+"','"+person+"','"+days+"','"+ac_non_ac+"','"+food+"','"+id+"','"+number+"','"+phone+"','"+price+"')";
                        Conn con = new Conn();
                        try {
                            con.s.executeUpdate(query);
                            JOptionPane.showMessageDialog(null, "Sucessfull");
                            //close the current frame
                            setVisible(false);

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
            // actionPerformdd on the click of back button
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else if(ae.getSource() == back)
        {
            //close the current frame
            setVisible(false);
        }
        
    }
    
    public static void main(String args[])
    {
        new Book_hotel("");
    }

    
    
}
