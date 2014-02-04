package evaluation;

import java.sql.SQLException;

import javax.swing.*;
import evaluation.forms.*;

@SuppressWarnings("serial")
public class Driver extends JFrame
{
    JPanel pane = new JPanel();

    public Driver() throws SQLException
    {
//    	new Startup();
    	new EvaluationExplorer();
//    	new PDFGenerator();
    }

    public static void main(String args[]) throws SQLException
    {
        new Driver();
    }
}
