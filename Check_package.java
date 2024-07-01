
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Check_package extends JFrame{
    
    Check_package()
    {
        
        String[] package1 = {"BRONZE PACKAGE" , "4 days and 5 nights" , "Return Airfair" , "Free Clubing" , "Welcome Drinks at Arrival" , "Daily buffet" , "Stay in 5 Star hotail" , "BBQ Dinner" , "Book now" , "Winter Spacial" , "Rs 12000/-" , "package3.jpg"};
        String[] package2 = {"SILVER PACKAGE" , "5 days and 6 nights" , "Toll free & Enteence free" , "Meet and Greet at Airpot" , "Welcome Drinks at Arrival" , "Night Safari" , "Full Day 3 Island Cruse" , "Cruse with Driver" , "Book Now" , "Winter Spacial" , "Rs 20000/-" , "package2.jpg"};
        String[] package3 = {"GOLD PACKAGE" , "6 days and 7 nights" , "Airpote Assitance" , "half Day City Tour" , "Daily Buffer" , "Welcome Dirnks on Arrival" , "Full 3 Day Island Curse" , "English Speakin Guide" , "Book Now" , "Summer Spacial" , "Rs 28000/-" , "package1.jpg"};
        
        
        //add tab on panel
        JTabbedPane tab = new JTabbedPane();
        tab.setBounds(0, 0, 850, 30);
        //add option and panel on tab  [for panel 1]
        JPanel p1 = createpackage(package1);
        tab.addTab("package1" , null , p1);
        //add option and panel on tab [for panel 2]
        JPanel p2 = createpackage(package2);
        tab.addTab("package2" , null , p2);
        //add option and panel on tab [for panel 3]
        JPanel p3 = createpackage(package3);
        tab.addTab("package3" , null , p3);
        add(tab);

        
        //deploy the frame
        setTitle("Check package");
        getContentPane().setBackground(Color.WHITE);
        setSize(850,670);
        setLocation(480,150);
        setVisible(true);
    }
    
    public JPanel createpackage(String[] pkg)
    {
        
        //creat a panel for holding all items
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        
        //first label for package name
        JLabel l1 = new JLabel(pkg[0]);
        l1.setBounds(50, 10, 400, 40);
        l1.setForeground(new Color(250, 214, 10));
        l1.setFont(new Font("Serif" , Font.BOLD , 40));
        p.add(l1);
        
        //define about fratures of selected package
        //freature 1
        JLabel l2 = new JLabel(pkg[1]);
        l2.setBounds(30, 80, 350, 30);
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Serif" , Font.BOLD , 20));
        p.add(l2);
        
        //freature 2
        JLabel l3 = new JLabel(pkg[2]);
        l3.setBounds(30, 140, 350, 30);
        l3.setForeground(Color.RED);
        l3.setFont(new Font("Serif" , Font.BOLD , 20));
        p.add(l3);
        
        //freature 3
        JLabel l4 = new JLabel(pkg[3]);
        l4.setBounds(30, 200, 350, 30);
        l4.setForeground(Color.BLUE);
        l4.setFont(new Font("Serif" , Font.BOLD , 20));
        p.add(l4);
        
        //freature 4
        JLabel l5 = new JLabel(pkg[4]);
        l5.setBounds(30, 260, 350, 30);
        l5.setForeground(Color.RED);
        l5.setFont(new Font("Serif" , Font.BOLD , 20));
        p.add(l5);
        
        //freature 5
        JLabel l6 = new JLabel(pkg[5]);
        l6.setBounds(30, 320, 350, 30);
        l6.setForeground(Color.BLUE);
        l6.setFont(new Font("Serif" , Font.BOLD , 20));
        p.add(l6);
        
        //freature 6
        JLabel l7 = new JLabel(pkg[6]);
        l7.setBounds(30, 380, 350, 30);
        l7.setForeground(Color.RED);
        l7.setFont(new Font("Serif" , Font.BOLD , 20));
        p.add(l7);
        
        //freature 7
        JLabel l8 = new JLabel(pkg[7]);
        l8.setBounds(30, 440, 350, 30);
        l8.setForeground(Color.BLUE);
        l8.setFont(new Font("Serif" , Font.BOLD , 20));
        p.add(l8);
        
        //Book now lable
        JLabel l9 = new JLabel(pkg[8]);
        l9.setBounds(50, 500, 400, 30);
        l9.setForeground(new Color(250, 214, 10));
        l9.setFont(new Font("Serif" , Font.ITALIC , 30));
        p.add(l9);
        
        //best value like summer spacial lbl
        JLabel l10 = new JLabel(pkg[9]);
        l10.setBounds(300, 560, 300, 30);
        l10.setForeground(new Color(250, 214, 10));
        l10.setFont(new Font("Serif" , Font.BOLD , 28));
        p.add(l10);
        
        //pricr lbl
        JLabel l11 = new JLabel(pkg[10]);
        l11.setBounds(650, 560, 200, 30);
        l11.setForeground(Color.RED);
        l11.setFont(new Font("Serif" , Font.BOLD , 30));
        p.add(l11);
        
        //add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pkg[11]));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 80 , 400, 400);
        p.add(image);

        return p;
        
    }
    
    public static void main(String args[])
    {
        new Check_package();
    }
    
}
