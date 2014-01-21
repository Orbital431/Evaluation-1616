package evaluation.forms;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;

@SuppressWarnings("serial")
public class Startup extends JFrame
{
    int sleepSeconds = 3;
    String lblTxt;
    BufferedImage img = null;
    BufferedImage dimg;
    
    public Startup()
    {
        setTitle("Evaluation 1616");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 275);
        setLocationRelativeTo(null);
        setUndecorated(true);
        lblTxt = "<html><h1>Evaluation 1616</h1><br><h3>Created by Orbital431</h3></html>";
        
        try
        {
        	img = ImageIO.read(new File("src/data/Navy-Logo.png"));
        	dimg = resize(img, (int) this.getWidth()/2, (int) (this.getHeight()));
        	//JLabel picLabel = new JLabel(new ImageIcon(img));
        	JLabel picLabel = new JLabel(new ImageIcon(dimg), JLabel.LEFT);
        	picLabel.setText(lblTxt);
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
    
    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    
}
