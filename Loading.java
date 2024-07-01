
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable{
    
    Thread thread;
    JProgressBar bar;
    String username;
    
    Loading(String username)
    {
        this.username = username;
        //add label for taxt
        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(50, 20, 500, 30);
        text.setFont(new Font("Arial" , Font.BOLD , 25));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150, 120, 300, 30);
        bar.setStringPainted(true);
        add(bar);
        
        //add label for loading
        JLabel loading = new JLabel("Loading , please wait .......");
        loading.setBounds(200, 160, 500, 30);
        loading.setFont(new Font("Syatem" , Font.BOLD , 15));
        loading.setForeground(Color.red);
        add(loading);
        
        //add label for loading
        JLabel wellcome = new JLabel("Wellcome  ");
        wellcome.setBounds(50, 400, 105, 30);
        wellcome.setFont(new Font("Serif" , Font.ITALIC , 20));
        wellcome.setForeground(Color.red);
        add(wellcome);
        
        //add label for loading
        JLabel username_lbl = new JLabel(username);
        username_lbl.setBounds(155, 400, 400, 30);
        username_lbl.setFont(new Font("Serif" , Font.BOLD , 20));
        add(username_lbl);
        
        
        thread = new Thread(this);
        thread.start();
        //deploy the frame
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(600,500);
        setLocation(450,180);
        setVisible(true);
    }
    
    //run method is use to apply effects on bar to make is running
    @Override
    public void run() {
        
        try{
            for(int i = 1 ; i <= 101 ; i++)
            {
                //getMaximum() is use to get maximum value of a bar
                int max = bar.getMaximum();
                // getvalue() method is use to get current value of bar
                int value = bar.getValue();
                
                if(value < max)
                {
                    //increase barvalue +1 in 50 mili sec
                    bar.setValue(bar.getValue() + 1);
                }
                else
                {
                    //redirect to dashboard page
                    setVisible(false);
                    new Dashboard(username).setVisible(true);
                }
                
                Thread.sleep(50);
            }
        }catch(Exception e){
            
        }
    }
    
    public static void main(String args[])
    {
        new Loading("");
    }

    
}
