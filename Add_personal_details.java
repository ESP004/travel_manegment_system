
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;
import javax.swing.*;

public class Add_personal_details extends JFrame implements ActionListener{
    
    JTextField username_txt , number_txt , name_txt , country_txt , address_txt , phone_txt , email_txt;
    JComboBox id_box , gender_box;
    JButton add , back;
    String username , name;
    JLabel usrname_fetched , name_fetched;
    
    Add_personal_details(String username)
    {
        this.username = username;
        
        //add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
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
        usrname_fetched = new JLabel();
        usrname_fetched.setBounds(200,50,250,30);
        usrname_fetched.setFont(new Font("Serif" , Font.BOLD , 15));
        usrname_fetched.setText(this.username);
        add(usrname_fetched);
        
        //add id label
        JLabel id = new JLabel("Id  :");
        id.setBounds(50,110,150,30);
        id.setFont(new Font("Serif" , Font.BOLD , 20));
        add(id);
        //add combobox for id
        String choise1[] = {"Adahar card" , "Pan card"};
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
        name_fetched = new JLabel();
        name_fetched.setBounds(200,230,250,30);
        name_fetched.setFont(new Font("Serif" , Font.BOLD , 15));
        add(name_fetched);
        //set name fetched from login table
        Conn con = new Conn();
        try {
            ResultSet user_data = con.s.executeQuery("select * from login where username = '"+this.username+"'");
            while(user_data.next())
            {
                name_fetched.setText(user_data.getString("name"));
                this.name = user_data.getString("name");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
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
        
        //View details button
        add = new JButton("Add");
        add.setBounds(200,590,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Serif" , Font.BOLD , 20));
        add.addActionListener(this);
        add(add);
        
        //View details button
        back = new JButton("Back");
        back.setBounds(350,590,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Serif" , Font.BOLD , 20));
        back.addActionListener(this);
        add(back);
        
        
        //deploy the frame
        setLayout(null);
        setTitle("Add personal details");
        getContentPane().setBackground(Color.WHITE);
        setSize(850,670);
        setLocation(480,150);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //action performed on add button
        if(ae.getSource() == add)
        {
            try {
                //fetch data from the user
                String id = (String) id_box.getSelectedItem();
                String number = number_txt.getText();
                String gender = (String) gender_box.getSelectedItem();
                String country = country_txt.getText();
                String address = address_txt.getText();
                String phone_no = phone_txt.getText();
                String email = email_txt.getText();
                //check personal details is alredy added or not
                Conn con1 = new Conn();
                ResultSet user_data = con1.s.executeQuery("select * from user_details where username = '"+this.username+"'");
                if(user_data.next())
                {
                    JOptionPane.showMessageDialog(null, "personal details is alredy added");
                }
                else
                {
                    //apply validation
                    if(id.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Please fill all avove");                        
                    }
                    else if(number.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Please fill all avove");
                    }
                    else if(number.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Please fill all avove");
                    }
                    else if(name.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Please fill all avove");
                    }
                    else if(gender.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Please fill all avove");
                    }
                    else if(country.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Please fill all avove");
                    }
                    else if(address.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Please fill all avove");
                    }
                    else if(phone_no.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Please fill all avove");
                    }
                    else if(email.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Please fill all avove");
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
                        String query = "insert into user_details values('"+this.username+"','"+id+"','"+number+"','"+this.name+"','"+gender+"','"+country+"','"+address+"','"+phone_no+"','"+email+"')";
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
            //action performed on back button
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
        new Add_personal_details("");
    }

}
