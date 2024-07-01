
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JButton add_p_detail , update_p_detail , view_details , delete_p_detail , check_package , book_package , view_package , view_hotails , book_hotail , view_booked_hotail , destanation , payment , calculator , notepad , about; 
    String username;
    
    Dashboard(String username)
    {
        this.username = username;
        //create the panel 
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(16, 7, 107));
        p1.setBounds(0, 0,1600, 70);
        p1.setLayout(null);
        add(p1);
        
        //add upper logo image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel upper_logo_image = new JLabel(i3);
        upper_logo_image.setBounds(20,5,60,60);
        p1.add(upper_logo_image);
        
        //add label for dashboad
        JLabel dashboad = new JLabel("Dashboad");
        dashboad.setBounds(80, 15, 200, 40);
        dashboad.setFont(new Font("Serif" , Font.BOLD , 40));
        dashboad.setForeground(Color.WHITE);
        p1.add(dashboad);
        
        //create the panel 
        JPanel p2 = new JPanel();
        p2.setBackground(new Color(16, 7, 107));
        p2.setBounds(0, 70,300, 1500);
        p2.setLayout(null);
        add(p2);
        
        //add buttons
        //add personal detais button
        add_p_detail = new JButton("Add personal details");
        add_p_detail.setBounds(0,0,300,40);
        add_p_detail.setBackground(new Color(16, 7, 107));
        add_p_detail.setForeground(Color.WHITE);
        add_p_detail.setFont(new Font("Serif" , Font.BOLD , 20));
        add_p_detail.addActionListener(this);
        p2.add(add_p_detail);
        
        //Update personal detailss button
        update_p_detail = new JButton("Update personal details");
        update_p_detail.setBounds(0,40,300,40);
        update_p_detail.setBackground(new Color(16, 7, 107));
        update_p_detail.setForeground(Color.WHITE);
        update_p_detail.setFont(new Font("Serif" , Font.BOLD , 20));
        update_p_detail.addActionListener(this);
        p2.add(update_p_detail);
        
        //View details button
        view_details = new JButton("View details");
        view_details.setBounds(0,80,300,40);
        view_details.setBackground(new Color(16, 7, 107));
        view_details.setForeground(Color.WHITE);
        view_details.setFont(new Font("Serif" , Font.BOLD , 20));
        view_details.addActionListener(this);
        p2.add(view_details);
        
        //Delete personal details button
        delete_p_detail = new JButton("Delete personal details");
        delete_p_detail.setBounds(0,120,300,40);
        delete_p_detail.setBackground(new Color(16, 7, 107));
        delete_p_detail.setForeground(Color.WHITE);
        delete_p_detail.setFont(new Font("Serif" , Font.BOLD , 20));
        delete_p_detail.addActionListener(this);
        p2.add(delete_p_detail);
        
        //Check package button
        check_package = new JButton("Check package");
        check_package.setBounds(0,160,300,40);
        check_package.setBackground(new Color(16, 7, 107));
        check_package.setForeground(Color.WHITE);
        check_package.setFont(new Font("Serif" , Font.BOLD , 20));
        check_package.addActionListener(this);
        p2.add(check_package);
        
        //Book details button
        book_package = new JButton("Book package");
        book_package.setBounds(0,200,300,40);
        book_package.setBackground(new Color(16, 7, 107));
        book_package.setForeground(Color.WHITE);
        book_package.setFont(new Font("Serif" , Font.BOLD , 20));
        book_package.addActionListener(this);
        p2.add(book_package);
        
        //View package button
        view_package = new JButton("View package");
        view_package.setBounds(0,240,300,40);
        view_package.setBackground(new Color(16, 7, 107));
        view_package.setForeground(Color.WHITE);
        view_package.setFont(new Font("Serif" , Font.BOLD , 20));
        view_package.addActionListener(this);
        p2.add(view_package);
        
        //View hotails button
        view_hotails = new JButton("View hotel");
        view_hotails.setBounds(0,280,300,40);
        view_hotails.setBackground(new Color(16, 7, 107));
        view_hotails.setForeground(Color.WHITE);
        view_hotails.setFont(new Font("Serif" , Font.BOLD , 20));
        view_hotails.addActionListener(this);
        p2.add(view_hotails);
        
        //book hotails button
        book_hotail = new JButton("Book hotel");
        book_hotail.setBounds(0,320,300,40);
        book_hotail.setBackground(new Color(16, 7, 107));
        book_hotail.setForeground(Color.WHITE);
        book_hotail.setFont(new Font("Serif" , Font.BOLD , 20));
        book_hotail.addActionListener(this);
        p2.add(book_hotail);
        
        //View booked hotails button
        view_booked_hotail = new JButton("View booked hotel");
        view_booked_hotail.setBounds(0,360,300,40);
        view_booked_hotail.setBackground(new Color(16, 7, 107));
        view_booked_hotail.setForeground(Color.WHITE);
        view_booked_hotail.setFont(new Font("Serif" , Font.BOLD , 20));
        view_booked_hotail.addActionListener(this);
        p2.add(view_booked_hotail);
        
        //Destination button
        destanation = new JButton("Destination");
        destanation.setBounds(0,400,300,40);
        destanation.setBackground(new Color(16, 7, 107));
        destanation.setForeground(Color.WHITE);
        destanation.setFont(new Font("Serif" , Font.BOLD , 20));
        destanation.addActionListener(this);
        p2.add(destanation);
        
        //payment button
        payment = new JButton("Payment");
        payment.setBounds(0,440,300,40);
        payment.setBackground(new Color(16, 7, 107));
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font("Serif" , Font.BOLD , 20));
        payment.addActionListener(this);
        p2.add(payment);
        
        //Claculator button
        calculator = new JButton("Claculator");
        calculator.setBounds(0,480,300,40);
        calculator.setBackground(new Color(16, 7, 107));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Serif" , Font.BOLD , 20));
        calculator.addActionListener(this);
        p2.add(calculator);
        
        //Notepad button
        notepad = new JButton("Notepad");
        notepad.setBounds(0,520,300,40);
        notepad.setBackground(new Color(16, 7, 107));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Serif" , Font.BOLD , 20));
        notepad.addActionListener(this);
        p2.add(notepad);
        
        //About button
        about = new JButton("About");
        about.setBounds(0,560,300,40);
        about.setBackground(new Color(16, 7, 107));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Serif" , Font.BOLD , 20));
        about.addActionListener(this);
        p2.add(about);
        
        //add main
        ImageIcon main_i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image main_i2 = main_i1.getImage().getScaledInstance(1350, 900, Image.SCALE_DEFAULT);
        ImageIcon main_i3 = new ImageIcon(main_i2);
        JLabel main_image = new JLabel(main_i3);
        main_image.setBounds(300,70,1350,900);
        add(main_image);
        
        //add label for taxt
        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(250, 0, 1000, 45);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Serif" , Font.BOLD , 40));
        main_image.add(text);

        
        //deploy the frame
        setLayout(null);
        //function for full screen frame
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == add_p_detail)
        {
            //redirect to add personal details page
            new Add_personal_details(this.username);
        }
        else if(ae.getSource() == update_p_detail)
        {
            //redirect to update personal details page
            new Update_personal_details(username);
        }
        else if(ae.getSource() == view_details)
        {
            //redirect to view personal details page
            new View_details(this.username);
        }
        else if(ae.getSource() == delete_p_detail)
        {
            //redirect to delete personal details page
            new Delete_personal_details(this.username);
        }
        else if(ae.getSource() == check_package)
        {
            //redirect to check package page
            new Check_package();
        }
        else if(ae.getSource() == book_package)
        {
            //redirect to book package page
            new Book_package(this.username);
        }
        else if(ae.getSource() == view_package)
        {
            //redirect to view package page
            new View_package(this.username);
        }
        else if(ae.getSource() == view_hotails)
        {
            //redirect to view hotels page
            new View_hotel();
        }
        else if(ae.getSource() == book_hotail)
        {
            //redirect to Book hotel
            new Book_hotel(this.username);
        }
        else if(ae.getSource() == view_booked_hotail)
        {
            //redirect to vied Booked hotel
            new View_booked_hotel(this.username);
        }
        else if(ae.getSource() == destanation)
        {
            //redirect to view hotels page
            new View_destination();
        }
        else if(ae.getSource() == payment)
        {
            //redirect to payment page
            new Payment();
        }
        else if(ae.getSource() == calculator)
        {
            try {
                //Runtime class is use to run exe files on runtime with the help of member method getRuntime()
                //exec() method is used to get exe filrs
                //calc.exe is the name of calculator in windows
                Runtime.getRuntime().exec("calc.exe");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(ae.getSource() == notepad)
        {
            try {
                //notepad.exe is the name of calculator in windows
                Runtime.getRuntime().exec("notepad.exe");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(ae.getSource() == about)
        {
            //redirect to about page
            new About();
        }
        
    }
    
    public static void main(String args[])
    {
        new Dashboard("");
    }

    
}
