package evaluation.forms;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;

public class Startup extends JFrame
{
    int sleepSeconds = 2;
    BufferedImage img = null;
    
    public Startup()
    {
        setTitle("Evaluation 1616");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 275);
        setLocationRelativeTo(null);
        setUndecorated(true);
        
        try
        {
        	img = ImageIO.read(new File("src/data/Navy-Logo.png"));
        	JLabel picLabel = new JLabel(new ImageIcon(img));
        	this.add(picLabel);
        	
        } catch (IOException e)
        {
        	e.printStackTrace();
        }
        
        setVisible(true);
        try{
            Thread.sleep(sleepSeconds*1000);
        } catch (InterruptedException e)
        {
            System.err.println("InterruptedException: " + e.getMessage());
        }
        setVisible(false);
        dispose();
    }
}
