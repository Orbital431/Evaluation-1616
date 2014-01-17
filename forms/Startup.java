package Evaluation1616.forms;

import javax.swing.*;
import java.lang.Thread;

public class Startup extends JFrame
{
    int sleepSeconds = 2;
    public Startup()
    {
        setTitle("Evaluation 1616");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 275);
        setLocationRelativeTo(null);
        setUndecorated(true);
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
