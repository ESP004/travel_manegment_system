
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Payment extends JFrame implements ActionListener{
    
    JButton pay , back;
    
    Payment()
    {
        //add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,600);
        add(image);
        
        //View details button
        pay = new JButton("pay");
        pay.setBounds(50,50,100,30);
        pay.setFont(new Font("Serif" , Font.BOLD , 20));
        pay.addActionListener(this);
        image.add(pay);
        
        //View details button
        back = new JButton("Back");
        back.setBounds(650,50,100,30);
        back.setFont(new Font("Serif" , Font.BOLD , 20));
        back.addActionListener(this);
        image.add(back);
        
        //deploy the frame
        setLayout(null);
        setTitle("Payment");
        getContentPane().setBackground(Color.WHITE);
        setSize(800,600);
        setLocation(500,150);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == pay)
        {
            //redirect to paytem page
            setVisible(false);
            new Paytem().setVisible(true);
        }
        else if(ae.getSource() == back)
        {
            //close the current frame
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new Payment();
    }

    
}
