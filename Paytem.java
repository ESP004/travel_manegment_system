
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Paytem extends JFrame implements ActionListener{
    
    JButton back;
    
    Paytem()
    {
        //add textarea for load website
        JEditorPane pane = new JEditorPane();
        add(pane);
        
        try{
            //set page on textarea with the help of setpage() method
            pane.setPage("https://paytm.com/rent-payment");
            
        }catch(Exception e)
        {
            //handle exeception with the help of hatm on website
            pane.setContentType("text/html");
            pane.setText("<html>page not found , ERROR 404</html>");
        }
        
        //add scroll bar , takes a componenet as a arguement in which the scroll bar is placed
        JScrollPane sp = new JScrollPane(pane);
        add(sp);
        
        //View details button
        back = new JButton("Back");
        back.setBounds(650,50,100,30);
        back.setFont(new Font("Serif" , Font.BOLD , 20));
        back.addActionListener(this);
        pane.add(back);
        
        //deploy the frame
        //setLayout(null);
        setTitle("Paytem.com");
        getContentPane().setBackground(Color.WHITE);
        setSize(800,600);
        setLocation(500,150);
        setVisible(true);
    }
    
    public static void main(String args[])
    {
        new Paytem();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //action performed on back button click
        if(ae.getSource() == back)
        {
            //close the current frame
            setVisible(false);
            new Payment().setVisible(true);
        }
    }
}
