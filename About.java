
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener{
    
    JButton back;
    
    About()
    {
        
        String s = "Tourism Management System is a comprehensive software designed for the travel industry. \nIt is a dynamic and responsive system that addresses issues such as document management, lost records due to human error, etc.\n The goal is to create a system that handles all aspects of travel, such as scheduling, excursions, etc.";
                                                                                                                                                                                                                                                                                                                                                 
        //add label for username
        JLabel main_lbl = new JLabel("About");
        main_lbl.setBounds(200, 30, 300, 40);
        main_lbl.setFont(new Font("Serif" , Font.BOLD , 30));
        add(main_lbl);
        
        //Textarea is use to add taxt area
        //parameters (taxt , no of rows , no of column , scrollbar)
        TextArea area = new TextArea(s ,10 , 40 , Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20 , 70 , 460 , 400);
        add(area);
        
        //View details button
        back = new JButton("Back");
        back.setBounds(200,485,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Serif" , Font.BOLD , 20));
        back.addActionListener(this);
        add(back);
        
        //deploy the frame
        setLayout(null);
        setTitle("About");
        getContentPane().setBackground(Color.WHITE);
        setSize(500,600);
        setLocation(650,150);
        setVisible(true);
    }
    
    public static void main(String args[])
    {
        new About();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        // actionPerformdd on the click of back button
        if(ae.getSource() == back)
        {
            //close the current frame
            setVisible(false);
        }
    }
}
