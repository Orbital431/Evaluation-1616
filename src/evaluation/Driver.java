package evaluation;

import javax.swing.*;
import evaluation.forms.*;

@SuppressWarnings("serial")
public class Driver extends JFrame
{
    JPanel pane = new JPanel();

    public Driver()
    {
    	new Startup();
    	new EvaluationExplorer();
//    	new PDFGenerator();
    }

    public static void main(String args[])
    {
        new Driver();
    }
}
