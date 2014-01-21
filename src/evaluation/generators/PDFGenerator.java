package evaluation.generators;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

@SuppressWarnings("unused")
public class PDFGenerator {
	
	  private String name, rate, desig, ssn;                                    //block 1-3 (ssn excluded)
	  private String duty_comp_status;                                          //block 5
	  private int UIC;                                                          //block 6
	  private String ship_station;                                              //block 7
	  private String promotion_status;                                          //block 8
	  private Date report_date;                                                 //block 9
	  //More than one occasion can apply, except that Special cannot be combined with another occasion.
	  //@TODO private String report_occasion_enum {PERIODIC, DETATCHMENT, PROMOTION, SPECIAL};  //block 10-13
	  private Date report_from;                                                 //block 14
	  private Date report_to;                                                   //block 15
	  private Boolean not_observed;                                             //block 16
	  //This field is used for Summary Group Comparison.
	  //@TODO private String report_type_enum {REGULAR, CONCURRENT};                            //block 17-19
	  //Enter specific PFA cycle identification information in block 29
	  private String physical_readiness;                                        //block 20
	  private String billet_subcategory;
	  private String reporting_senior;                                          //block 22
	  private String senior_grade;
	  private String senior_desig;
	  private String senior_title;                                              //block 25
	  private String senior_uic;                                                //block 26
	  private String senior_ssn;                                                //block 27
	  private String command_paragraph;                                         //block 28
	  //up to 14 characters or spaces
	  private String duty_abbrev;                                               //block 29 small box
	  private String duty_pfa_paragraph;                                        //block 29
	  private Date counsel_date;                                                //block 30
	  private String counselor;                                                 //block 31
	  private double individual_avg;                                            //block 40
	  private String career_recommend1, career_recommend2;                      //block 41
	  private String comments_on_performance;                                   //block 43
	  private String qualifications_achievements;                               //block 44
	  private Boolean retention;
	  private double summary_group_average;
	  
	  private static PDDocument _pdfDocument;
	
	  public PDFGenerator()
	  {
		  try {
			_pdfDocument = PDDocument.load("template.pdf");
			
		    printFields();
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  }
	  
	  public static void setField(String name, String value ) throws IOException {
	      PDDocumentCatalog docCatalog = _pdfDocument.getDocumentCatalog();
	      PDAcroForm acroForm = docCatalog.getAcroForm();
	      PDField field = acroForm.getField( name );
	      if( field != null ) {
	          field.setValue(value);
	      }
	      else {
	          System.err.println( "No field found with name:" + name );
	      }
	  }
	  @SuppressWarnings("rawtypes")
	  public static void printFields() throws IOException {
	      PDDocumentCatalog docCatalog = _pdfDocument.getDocumentCatalog();
	      PDAcroForm acroForm = docCatalog.getAcroForm();
	      List fields = acroForm.getFields();
	      Iterator fieldsIter = fields.iterator();
	 
	      System.out.println(new Integer(fields.size()).toString() + " top-level fields were found on the form");
	 
	      while( fieldsIter.hasNext()) {
	          PDField field = (PDField)fieldsIter.next();
	             processField(field, "|--", field.getPartialName());
	      }
	  }
	  @SuppressWarnings("rawtypes")
	  private static void processField(PDField field, String sLevel, String sParent) throws IOException
	  {
	      List kids = field.getKids();
	      if(kids != null) {
	          Iterator kidsIter = kids.iterator();
	          if(!sParent.equals(field.getPartialName())) {
	             sParent = sParent + "." + field.getPartialName();
	          }
	             
	          System.out.println(sLevel + sParent);
	             
	          while(kidsIter.hasNext()) {
	             Object pdfObj = kidsIter.next();
	             if(pdfObj instanceof PDField) {
	                 PDField kid = (PDField)pdfObj;
	                 processField(kid, "|  " + sLevel, sParent);
	             }
	          }
	       }
	       else {
	           String outputString = sLevel + sParent + "." + field.getPartialName() + ",  type=" + field.getClass().getName();
	           System.out.println(outputString);
	       }
	  }
	  
	  private void saveEvaluation()
	  {
		  try 
		  {
			  _pdfDocument.save("test_output.pdf");
		  } catch (COSVisitorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	  }
	  private void closeEvaluation()
	  {
		  try {
			_pdfDocument.close();
			if (_pdfDocument != null) _pdfDocument.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
