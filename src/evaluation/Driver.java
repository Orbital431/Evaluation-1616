package evaluation;

import java.io.IOException;
import javax.swing.*;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import evaluation.forms.*;
import evaluation.generators.PDFGenerator;

@SuppressWarnings("serial")
public class Driver extends JFrame
{
    JPanel pane = new JPanel();

    public Driver()
    {
    	new Startup();
    	new PDFGenerator();
    }

    public static void main(String args[])
    {
        new Driver();
    }
}
