
package travel.manegment.system;

import javax.swing.*;
import java.awt.*;

public class AASplash extends JFrame implements Runnable{
    
    Thread thread;
    
    AASplash()
    {
        //add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200, 600);
        add(image);
        
        /*
        create  a thread for auto closing after 7 sec
        declared in run method of runnable class
        */
        thread = new Thread(this);
        thread.start();
        
        setUndecorated(true);
        setVisible(true);
    }
    
    
    @Override
    public void run() {
        
        try {
            //for auto close
            thread.sleep(5000);
            setVisible(false);
            new Login().setVisible(true);
        } catch (InterruptedException ex) {
            
        }
    }
    
    
    public static void main(String args[])
    {
        AASplash frame = new AASplash();
        /*
        deploy the splash frame
        by place the size and location of the frame dynacmicly
        */
        int x = 1;
        for(int i = 1 ; i <= 300 ; x += 15 , i += 6)
        {
            frame.setSize(x , i*2);
            frame.setLocation(750 - (x/2), 400 - i);
            
            try {
                //this thread is used for delay 
                Thread.sleep(7);
            } catch (InterruptedException ex) {
               
            }
            
        }
    }
    
}
