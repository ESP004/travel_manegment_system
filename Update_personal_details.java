
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class Update_personal_details extends JFrame implements ActionListener{
    
    JTextField username_txt , number_txt , name_txt , country_txt , address_txt , phone_txt , email_txt;
    JComboBox id_box , gender_box;
    JButton update , back;
    String username;
    
    Update_personal_details(String username)
    {
        this.username = username;
        
        //add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update_coustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 470, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,50,400,470);
        add(image);
        
        //add username label
        JLabel username_lbl = new JLabel("Username  :");
        username_lbl.setBounds(50,50,150,30);
        username_lbl.setFont(new Font("Serif" , Font.BOLD , 20));
        add(username_lbl);
        //add textfield for username
        username_txt = new JTextField();
        username_txt.setBounds(200,50,250,30);
        username_txt.setFont(new Font("Serif" , Font.BOLD , 15));
        add(username_txt);
        
        //add id label
        JLabel id = new JLabel("Id  :");
        id.setBounds(50,110,150,30);
        id.setFont(new Font("Serif" , Font.BOLD , 20));
        add(id);
        //add combobox for id
        String choise1[] = {"Adahar card" , "Passport" , "Voter-id-card" , "Ration card" , "Driving licence"};
        id_box = new JComboBox(choise1);
        id_box.setBackground(Color.WHITE);
        id_box.setBounds(200, 110, 250, 30);
        id_box.setFont(new Font("ARIAL",Font.BOLD,15));
        id_box.addActionListener(this);
        add(id_box);
        
        //add number label
        JLabel number = new JLabel("Number  :");
        number.setBounds(50,170,150,30);
        number.setFont(new Font("Serif" , Font.BOLD , 20));
        add(number);
        //add textfield for number
        number_txt = new JTextField();
        number_txt.setBounds(200,170,250,30);
        number_txt.setFont(new Font("Serif" , Font.BOLD , 15));
        add(number_txt);
        
        //add name label
        JLabel name = new JLabel("Name  :");
        name.setBounds(50,230,150,30);
        name.setFont(new Font("Serif" , Font.BOLD , 20));
        add(name);
        //add textfield for name
        name_txt = new JTextField();
        name_txt.setBounds(200,230,250,30);
        name_txt.setFont(new Font("Serif" , Font.BOLD , 15));
        add(name_txt);
        
        //add gender label
        JLabel gender = new JLabel("Grnder  :");
        gender.setBounds(50,290,150,30);
        gender.setFont(new Font("Serif" , Font.BOLD , 20));
        add(gender);
        //add textfield for username
        //add combobox for id
        String choise2[] = {"Male" , "Female"};
        gender_box = new JComboBox(choise2);
        gender_box.setBackground(Color.WHITE);
        gender_box.setBounds(200, 290, 250, 30);
        gender_box.setFont(new Font("ARIAL",Font.BOLD,15));
        gender_box.addActionListener(this);
        add(gender_box);
        
        //add username label
        JLabel country = new JLabel("Country  :");
        country.setBounds(50,350,150,30);
        country.setFont(new Font("Serif" , Font.BOLD , 20));
        add(country);
        //add textfield for username
        country_txt = new JTextField();
        country_txt.setBounds(200,350,250,30);
        country_txt.setFont(new Font("Serif" , Font.BOLD , 15));
        add(country_txt);
        
        //add address label
        JLabel address = new JLabel("Address  :");
        address.setBounds(50,410,150,30);
        address.setFont(new Font("Serif" , Font.BOLD , 20));
        add(address);
        //add textfield for address
        address_txt = new JTextField();
        address_txt.setBounds(200,410,250,30);
        address_txt.setFont(new Font("Serif" , Font.BOLD , 15));
        add(address_txt);
        
        //add username label
        JLabel phone = new JLabel("Phone no  :");
        phone.setBounds(50,470,150,30);
        phone.setFont(new Font("Serif" , Font.BOLD , 20));
        add(phone);
        //add textfield for username
        phone_txt = new JTextField();
        phone_txt.setBounds(200,470,250,30);
        phone_txt.setFont(new Font("Serif" , Font.BOLD , 15));
        add(phone_txt);
        
        //add email label
        JLabel email = new JLabel("Email  :");
        email.setBounds(50,530,150,30);
        email.setFont(new Font("Serif" , Font.BOLD , 20));
        add(email);
        //add textfield for username
        email_txt = new JTextField();
        email_txt.setBounds(200,530,250,30);
        email_txt.setFont(new Font("Serif" , Font.BOLD , 15));
        add(email_txt);
        
        //update button
        update = new JButton("Update");
        update.setBounds(200,590,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Serif" , Font.BOLD , 20));
        update.addActionListener(this);
        add(update);
        
        //back button
        back = new JButton("Back");
        back.setBounds(350,590,100,30);
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
                username_txt.setText(this.username);
                id_box.setSelectedItem(user_data.getString("id"));
                number_txt.setText(user_data.getString("number"));
                name_txt.setText(user_data.getString("name"));
                gender_box.setSelectedItem(user_data.getString("gender"));
                country_txt.setText(user_data.getString("country"));
                address_txt.setText(user_data.getString("address"));
                phone_txt.setText(user_data.getString("phone_no"));
                email_txt.setText(user_data.getString("email"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //deploy the frame
        setLayout(null);
        setTitle("Update personal details");
        getContentPane().setBackground(Color.WHITE);
        setSize(850,670);
        setLocation(480,150);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == update)
        {
            //apply valadition
            if(number_txt.getText().equals("") || username.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add personal details first");
                setVisible(false);
            }
            else
            {
                //fetch data from the user
                String new_username = username_txt.getText();
                String id = (String) id_box.getSelectedItem();
                String number = number_txt.getText();
                String name = name_txt.getText();
                String gender = (String) gender_box.getSelectedItem();
                String country = country_txt.getText();
                String address = address_txt.getText();
                String phone_no = phone_txt.getText();
                String email = email_txt.getText();
                //this condition is implemented to handele the empty updation on the data base
                if(new_username.equals("") || name.equals(""))
                {
                    setVisible(false);
                }
                else
                {
                        //valadition for specfic field
                        //email validation
                        if(valEmail(email) == false)
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error" ,JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        //phone no validation
                        if(valPhoneno(phone_no) == false)
                        {
                            JOptionPane.showMessageDialog(null, "phone no must may contain 10 digits", "Error" ,JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        //validation for id
                        if(id.equals("Adahar card"))
                        {
                            //adhar no valadition
                            if(valAdharno(number) == false)
                            {
                                JOptionPane.showMessageDialog(null, "Enter a valid adahar no" , "Error" ,JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }
                        else if(id.equals("Pan card"))
                        {
                            if(valPanno(number) == false)
                            {
                                JOptionPane.showMessageDialog(null, "Enter a valid Pan no" , "Error" ,JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }
                    //upload data into database
                    Conn con = new Conn();
                    String query = "update user_details set username = '"+new_username+"' , id = '"+id+"' , number = '"+number+"' , name = '"+name+"' , gender = '"+gender+"' , country = '"+country+"' , address = '"+address+"' , phone_no = '"+phone_no+"' , email = '"+email+"' where username = '"+this.username+"'";
                    String query2 = "update login set username = '"+new_username+"' , name = '"+name+"' where username = '"+this.username+"'";
                    try {
                            con.s.executeUpdate(query);
                            con.s.executeUpdate(query2);
                            JOptionPane.showMessageDialog(null, "Sucessfull");
                            //close the current frame
                            setVisible(false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            
        }
        else if(ae.getSource() == back)
        {
            //close the current frame
            setVisible(false);
        }
        
    }
    
    //logic for validate an email
    public static boolean valEmail(String email)
    {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex , Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }
    
    //logic for validating phone no
    public static boolean valPhoneno(String phone)
    {
        return phone.length() == 10 && phone.matches("[0-9]+");
    }
    
    //logic for validating adhar no
    public static boolean valAdharno(String adhar)
    {
        return adhar.length() == 12 && adhar.matches("[0-9]+");
    }
    
    //logic for validating pan no
    public static boolean valPanno(String pan_no)
    {
        return pan_no.length() == 10 && pan_no.matches("[A-Z0-9]+");
    }
    
    public static void main(String args[])
    {
        new Update_personal_details("");
    }
    
}
