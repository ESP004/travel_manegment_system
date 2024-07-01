
package travel.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class View_destination extends JFrame implements Runnable{
    
    Thread t1;
    //10 labels for 10 images
    JLabel l1 , l2 , l3 , l4 , l5 , l6 , l7 , l8 , l9 , l10;
    JLabel label[] = new JLabel[]{l1 , l2 , l3 , l4 , l5 , l6 , l7 , l8 , l9 , l10};
    
    View_destination()
    {
        /*
        Here we created a slide show dynacmicly,
        concept is same like how we add image on the frame,
        but only difference is---
        ----------------------------------------------------------------------------------------
                //add single image
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/image name"));
                Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel image = new JLabel(i3);
                image.setBounds(0,0,800,600);
                add(image);
        -----------------------------------------------------------------------------------------
        we use array of Imageicon , Image , labels for load each image,
        and then setVisiible for particular point of time then make setVisible(false),with the help of thread class and run method
        */
            
        //array of image icon use to load 10 images
        ImageIcon i1 = null , i2 = null , i3 = null , i4 = null , i5 = null , i6 = null , i7 = null , i8 = null , i9 = null , i10 = null;
        ImageIcon[] image = new ImageIcon[]{i1 , i2 , i3 ,i4 , i5 , i6 , i7 , i8 , i9 , i10};
        
        //array of image use to sacle 10 images
        Image j1 = null , j2 = null , j3 = null , j4 = null , j5 = null , j6 = null , j7 = null , j8 = null , j9 = null , j10 = null;
        Image[] scaled_image = new Image[]{j1 , j2 , j3  , j4 , j5 , j6 , j7 , j8 , j9 , j10};
        
        //aeeay of image icon use to convert scales image into icon for place on the label
        ImageIcon k1 = null , k2 = null , k3 = null , k4 = null , k5 = null , k6 = null , k7 = null , k8 = null , k9 = null , k10 = null;
        ImageIcon[] converted_image = new ImageIcon[]{k1 , k2 , k3  , k4 , k5 , k6 , k7 , k8 , k9 , k10};
        
        //array for different image name
        String[] dest = {"dest1.jpeg" , "dest2.png" , "dest3.jpg" , "dest4.jpg" , "dest5.jpg" , "dest6.jpg" , "dest7.jpeg" , "dest8.jpg" , "dest9.jpg" , "dest10.jpg"};
        
        for(int i = 0 ; i < 10 ; i++)
        {
            //add image
            image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/"+dest[i]));
            scaled_image[i] = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            converted_image[i] = new ImageIcon(scaled_image[i]);
            label[i] = new JLabel(converted_image[i]);
            label[i].setBounds(0,0,800,600);
            add(label[i]);
        }
        
        t1 = new Thread(this);
        t1.start();
        
        //deploy the frame
        setTitle("View hotel");
        setSize(800,600);
        setLocation(500,150);
        setVisible(true);
    }
    
    public void run()
    {
        try{
            for(int i = 0 ; i <= 9 ; i++)
            {
                label[i].setVisible(true);
                Thread.sleep(2000);
                if(i >= 9)
                {
                    setVisible(false);
                }
                label[i].setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        new View_destination();
    }
}
